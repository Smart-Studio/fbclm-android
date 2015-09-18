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

package com.smartstudio.fbclm.ui.groups;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartstudio.fbclm.R;
import com.smartstudio.fbclm.model.Group;

import java.util.List;

import javax.inject.Inject;

/**
 * TODO Add javadoc documentation
 */
public class GroupsViewPagerAdapterImpl extends GroupsViewPagerAdapter {
    private List<Group> mGroups;

    @Inject
    public GroupsViewPagerAdapterImpl(FragmentManager fm) {
        super(fm);
    }

    @Override
    public void setGroups(@NonNull List<Group> groups) {
        mGroups = groups;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return new PlaceholderFragment();
    }

    @Override
    public int getCount() {
        return mGroups == null ? 0 : mGroups.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mGroups.get(position).getName();
    }


    public static class PlaceholderFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.activity_splash, container, false);
        }
    }

}
