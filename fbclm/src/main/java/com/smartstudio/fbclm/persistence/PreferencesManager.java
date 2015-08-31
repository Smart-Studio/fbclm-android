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

package com.smartstudio.fbclm.persistence;

/**
 * Interface definition for the class that manages the preferences in the app
 */
public interface PreferencesManager {
    /**
     * Called when the splash screen doesn't need to be displayed anymore
     **/
    void hideSplashScreen();

    /**
     * Returns whether the splash screen needs to be displayed or not
     *
     * @return True when the splash screen needs to be displayed, false otherwise
     **/
    boolean isSplashVisible();
}
