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

package com.smartstudio.fbclm.network.splash;

import com.smartstudio.fbclm.controller.SplashController;
import com.smartstudio.fbclm.model.League;
import com.smartstudio.fbclm.network.NetworkManager;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * TODO Add javadoc documentation
 */
public class SplashNetworkManagerImpl implements SplashNetworkManager {
    private final SplashController mController;
    private final NetworkManager mNetworkManager;
    private Subscription mSubscription;

    @Inject
    public SplashNetworkManagerImpl(SplashController controller, NetworkManager networkManager) {
        mController = controller;
        mNetworkManager = networkManager;
    }


    @Override
    public void requestLeagues() {
        createLeaguesObservable(false)
                .onErrorResumeNext(createLeaguesObservable(true))
                .subscribe(mController::onLeaguesLoaded, throwable -> Timber.e(throwable, throwable.getMessage()));
    }

    @Override
    public void cancelRequest() {
        if (mSubscription != null) {
            mSubscription.unsubscribe();
            mSubscription = null;
        }
    }

    private Observable<List<League>> createLeaguesObservable(boolean forceCache) {
        Observable<List<League>> leaguesObservable = Observable.create(subscriber ->
                mNetworkManager.requestLeagues(104, forceCache));
        return leaguesObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
