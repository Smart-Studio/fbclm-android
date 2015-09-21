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

package com.smartstudio.fbclm.injection.components;

import com.smartstudio.fbclm.controllers.navigationdrawer.NavigationDrawerActivity;
import com.smartstudio.fbclm.injection.modules.GroupModule;
import com.smartstudio.fbclm.injection.modules.GroupsModule;
import com.smartstudio.fbclm.injection.modules.NavigationDrawerModule;
import com.smartstudio.fbclm.injection.scopes.PerActivity;

import dagger.Subcomponent;

/**
 * TODO Add javadoc documentation
 */
@PerActivity
@Subcomponent(modules = NavigationDrawerModule.class)
public interface NavigationDrawerComponent {
    GroupsComponent plus(GroupsModule module);

    GroupComponent plus(GroupModule module);

    void inject(NavigationDrawerActivity activity);
}
