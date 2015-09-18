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

package com.smartstudio.fbclm.controllers.navigationdrawer;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.smartstudio.fbclm.controllers.DataController;
import com.smartstudio.fbclm.injection.components.NavigationDrawerComponent;
import com.smartstudio.fbclm.model.League;

import java.util.List;

/**
 * Interface definition for the controller used by {@link NavigationDrawerActivity}
 */
public interface NavigationDrawerController extends DataController<List<League>> {
    /**
     * Sets up the toolbar as the activity action bar
     *
     * @param toolbar Toolbar to be used as an action bar
     * @return Initialised action bar wrapping the given toolbar
     **/
    @Nullable
    ActionBar setUpToolbar(@NonNull Toolbar toolbar);

    /**
     * Manages the event where the user selects a league in the navigation drawer
     *
     * @param league   Selected league
     * @param position Selected league position
     **/
    void onLeagueSelected(League league, int position);

    NavigationDrawerComponent getComponent();
}
