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

package com.smartstudio.fbclm.network;

import com.smartstudio.fbclm.model.League;

import java.util.List;

/**
 * Network helper used to request from the backend any data needed by the app
 */
public interface NetworkHelper {
    /**
     * Request the list of different league given a season
     *
     * @param seasonId   Id of the season
     * @param forceCache Indicates whether it should be a network request or we need to load the
     *                   content from the http cache
     * @return List containing all the available leagues
     **/
    List<League> requestLeagues(int seasonId, boolean forceCache);
}
