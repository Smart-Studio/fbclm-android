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

package com.smartstudio.fbclm;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.smartstudio.fbclm.ui.FbclmView;

import javax.inject.Inject;

/**
 * TODO Add javadoc documentation
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Inject
    FbclmView mView;

    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponent();
        setContentView(getLayoutResourceId());
        mView.init(findViewById(android.R.id.content));
    }

    protected abstract void initComponent();

    @LayoutRes
    protected abstract int getLayoutResourceId();
}
