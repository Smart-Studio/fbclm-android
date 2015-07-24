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
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartstudio.fbclm.R;
import com.smartstudio.fbclm.controller.NavigationDrawerController;
import com.smartstudio.fbclm.injection.qualifiers.ForActivity;
import com.smartstudio.fbclm.model.League;

import javax.inject.Inject;

/**
 * TODO Add javadoc documentation
 */
public class LeagueViewHolderHelperImpl implements LeagueViewHolderHelper, View.OnClickListener {
    private final LayoutInflater mLayoutInflater;
    private final NavigationDrawerController mController;
    private int mSelectedPosition;

    @Inject
    public LeagueViewHolderHelperImpl(@ForActivity Context context,
                                      NavigationDrawerController controller) {
        mLayoutInflater = LayoutInflater.from(context);
        mController = controller;
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
        final RecyclerView recyclerView = (RecyclerView) view.getParent();
        mSelectedPosition = viewHolder.getAdapterPosition();
        recyclerView.getAdapter().notifyDataSetChanged();
        mController.onLeagueClicked((League) view.getTag(R.id.league_tag));
    }


    private int getLeagueIcon(String leagueName) {
        if (leagueName == null) {
            return 0;
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
