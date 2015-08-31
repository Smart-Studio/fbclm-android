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
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.smartstudio.fbclm.R;
import com.smartstudio.fbclm.controllers.navigationdrawer.NavigationDrawerController;
import com.smartstudio.fbclm.model.League;
import com.smartstudio.fbclm.ui.BaseViewImpl;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * TODO Add javadoc documentation
 */
public class NavigationDrawerViewImpl extends BaseViewImpl implements NavigationDrawerView {
    private final NavigationDrawerController mController;
    private final NavigationDrawerAdapter mAdapter;
    private final RecyclerView.LayoutManager mLayoutManager;

    @Bind(R.id.drawer_layout)
    protected DrawerLayout mDrawerLayout;

    @Bind(R.id.toolbar)
    protected Toolbar mToolbar;

    @Bind(R.id.drawer_list)
    protected RecyclerView mDrawerList;

    @Inject
    public NavigationDrawerViewImpl(NavigationDrawerController controller, NavigationDrawerAdapter adapter,
                                    RecyclerView.LayoutManager layoutManager) {
        mController = controller;
        mAdapter = adapter;
        mLayoutManager = layoutManager;
    }

    @Override
    public void init(@NonNull View view) {
        super.init(view);
        ActionBar actionBar = mController.setUpToolbar(mToolbar);
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mDrawerList.setLayoutManager(mLayoutManager);
        mDrawerList.setAdapter(mAdapter);
    }

    @Override
    public void showData(List<League> leagues) {
        mAdapter.setLeagues(leagues);
    }


    @Override
    public void onMenuItemClicked(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }
    }

    @Override
    public void onLeagueSelected(@NonNull League league) {
        mDrawerLayout.closeDrawers();
        mToolbar.setTitle(league.getName());
    }
}
