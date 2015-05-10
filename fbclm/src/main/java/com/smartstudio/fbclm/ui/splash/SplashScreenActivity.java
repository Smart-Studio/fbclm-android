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
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.smartstudio.fbclm.R;
import com.smartstudio.fbclm.app.FbclmApplication;
import com.smartstudio.fbclm.injection.DaggerSplashScreenComponent;
import com.smartstudio.fbclm.injection.SplashScreenComponent;
import com.smartstudio.fbclm.injection.SplashScreenModule;
import com.smartstudio.fbclm.ui.fbclm.FbclmActivity;

import javax.inject.Inject;

/**
 * TODO Add a class header comment
 */
public class SplashScreenActivity extends AppCompatActivity implements SplashController, SplashNetworkListener {
    private SplashScreenComponent mComponent;
    @Inject
    SplashView mSplashView;
    @Inject
    SplashNetworkManager mNetworkManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mComponent = DaggerSplashScreenComponent.builder()
                .fbclmComponent(FbclmApplication.get(this).getComponent())
                .splashScreenModule(new SplashScreenModule(this))
                .build();
        mComponent.inject(this);

        View view = getWindow().getDecorView().findViewById(android.R.id.content);
        mSplashView.init(view);
        mSplashView.startLoadingAnimation();
        mNetworkManager.setSplashNetworkListener(this);
        mNetworkManager.requestLeagues();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mComponent = null;
    }

    @Override
    public void navigateTo() {
        startActivity(new Intent(SplashScreenActivity.this, FbclmActivity.class));
    }

    @Override
    public void onLeaguesLoaded() {

    }
}
