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

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.smartstudio.fbclm.R;
import com.smartstudio.fbclm.model.Group;
import com.smartstudio.fbclm.ui.BaseViewImpl;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * TODO Add javadoc documentation
 */
public class GroupsViewImpl extends BaseViewImpl implements GroupsView {
    @Bind(R.id.sliding_tabs_groups)
    TabLayout mTabLayout;

    @Bind(R.id.view_pager_groups)
    ViewPager mViewPager;

    private final GroupsViewPagerAdapter mViewPagerAdapter;

    @Inject
    public GroupsViewImpl(GroupsViewPagerAdapter viewPagerAdapter) {
        mViewPagerAdapter = viewPagerAdapter;
    }

    @Override
    public void init(@NonNull View view) {
        super.init(view);
        mViewPager.setAdapter(mViewPagerAdapter);
    }

    @Override
    public void showGroups(@NonNull List<Group> groups) {
        mViewPagerAdapter.setGroups(groups);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void restoreSelectedGroupPosition(int position) {
        mViewPager.post(() -> mViewPager.setCurrentItem(position));
    }

    @Override
    public int getSelectedGroupPosition() {
        return mViewPager.getCurrentItem();
    }
}
