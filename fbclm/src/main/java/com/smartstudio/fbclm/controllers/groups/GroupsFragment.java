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
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.smartstudio.fbclm.BaseFragment;
import com.smartstudio.fbclm.R;
import com.smartstudio.fbclm.controllers.navigationdrawer.NavigationDrawerController;
import com.smartstudio.fbclm.injection.components.GroupsComponent;
import com.smartstudio.fbclm.injection.components.NavigationDrawerComponent;
import com.smartstudio.fbclm.injection.modules.GroupsModule;
import com.smartstudio.fbclm.model.Group;
import com.smartstudio.fbclm.ui.groups.GroupsView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * TODO Add a class header comment
 */
public class GroupsFragment extends BaseFragment implements GroupsController {
    private static final String ARGS_GROUPS = "groups";
    private static final String ARGS_GROUP_POSITION = "group_position";

    public static GroupsFragment newInstance(List<Group> groups) {
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARGS_GROUPS, (ArrayList<Group>) groups);

        GroupsFragment fragment = new GroupsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Inject
    GroupsView mView;

    private GroupsComponent mComponent;


    @Override
    protected void initComponent() {
        FragmentActivity activity = getActivity();
        NavigationDrawerComponent parentComponent = ((NavigationDrawerController) activity)
                .getComponent();
        mComponent = parentComponent.plus(new GroupsModule(activity));
        mComponent.inject(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_groups;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Group> groups = getArguments().getParcelableArrayList(ARGS_GROUPS);
        mView.showGroups(groups);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            int selectedGroupPosition = savedInstanceState.getInt(ARGS_GROUP_POSITION);
            mView.restoreSelectedGroupPosition(selectedGroupPosition);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARGS_GROUP_POSITION, mView.getSelectedGroupPosition());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mComponent = null;
    }
}
