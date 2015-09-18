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
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.smartstudio.fbclm.injection.qualifiers.ForActivity;
import com.smartstudio.fbclm.injection.qualifiers.ForFragment;
import com.smartstudio.fbclm.injection.scopes.PerFragment;
import com.smartstudio.fbclm.ui.BaseView;
import com.smartstudio.fbclm.ui.groups.GroupsView;
import com.smartstudio.fbclm.ui.groups.GroupsViewImpl;
import com.smartstudio.fbclm.ui.groups.GroupsViewPagerAdapter;
import com.smartstudio.fbclm.ui.groups.GroupsViewPagerAdapterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * TODO Add javadoc documentation
 */
@Module
public class GroupsModule {
    private final FragmentActivity mActivity;

    public GroupsModule(FragmentActivity activity) {
        mActivity = activity;
    }

    @PerFragment
    @ForActivity
    @Provides
    Context provideContext() {
        return mActivity;
    }

    @PerFragment
    @Provides
    FragmentManager provideFragmentManager() {
        return mActivity.getSupportFragmentManager();
    }

    @PerFragment
    @Provides
    GroupsView provideGroupView(GroupsViewImpl view) {
        return view;
    }

    @PerFragment
    @Provides
    @ForFragment
    BaseView provideBaseView(GroupsView view) {
        return view;
    }

    @PerFragment
    @Provides
    GroupsViewPagerAdapter provideViewPagerAdapter(GroupsViewPagerAdapterImpl adapter) {
        return adapter;
    }
}
