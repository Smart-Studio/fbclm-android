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

package com.smartstudio.fbclm.controllers.groups;

import android.os.Bundle;

import com.smartstudio.fbclm.BaseFragment;
import com.smartstudio.fbclm.R;
import com.smartstudio.fbclm.controllers.navigationdrawer.NavigationDrawerActivity;
import com.smartstudio.fbclm.injection.components.GroupComponent;
import com.smartstudio.fbclm.injection.modules.GroupModule;
import com.smartstudio.fbclm.model.Group;
import com.smartstudio.fbclm.ui.groups.GroupView;

import javax.inject.Inject;

/**
 * TODO Add a class header comment
 */
public class GroupFragment extends BaseFragment {
    private static final String ARG_GROUP = "group";

    public static GroupFragment newInstance(Group group) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_GROUP, group);

        GroupFragment fragment = new GroupFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private GroupComponent mComponent;

    @Inject
    GroupView mView;

    @Override
    protected void initComponent() {
        mComponent = ((NavigationDrawerActivity) getActivity()).getComponent()
                .plus(new GroupModule());
        mComponent.inject(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_group;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mComponent = null;
    }
}
