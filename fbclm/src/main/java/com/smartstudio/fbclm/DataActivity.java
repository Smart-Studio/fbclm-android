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

package com.smartstudio.fbclm;

import com.smartstudio.fbclm.controller.Controller;
import com.smartstudio.fbclm.network.splash.NetworkManager;
import com.smartstudio.fbclm.ui.FbclmView;

import javax.inject.Inject;

/**
 * TODO Add javadoc documentation
 */
public abstract class DataActivity<T> extends BaseActivity implements Controller<T> {

    @Inject
    FbclmView<T> mView;
    @Inject
    NetworkManager mNetworkManager;


    @Override
    protected void onStart() {
        super.onStart();
        mNetworkManager.loadData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mNetworkManager.cancelRequest();
    }

    @Override
    public void onDataLoaded(T data) {
        mView.showData(data);
    }
}
