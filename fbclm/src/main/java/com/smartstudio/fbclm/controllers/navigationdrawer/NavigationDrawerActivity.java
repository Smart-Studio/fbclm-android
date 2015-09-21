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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.smartstudio.fbclm.DataViewActivity;
import com.smartstudio.fbclm.FbclmApplication;
import com.smartstudio.fbclm.R;
import com.smartstudio.fbclm.controllers.groups.GroupFragment;
import com.smartstudio.fbclm.controllers.groups.GroupsFragment;
import com.smartstudio.fbclm.injection.components.NavigationDrawerComponent;
import com.smartstudio.fbclm.injection.modules.NavigationDrawerModule;
import com.smartstudio.fbclm.model.Group;
import com.smartstudio.fbclm.model.League;
import com.smartstudio.fbclm.ui.navigationdrawer.NavigationDrawerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Activity that displays a navigation drawer with the list of available leagues
 */
public class NavigationDrawerActivity extends DataViewActivity<List<League>> implements NavigationDrawerController {
    private static final String ARG_LEAGUES = "leagues";
    private static final String ARG_SELECTED_LEAGUE_POSITION = "selected_league_position";

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
     * Object that manages all the related view logic for the navigation drawer
     **/
    @Inject
    NavigationDrawerView mView;
    /**
     * Dagger component used by this activity
     **/
    private NavigationDrawerComponent mComponent;

    /**
     * List of available leagues
     **/
    @Nullable
    private List<League> mLeagues;
    /**
     * Position of the selected league in the list
     **/
    private int mSelectedLeaguePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            mLeagues = savedInstanceState.getParcelableArrayList(ARG_LEAGUES);
            mSelectedLeaguePosition = savedInstanceState.getInt(ARG_SELECTED_LEAGUE_POSITION);

            if (mLeagues != null) {
                mView.restoreState(mLeagues, mSelectedLeaguePosition);
            }
        }
    }

    @Override
    protected void initComponent() {
        mComponent = FbclmApplication.get()
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
    public void onDataLoaded(List<League> leagues) {
        super.onDataLoaded(leagues);
        mLeagues = leagues;
    }

    @Override
    public ActionBar setUpToolbar(@NonNull Toolbar toolbar) {
        setSupportActionBar(toolbar);
        return getSupportActionBar();
    }

    @Override
    public void onLeagueSelected(League league, int position) {
        mSelectedLeaguePosition = position;
        mView.onLeagueSelected(league);
        showLeagueFragment(league);
    }

    @Override
    public NavigationDrawerComponent getComponent() {
        return mComponent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mView.onMenuItemClicked(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(ARG_LEAGUES, (ArrayList<? extends Parcelable>) mLeagues);
        outState.putInt(ARG_SELECTED_LEAGUE_POSITION, mSelectedLeaguePosition);
    }

    /**
     * Creates a new fragment for the selected league
     *
     * @param league Selected league
     **/
    private void showLeagueFragment(League league) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        List<Group> groups = league.getGroups();
        if (groups.size() > 1) {
            ft.replace(R.id.content_frame, GroupsFragment.newInstance(league.getGroups()));
        } else {
            ft.replace(R.id.content_frame, GroupFragment.newInstance(groups.get(0)));
        }
        ft.commit();
    }
}
