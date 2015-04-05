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

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.smartstudio.fbclm.R;
import com.smartstudio.fbclm.app.FbclmApplication;
import com.smartstudio.fbclm.injection.Dagger_SplashScreenComponent;
import com.smartstudio.fbclm.injection.SplashScreenComponent;
import com.smartstudio.fbclm.injection.SplashScreenModule;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * TODO Add a class header comment
 */
public class SplashScreenActivity extends FragmentActivity implements SplashView {
    private SplashScreenComponent mComponent;

    @InjectView(R.id.splash_text_loading)
    TextView mLoadingText;
    @Inject
    SplashScreenPresenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mComponent = Dagger_SplashScreenComponent.builder()
                .fbclmComponent(FbclmApplication.get(this).getComponent())
                .splashScreenModule(new SplashScreenModule(this))
                .build();
        mComponent.inject(this);
        ButterKnife.inject(this);

        startLoadingAnimation();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mComponent = null;
    }

    private void startLoadingAnimation(){
        AnimationDrawable loadingAnimation = (AnimationDrawable) getResources()
                .getDrawable(R.drawable.animated_ellipsis);
        mLoadingText.setCompoundDrawablesWithIntrinsicBounds(null, null, loadingAnimation, null);
        if (loadingAnimation != null) {
            loadingAnimation.start();
        }
    }

}
