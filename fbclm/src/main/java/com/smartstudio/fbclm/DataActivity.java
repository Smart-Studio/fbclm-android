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

import android.os.Bundle;
import android.support.annotation.CallSuper;

import com.smartstudio.fbclm.controllers.DataController;
import com.smartstudio.fbclm.network.NetworkInfoReceiver;
import com.smartstudio.fbclm.network.NetworkManager;

import javax.inject.Inject;

/**
 * TODO Add javadoc documentation
 */
public abstract class DataActivity<T> extends BaseActivity implements DataController<T> {

    @Inject
    NetworkManager mNetworkManager;
    @Inject
    NetworkInfoReceiver mNetworkInfoReceiver;

    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

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
}
