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

package com.smartstudio.fbclm.injection;

import com.smartstudio.fbclm.app.FbclmComponent;
import com.smartstudio.fbclm.ui.splash.SplashNetworkManager;
import com.smartstudio.fbclm.ui.splash.SplashScreenActivity;
import com.smartstudio.fbclm.ui.splash.SplashView;

import dagger.Component;

/**
 * TODO Add a class header comment
 */
@Component(
        dependencies = {FbclmComponent.class},
        modules = SplashScreenModule.class
)
public interface SplashScreenComponent {
    void inject(SplashScreenActivity activity);

    SplashView provideSplashView();

    SplashNetworkManager provideSplashNetwork();
}
