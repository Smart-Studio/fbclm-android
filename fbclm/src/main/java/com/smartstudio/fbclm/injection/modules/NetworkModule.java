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

import android.content.Context;

import com.facebook.stetho.okhttp.StethoInterceptor;
import com.smartstudio.fbclm.BuildConfig;
import com.smartstudio.fbclm.injection.qualifiers.ForApplication;
import com.smartstudio.fbclm.network.FbclmOkHttpClient;
import com.smartstudio.fbclm.network.NetworkManager;
import com.smartstudio.fbclm.network.RetrofitNetworkManager;
import com.squareup.okhttp.Cache;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * TODO Add javadoc documentation
 */
@Module
public class NetworkModule {
    private static final long HTTP_CACHE_SIZE = 100 * 1024 * 1024; //10 Mb


    @Provides
    OkClient provideOkClient(FbclmOkHttpClient okHttpClient) {
        okHttpClient.networkInterceptors().add(new StethoInterceptor());
        return new OkClient(okHttpClient);
    }

    @Provides
    Cache provideOkHttpCache(@ForApplication Context context) {
        return new Cache(context.getCacheDir(), HTTP_CACHE_SIZE);
    }

    @Provides
    NetworkManager provideNetworkManager(RetrofitNetworkManager networkManager) {
        return networkManager;
    }

    @Provides
    RestAdapter.Builder provideRestBuilder(OkClient okClient) {
        return new RestAdapter.Builder()
                .setEndpoint(BuildConfig.ENDPOINT)
                .setClient(okClient)
                .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE);
    }
}
