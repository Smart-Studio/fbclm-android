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

package com.smartstudio.fbclm.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Base view implementation that injects the views using butterknife
 */
public abstract class BaseViewImpl implements BaseView {

    @CallSuper
    @Override
    public void init(@NonNull View view) {
        ButterKnife.inject(this, view);
    }
}
