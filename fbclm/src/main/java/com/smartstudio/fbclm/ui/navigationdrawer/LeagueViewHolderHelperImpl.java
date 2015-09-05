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

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartstudio.fbclm.R;
import com.smartstudio.fbclm.controllers.navigationdrawer.NavigationDrawerController;
import com.smartstudio.fbclm.injection.qualifiers.ForActivity;
import com.smartstudio.fbclm.model.League;

import javax.inject.Inject;

/**
 * {@link LeagueViewHolderHelper} implementation creating a view holder that displays the name and
 * icon for the given leagues
 */
public class LeagueViewHolderHelperImpl implements LeagueViewHolderHelper, View.OnClickListener {
    /**
     * Layout inflater used to inflate the views used in the view holder
     **/
    private final LayoutInflater mLayoutInflater;
    /**
     * Controller to delegate the event where the user selects a league to
     **/
    private final NavigationDrawerController mController;
    private NavigationDrawerAdapter mAdapter;
    /**
     * Current position of the selected league
     **/
    private int mSelectedPosition;

    /**
     * @param context    Context to obtain a layout inflater from
     * @param controller Controller to delegate the event where the user selects a league to
     **/
    @Inject
    public LeagueViewHolderHelperImpl(@ForActivity Context context,
                                      NavigationDrawerController controller) {
        mLayoutInflater = LayoutInflater.from(context);
        mController = controller;
    }

    @Override
    public void setAdapter(@NonNull NavigationDrawerAdapter adapter) {
        mAdapter = adapter;
    }

    public void setSelectedPosition(int selectedPosition) {
        mSelectedPosition = selectedPosition;
    }

    @Override
    public LeagueViewHolder getHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.league_item, parent, false);
        return new LeagueViewHolder(view);
    }

    @Override
    public void bind(@NonNull LeagueViewHolder holder, @NonNull League league) {
        holder.league.setText(league.getName());
        int imageResourceId = getLeagueIcon(league.getName());
        holder.league.setCompoundDrawablesWithIntrinsicBounds(imageResourceId, 0, 0, 0);

        holder.itemView.setSelected(mSelectedPosition == holder.getAdapterPosition());
        holder.itemView.setTag(R.id.view_holder_tag, holder);
        holder.itemView.setTag(R.id.league_tag, league);
        holder.itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        final LeagueViewHolder viewHolder = (LeagueViewHolder) view.getTag(R.id.view_holder_tag);
        mSelectedPosition = viewHolder.getAdapterPosition();
        mAdapter.notifyDataSetChanged();
        mController.onLeagueSelected((League) view.getTag(R.id.league_tag), mSelectedPosition);
    }


    /**
     * Returns the drawable resource integer for the icon of the given league
     *
     * @param leagueName Name of the league
     * @return Drawable integer for the icon of the given league
     **/
    @DrawableRes
    private int getLeagueIcon(String leagueName) {
        if (leagueName == null) {
            return R.mipmap.ic_jccm;
        }

        switch (leagueName) {
            case League.ADDECO_PLATA:
            case League.EBA:
                return R.mipmap.ic_feb;
            case League.NACIONAL:
                return R.mipmap.ic_nacional;
            case League.AUTONOMICA_1:
                return R.mipmap.ic_autonomica_1;
            case League.FEM_1:
                return R.mipmap.ic_fem_1;
            case League.AUTONOMICA_2:
                return R.mipmap.ic_autonomica_2;
            case League.SUB_20_MAS:
                return R.mipmap.ic_sub_20_mas;
            case League.SUB_20_FEM:
                return R.mipmap.ic_sub_20_fem;
            case League.JUNIOR_MAS_ESPECIAL:
                return R.mipmap.ic_junior_especial_m;
            case League.JUNIOR_FEM:
                return R.mipmap.ic_junior_fem;
            case League.JUNIOR_MAS_PREFERENTE:
                return R.mipmap.ic_junior_preferente_m;
            default:
                return R.mipmap.ic_jccm;
        }

    }
}
