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

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.smartstudio.fbclm.DataViewActivity;
import com.smartstudio.fbclm.FbclmApplication;
import com.smartstudio.fbclm.R;
import com.smartstudio.fbclm.controller.NavigationDrawerController;
import com.smartstudio.fbclm.injection.components.NavigationDrawerComponent;
import com.smartstudio.fbclm.injection.modules.NavigationDrawerModule;
import com.smartstudio.fbclm.model.League;

import java.util.List;

import javax.inject.Inject;

/**
 * Activity that displays a navigation drawer with the list of available leagues
 */
public class NavigationDrawerActivity extends DataViewActivity<List<League>> implements NavigationDrawerController {

    /**
     * Launches a new {@link NavigationDrawerActivity}
     *
     * @param activity Activity to be used as the context to launch the new activity
     **/
    public static void launch(Activity activity) {
        Intent intent = new Intent(activity, NavigationDrawerActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(0, 0);
    }

    /**
     * Object that managed all the related view logic for the navigation drawer
     **/
    @Inject
    NavigationDrawerView mView;
    /**
     * Dagger component used by this activity
     **/
    private NavigationDrawerComponent mComponent;

    @Override
    protected void initComponent() {
        mComponent = FbclmApplication.get(this)
                .getComponent()
                .plus(new NavigationDrawerModule(this, this));
        mComponent.inject(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_navigation_drawer;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mComponent = null;
    }

    @Override
    public void onDataError() {

    }

    @Override
    public ActionBar setUpToolbar(@NonNull Toolbar toolbar) {
        setSupportActionBar(toolbar);
        return getSupportActionBar();
    }

    @Override
    public void onLeagueClicked(League league) {
        mView.onLeagueSelected(league);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mView.onMenuItemClicked(item);
        return super.onOptionsItemSelected(item);
    }
}
