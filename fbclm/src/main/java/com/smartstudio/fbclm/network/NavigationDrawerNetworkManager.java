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

import com.smartstudio.fbclm.controllers.navigationdrawer.NavigationDrawerController;
import com.smartstudio.fbclm.model.League;

import java.util.List;

import javax.inject.Inject;

/**
 * TODO Add javadoc documentation
 */
public class NavigationDrawerNetworkManager extends NetworkManagerImpl<List<League>> {

    @Inject
    public NavigationDrawerNetworkManager(NetworkHelper networkHelper, NavigationDrawerController controller) {
        super(controller, networkHelper);
    }

    @Override
    protected List<League> requestData(boolean forceCache) {
        return mNetworkHelper.requestLeagues(104, forceCache);
    }
}
