/*
 * Copyright 2015 Smart Studio.
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

package com.smartstudio.fbclm.ui.fbclm;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.smartstudio.fbclm.R;
import com.smartstudio.fbclm.app.FbclmApplication;
import com.smartstudio.fbclm.injection.DaggerFbclmActivityComponent;
import com.smartstudio.fbclm.injection.FbclmActivityComponent;
import com.smartstudio.fbclm.injection.FbclmActivityModule;

/**
 * TODO Add a class header comment
 */
public class FbclmActivity extends AppCompatActivity {
    private FbclmActivityComponent mComponent;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fbclm);

        mComponent = DaggerFbclmActivityComponent.builder()
                .fbclmComponent(FbclmApplication.get(this).getComponent())
                .fbclmActivityModule(new FbclmActivityModule(getSupportFragmentManager()))
                .build();
        mComponent.inject(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mComponent = null;
    }

}
