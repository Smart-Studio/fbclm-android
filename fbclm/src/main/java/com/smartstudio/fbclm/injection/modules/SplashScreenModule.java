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

package com.smartstudio.fbclm.injection.modules;

import com.smartstudio.fbclm.controller.SplashController;
import com.smartstudio.fbclm.injection.scopes.PerActivity;
import com.smartstudio.fbclm.network.splash.NetworkManager;
import com.smartstudio.fbclm.network.splash.SplashNetworkManagerImpl;
import com.smartstudio.fbclm.ui.BaseView;
import com.smartstudio.fbclm.ui.splash.SplashView;
import com.smartstudio.fbclm.ui.splash.SplashViewImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Module injecting all the needed dependencies for the splash screen
 */
@Module
public class SplashScreenModule extends BaseModule {
    //TODO: Make this dynamic later
    private static final int SEASON_ID = 104;

    /**
     * Splash controller to by injected
     **/
    private final SplashController mController;

    /**
     * Creates a new splash screen module
     *
     * @param controller Controller to be injected
     **/
    public SplashScreenModule(SplashController controller) {
        mController = controller;
    }

    /**
     * Provides a {@link SplashView} implementation
     *
     * @param splashView {@link SplashView} implementation to be provided
     * @return SplashView implementation
     **/
    @Provides
    @PerActivity
    SplashView provideView(SplashViewImpl splashView) {
        return splashView;
    }

    /**
     * Provides a {@link BaseView} implementation which must be the same view provider by
     * {@link SplashScreenModule#provideView(SplashViewImpl)}.
     * We do this to inject the view automatically in {@link com.smartstudio.fbclm.BaseActivity}
     *
     * @param view BaseView to be provided
     * @return BaseView injected in {@link com.smartstudio.fbclm.BaseActivity}
     **/
    @Provides
    @PerActivity
    BaseView provideFbclmView(SplashView view) {
        return view;
    }

    /**
     * Provides a {@link NetworkManager} implementation
     *
     * @param networkManager {@link NetworkManager} implementation
     * @return NetworkManager implementation
     **/
    @Provides
    @PerActivity
    NetworkManager provideNetworkManager(SplashNetworkManagerImpl networkManager) {
        return networkManager;
    }

    /**
     * Provides a {@link SplashController} implementation
     *
     * @return SplashController implementation
     **/
    @Provides
    @PerActivity
    SplashController provideSplashController() {
        return mController;
    }

    @Provides
    @PerActivity
    int provideSeasonId() {
        return SEASON_ID;
    }
}
