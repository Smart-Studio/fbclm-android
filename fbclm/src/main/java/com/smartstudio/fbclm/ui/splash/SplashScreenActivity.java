/*
 * Copyright 2015 Smart Studio.
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

package com.smartstudio.fbclm.ui.splash;

import android.os.Bundle;

import com.smartstudio.fbclm.BaseActivity;
import com.smartstudio.fbclm.FbclmApplication;
import com.smartstudio.fbclm.R;
import com.smartstudio.fbclm.controller.SplashController;
import com.smartstudio.fbclm.injection.components.SplashScreenComponent;
import com.smartstudio.fbclm.injection.modules.SplashScreenModule;
import com.smartstudio.fbclm.model.League;
import com.smartstudio.fbclm.network.splash.SplashNetworkManager;

import java.util.List;

import javax.inject.Inject;

/**
 *
 */
public class SplashScreenActivity extends BaseActivity implements SplashController {
    private SplashScreenComponent mComponent;
    @Inject
    SplashView mSplashView;
    @Inject
    SplashNetworkManager networkManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashView.startLoadingAnimation();
    }

    @Override
    protected void initComponent() {
        mComponent = FbclmApplication.get(this)
                .getComponent()
                .plus(new SplashScreenModule(this));
        mComponent.inject(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onStart() {
        super.onStart();
        networkManager.requestLeagues();
    }

    @Override
    protected void onStop() {
        super.onStop();
        networkManager.cancelRequest();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mComponent = null;
    }

    public void onLeaguesLoaded(List<League> leagues) {
        /*finish();
        Intent intent = new Intent(this, FbclmActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);*/
    }
}
