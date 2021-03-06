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

package com.smartstudio.fbclm.ui.navigationdrawer;

import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.smartstudio.fbclm.model.League;
import com.smartstudio.fbclm.ui.FbclmView;

import java.util.List;

/**
 * Interface definition of the class that manages all the view related logic for the navigation drawer
 */
public interface NavigationDrawerView extends FbclmView<List<League>> {

    /**
     * Called when a menu item is clicked
     *
     * @param item Menu item clicked
     **/
    void onMenuItemClicked(@NonNull MenuItem item);

    /**
     * Called when a league has been selected in the navigation drawer
     *
     * @param league Selected league
     **/
    void onLeagueSelected(@NonNull League league);

    /**
     * Restores the state when device is rotated or the OS kills your app
     *
     * @param leagues                Latest loaded leagues
     * @param selectedLeaguePosition Latest selected position
     **/
    void restoreState(@NonNull List<League> leagues, int selectedLeaguePosition);
}
