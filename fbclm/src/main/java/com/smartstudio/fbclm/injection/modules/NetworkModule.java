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

import com.smartstudio.fbclm.BuildConfig;
import com.smartstudio.fbclm.injection.qualifiers.ForApplication;
import com.smartstudio.fbclm.network.FbclmOkHttpClient;
import com.smartstudio.fbclm.network.NetworkHelper;
import com.smartstudio.fbclm.network.RetrofitNetworkHelper;
import com.squareup.okhttp.Cache;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Network module providing all the dependencies related to the network layer
 */
@Module
public class NetworkModule {
    /**
     * OkHttp cache size in bytes
     **/
    private static final long HTTP_CACHE_SIZE = 100 * 1024 * 1024; //100 Mb


    /**
     * Provides OkClient instance to by used by {@link RetrofitNetworkHelper}
     *
     * @param okHttpClient {@link com.squareup.okhttp.OkHttpClient} implementation to be used in as OkClient
     * @return OkClient to be used by {@link RetrofitNetworkHelper}
     **/
    @Provides
    OkClient provideOkClient(FbclmOkHttpClient okHttpClient) {
        return new OkClient(okHttpClient);
    }

    /**
     * Provides a cache to be used by the OkHttpClient
     *
     * @param context Application context
     * @return Cache to be used by the OkHttpClient
     **/
    @Provides
    Cache provideOkHttpCache(@ForApplication Context context) {
        return new Cache(context.getCacheDir(), HTTP_CACHE_SIZE);
    }

    /**
     * Provides a network manager helper that helps requesting the different available endpoints
     *
     * @param networkHelper {@link NetworkHelper} implementation to be injected
     * @return Network manager helper used through the application
     **/
    @Provides
    NetworkHelper provideNetworkHelper(RetrofitNetworkHelper networkHelper) {
        return networkHelper;
    }

    /**
     * Provides RestAdapter used by {@link RetrofitNetworkHelper}
     *
     * @param okClient OkClient to be used in the rest adapter
     * @return RestAdapter to be used by {@link RetrofitNetworkHelper}
     **/
    @Provides
    RestAdapter.Builder provideRestBuilder(OkClient okClient) {
        return new RestAdapter.Builder()
                .setEndpoint(BuildConfig.ENDPOINT)
                .setClient(okClient)
                .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE);
    }
}
