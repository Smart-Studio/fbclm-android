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

package com.smartstudio.fbclm.network;

import com.smartstudio.fbclm.injection.scopes.PerApplication;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * Created by juanyanezgc on 10/05/15.
 */
@PerApplication
public abstract class CommonOkHttpClient extends OkHttpClient {
    /**
     * Connection timeout in seconds
     */
    private static final int CONNECTION_TIMEOUT = 10;
    /**
     * Read timeout in seconds
     */
    private static final int READ_TIMEOUT = 20;

    /**
     * Creates an instance of FbclmOkHttpClient
     *
     * @param cache Cache used in the OKHttpClient
     **/
    public CommonOkHttpClient(Cache cache) {
        super();
        setCache(cache);
        setConnectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);
        setReadTimeout(READ_TIMEOUT, TimeUnit.SECONDS);
        setFollowRedirects(false);
        setFollowSslRedirects(false);
    }

}
