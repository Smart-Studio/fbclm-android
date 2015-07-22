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

import android.content.Intent;
import android.os.Bundle;

import com.smartstudio.fbclm.DataActivity;
import com.smartstudio.fbclm.FbclmApplication;
import com.smartstudio.fbclm.R;
import com.smartstudio.fbclm.controller.SplashController;
import com.smartstudio.fbclm.injection.components.SplashScreenComponent;
import com.smartstudio.fbclm.injection.modules.SplashScreenModule;
import com.smartstudio.fbclm.io.PreferencesManager;
import com.smartstudio.fbclm.model.League;
import com.smartstudio.fbclm.ui.MainActivity;

import java.util.List;

import javax.inject.Inject;

/**
 *
 */
public class SplashScreenActivity extends DataActivity<List<League>> implements SplashController {
    @Inject
    SplashView mView;
    @Inject
    PreferencesManager mPreferencesManager;

    private SplashScreenComponent mComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView.startLoadingAnimation();
        if (!mPreferencesManager.isSplashVisible()) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
        }
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
    public void onDestroy() {
        super.onDestroy();
        mComponent = null;
    }


    @Override
    public void onDataLoaded(List<League> data) {
        mPreferencesManager.hideSplashScreen();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }

    @Override
    public void onDataError() {
        mView.showErrorMessage();
    }
}
