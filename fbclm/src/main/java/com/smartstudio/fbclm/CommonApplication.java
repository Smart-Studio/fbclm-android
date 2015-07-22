/*
 * Copyright 2015 Smart Studio
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

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.smartstudio.fbclm.injection.components.DaggerFbclmComponent;
import com.smartstudio.fbclm.injection.components.FbclmComponent;
import com.smartstudio.fbclm.injection.modules.FbclmModule;

import javax.inject.Inject;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

/**
 * TODO Add javadoc documentation
 */
public abstract class CommonApplication extends Application {
    private FbclmComponent component;
    @Inject
    Timber.Tree mTimberTree;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        component = DaggerFbclmComponent.builder()
                .fbclmModule(new FbclmModule(this))
                .build();
        component.injectApplication(this);
    }

    public FbclmComponent getComponent() {
        return component;
    }

    public static FbclmApplication get(Context context) {
        return (FbclmApplication) context.getApplicationContext();
    }
}