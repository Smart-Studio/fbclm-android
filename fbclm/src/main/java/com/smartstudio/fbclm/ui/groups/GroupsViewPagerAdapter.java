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
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.smartstudio.fbclm.model.Group;

import java.util.List;

/**
 * TODO Add javadoc documentation
 */
public abstract class GroupsViewPagerAdapter extends FragmentStatePagerAdapter {

    public GroupsViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public abstract void setGroups(@NonNull List<Group> groups);
}
