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

package com.smartstudio.fbclm;

import android.app.Activity;
import android.os.Bundle;

import com.smartstudio.fbclm.app.FbclmApplication;
import com.smartstudio.fbclm.injection.Dagger_SplashScreenComponent;
import com.smartstudio.fbclm.injection.SplashScreenComponent;
import com.smartstudio.fbclm.injection.SplashScreenModule;
import com.smartstudio.fbclm.ui.SplashScreenPresenter;
import com.smartstudio.fbclm.ui.SplashView;

import javax.inject.Inject;

/**
 * TODO Add a class header comment
 */
public class SplashScreenActivity extends Activity implements SplashView {
    private SplashScreenComponent mComponent;

    @Inject
    SplashScreenPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mComponent = Dagger_SplashScreenComponent.builder()
                .fbclmComponent(FbclmApplication.get(this).getComponent())
                .splashScreenModule(new SplashScreenModule(this))
                .build();
        mComponent.inject(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mComponent = null;
    }
}
