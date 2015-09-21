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

import com.smartstudio.fbclm.injection.qualifiers.ForFragment;
import com.smartstudio.fbclm.injection.scopes.PerFragment;
import com.smartstudio.fbclm.ui.BaseView;
import com.smartstudio.fbclm.ui.groups.GroupView;
import com.smartstudio.fbclm.ui.groups.GroupViewImpl;

import dagger.Module;
import dagger.Provides;

/**
 * TODO Add javadoc documentation
 */
@Module
public class GroupModule {

    public GroupModule() {

    }

    @PerFragment
    @Provides
    GroupView provideView(GroupViewImpl view) {
        return view;
    }

    @PerFragment
    @ForFragment
    @Provides
    BaseView provideBaseView(GroupView view){
        return view;
    }

}
