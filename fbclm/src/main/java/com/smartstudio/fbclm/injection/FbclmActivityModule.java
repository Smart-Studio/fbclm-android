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

import android.support.v4.app.FragmentManager;

import com.smartstudio.fbclm.ui.fbclm.FbclmPresenter;
import com.smartstudio.fbclm.ui.fbclm.FbclmPresenterImpl;
import com.smartstudio.fbclm.ui.fbclm.FbclmView;

import dagger.Module;
import dagger.Provides;

/**
 * TODO Add a class header comment
 */
@Module
public class FbclmActivityModule {
    private FbclmView mFbclmView;
    private FragmentManager mFragmentManager;

    public FbclmActivityModule(FbclmView fbclmView, FragmentManager fragmentManager) {
        mFbclmView = fbclmView;
        mFragmentManager = fragmentManager;
    }

    @Provides
    public FbclmView provideFbclmView() {
        return mFbclmView;
    }

    @Provides
    public FbclmPresenter provideFbclmPresenter(FbclmPresenterImpl fbclmPresenter) {
        return fbclmPresenter;
    }

    @Provides
    public FragmentManager provideFragmentManager() {
        return mFragmentManager;
    }
}
