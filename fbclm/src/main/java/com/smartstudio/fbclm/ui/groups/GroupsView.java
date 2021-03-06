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

import com.smartstudio.fbclm.model.Group;
import com.smartstudio.fbclm.ui.BaseView;

import java.util.List;

/**
 * TODO Add a class header comment
 */
public interface GroupsView extends BaseView {
    void showGroups(@NonNull List<Group> groups);

    void restoreSelectedGroupPosition(int position);

    int getSelectedGroupPosition();
}
