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

package com.smartstudio.fbclm.injection.modules;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.smartstudio.fbclm.controllers.navigationdrawer.NavigationDrawerController;
import com.smartstudio.fbclm.injection.qualifiers.ForActivity;
import com.smartstudio.fbclm.injection.qualifiers.ForApplication;
import com.smartstudio.fbclm.injection.scopes.PerActivity;
import com.smartstudio.fbclm.model.League;
import com.smartstudio.fbclm.network.navigationdrawer.NavigationDrawerNetworkManager;
import com.smartstudio.fbclm.network.NetworkManager;
import com.smartstudio.fbclm.ui.BaseView;
import com.smartstudio.fbclm.ui.FbclmView;
import com.smartstudio.fbclm.ui.navigationdrawer.LeagueViewHolderHelper;
import com.smartstudio.fbclm.ui.navigationdrawer.LeagueViewHolderHelperImpl;
import com.smartstudio.fbclm.ui.navigationdrawer.NavigationDrawerAdapter;
import com.smartstudio.fbclm.ui.navigationdrawer.NavigationDrawerAdapterImpl;
import com.smartstudio.fbclm.ui.navigationdrawer.NavigationDrawerView;
import com.smartstudio.fbclm.ui.navigationdrawer.NavigationDrawerViewImpl;

import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * TODO Add javadoc documentation
 */
@Module
public class NavigationDrawerModule extends BaseModule {
    private final Context mContext;
    private final NavigationDrawerController mController;

    public NavigationDrawerModule(Context context, NavigationDrawerController controller) {
        mContext = context;
        mController = controller;
    }

    @Provides
    @ForActivity
    @PerActivity
    Context provideContext() {
        return mContext;
    }

    @Provides
    @PerActivity
    NavigationDrawerController provideController() {
        return mController;
    }

    @Provides
    @PerActivity
    NavigationDrawerView provideView(NavigationDrawerViewImpl view) {
        return view;
    }

    @Provides
    @PerActivity
    FbclmView<List<League>> provideFbclmView(NavigationDrawerView view) {
        return view;
    }


    @Provides
    @PerActivity
    BaseView provideBaseView(NavigationDrawerView view) {
        return view;
    }

    @Provides
    @PerActivity
    NetworkManager provideNetworkManager(NavigationDrawerNetworkManager networkManager) {
        return networkManager;
    }

    @Provides
    @PerActivity
    NavigationDrawerAdapter provideAdapter(NavigationDrawerAdapterImpl adapter) {
        return adapter;
    }

    @Provides
    @PerActivity
    LeagueViewHolderHelper provideViewHolderHelper(LeagueViewHolderHelperImpl viewHolderHelper) {
        return viewHolderHelper;
    }

    @Provides
    @PerActivity
    RecyclerView.LayoutManager provideLayoutManager(@ForApplication Context context) {
        return new LinearLayoutManager(context);
    }
}
