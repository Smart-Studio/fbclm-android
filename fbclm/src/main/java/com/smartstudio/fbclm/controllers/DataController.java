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

package com.smartstudio.fbclm.controllers;

/**
 * Base controller interface offering callbacks for the data loading process
 */
public interface DataController<T> {
    /**
     * Callback method that notifies when the required data has been loaded
     *
     * @param data Loaded data
     **/
    void onDataLoaded(T data);

    /**
     * Callback method that notifies of ocurred
     **/
    void onDataError();
}
