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

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.widget.TextView;

import com.smartstudio.fbclm.R;
import com.smartstudio.fbclm.ui.BaseViewImpl;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * TODO Add a class header comment
 */
public class SplashViewImpl extends BaseViewImpl implements SplashView {
    @Inject
    Resources mResources;

    @InjectView(R.id.splash_text_loading)
    TextView mLoadingText;

    @Inject
    public SplashViewImpl() {

    }

    @Override
    public void startLoadingAnimation() {
        AnimationDrawable loadingAnimation = (AnimationDrawable) mResources
                .getDrawable(R.drawable.animated_ellipsis);
        mLoadingText.setCompoundDrawablesWithIntrinsicBounds(null, null, loadingAnimation, null);
        if (loadingAnimation != null) {
            loadingAnimation.start();
        }
    }

}
