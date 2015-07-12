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

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.smartstudio.fbclm.BuildConfig;
import com.smartstudio.fbclm.injection.qualifiers.ForApplication;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

/**
 * Base application module providing all the common dependencies through the whole application
 */
@Module(includes = NetworkModule.class)
public class FbclmModule {
    private final Application mApplication;

    public FbclmModule(Application application) {
        mApplication = application;
    }

    /**
     * Provides the application context
     *
     * @return Application context
     **/
    @Provides
    @ForApplication
    Context provideContext() {
        return mApplication;
    }

    /**
     * Provides the application resources instance
     *
     * @return Resources instance of the application
     **/
    @Provides
    Resources provideResources() {
        return mApplication.getResources();
    }

    /**
     * Provides a Timber tree to be used for logging by the application
     *
     * @return Timber tree to be used for logging
     **/
    @Provides
    Timber.Tree provideTimberTree() {
        if (BuildConfig.DEBUG) {
            return new Timber.DebugTree();
        }

        return new Timber.DebugTree();
    }
}
