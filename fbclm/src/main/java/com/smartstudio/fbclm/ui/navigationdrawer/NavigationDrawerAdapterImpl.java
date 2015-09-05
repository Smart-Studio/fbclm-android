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

import android.view.ViewGroup;

import com.smartstudio.fbclm.model.League;

import java.util.List;

import javax.inject.Inject;

/**
 * {@link NavigationDrawerAdapter} implementation
 */
public class NavigationDrawerAdapterImpl extends NavigationDrawerAdapter {
    /**
     * League view holders helper
     **/
    private final LeagueViewHolderHelper mViewHolderHelper;
    /**
     * List containing the data of all the available leagues
     **/
    private List<League> mLeagues;

    /**
     * Creates an instance of the navigation drawer adapter
     *
     * @param viewHolderHelper League view holders helper
     **/
    @Inject
    public NavigationDrawerAdapterImpl(LeagueViewHolderHelper viewHolderHelper) {
        mViewHolderHelper = viewHolderHelper;
        mViewHolderHelper.setAdapter(this);
        setHasStableIds(true);
    }

    @Override
    public void setLeagues(List<League> leagues) {
        mLeagues = leagues;
        notifyDataSetChanged();
    }

    @Override
    public void restoreState(List<League> leagues, int selectedLeague) {
        mViewHolderHelper.setSelectedPosition(selectedLeague);
        setLeagues(leagues);
    }

    @Override
    public LeagueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mViewHolderHelper.getHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(LeagueViewHolder holder, int position) {
        final League league = mLeagues.get(position);
        mViewHolderHelper.bind(holder, league);
    }

    @Override
    public int getItemCount() {
        return mLeagues == null ? 0 : mLeagues.size();
    }

    @Override
    public long getItemId(int position) {
        return mLeagues.get(position).getId();
    }
}
