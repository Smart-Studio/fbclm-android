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

package com.smartstudio.fbclm.io;

import android.content.Context;
import android.content.SharedPreferences;

import com.smartstudio.fbclm.injection.qualifiers.ForApplication;

import javax.inject.Inject;

/**
 * TODO Add a class header comment
 */
public class PreferencesManagerImpl implements PreferencesManager {
    private static final String PREFERENCES_NAME = "fbclm";
    private static final String SPLASH_SCREEN = "splash_screen";

    private SharedPreferences mSharedPreferences;

    @Inject
    public PreferencesManagerImpl(@ForApplication Context context) {
        mSharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void hideSplashScreen() {
        mSharedPreferences.edit().putBoolean(SPLASH_SCREEN, false).apply();
    }

    @Override
    public boolean isSplashVisible() {
        return mSharedPreferences.getBoolean(SPLASH_SCREEN, true);
    }
}
