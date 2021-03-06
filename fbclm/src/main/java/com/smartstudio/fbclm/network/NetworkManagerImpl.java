/*
 * Copyright 2015 Smart Studio
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.smartstudio.fbclm.network;

import com.smartstudio.fbclm.controllers.DataController;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * TODO Add javadoc documentation
 */
public abstract class NetworkManagerImpl<T> implements NetworkManager {
    protected final DataController<T> mController;
    protected final NetworkHelper mNetworkHelper;
    private Subscription mSubscription;

    public NetworkManagerImpl(DataController<T> controller, NetworkHelper networkHelper) {
        mController = controller;
        mNetworkHelper = networkHelper;
    }

    @Override
    public void loadData() {
        Observable<T> observable = createDataObservable(false);
        Observable.concat(createDataObservable(true), observable)
                .onErrorResumeNext(observable)
                .subscribe(mController::onDataLoaded, this::onError);
    }

    @Override
    public void cancelRequest() {
        if (mSubscription != null) {
            mSubscription.unsubscribe();
            mSubscription = null;
        }
    }

    protected Observable<T> createDataObservable(boolean forceCache) {
        return Observable.create(onSubscribe(forceCache))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private Observable.OnSubscribe<T> onSubscribe(boolean forceCache) {
        return subscriber -> {
            subscriber.onNext(requestData(forceCache));
            subscriber.onCompleted();
        };
    }

    protected abstract T requestData(boolean forceCache);

    protected void onError(Throwable throwable) {
        Timber.e(throwable, throwable.getMessage());
        mController.onDataError();
    }
}
