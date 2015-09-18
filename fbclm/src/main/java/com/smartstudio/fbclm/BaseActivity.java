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

import com.smartstudio.fbclm.injection.qualifiers.ForActivity;
import com.smartstudio.fbclm.ui.BaseView;

import javax.inject.Inject;

/**
 * Base activity that initialise the injected view and set the corresponding layout resource
 */
public abstract class BaseActivity extends AppCompatActivity {
    /**
     * Injected base view
     **/
    @Inject
    @ForActivity
    protected BaseView mView;

    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Called before super.onCreate so the activity component is available when the fragment are
        //initialised on super.onCreate()
        initComponent();
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        mView.init(findViewById(android.R.id.content));
    }

    /**
     * Initialise the corresponding component
     **/
    protected abstract void initComponent();

    /**
     * Gets the layout resource id to be set in the activity
     *
     * @return Layout resource id to be set in the activity
     **/
    @LayoutRes
    protected abstract int getLayoutResourceId();


}
