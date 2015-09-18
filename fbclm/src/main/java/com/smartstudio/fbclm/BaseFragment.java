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
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartstudio.fbclm.injection.qualifiers.ForFragment;
import com.smartstudio.fbclm.ui.BaseView;

import javax.inject.Inject;

/**
 * TODO Add a class header comment
 */
public abstract class BaseFragment extends Fragment {

    /**
     * Injected base view
     **/
    @ForFragment
    @Inject
    protected BaseView mView;

    @CallSuper
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponent();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResourceId(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mView.init(view);
    }

    /**
     * Initialise the corresponding component
     */
    protected abstract void initComponent();


    /**
     * Gets the layout resource id to be set in the activity
     *
     * @return Layout resource id to be set in the activity
     **/
    @LayoutRes
    protected abstract int getLayoutResourceId();
}
