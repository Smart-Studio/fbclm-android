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

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;

/**
 * {@link NetworkInfoReceiver} implementation
 */
public class NetworkInfoReceiverImpl extends NetworkInfoReceiver {
    private ConnectivityManager mConnectivityManager;
    private NetworkInfoReceiverListener mListener;

    @Inject
    public NetworkInfoReceiverImpl() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (mListener != null) {
            if (mConnectivityManager == null) {
                mConnectivityManager = (ConnectivityManager) context
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
            }

            NetworkInfo networkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                mListener.onNetworkConnected();
            } else {
                mListener.onNetworkDisconnected();
            }
        }
    }

    @Override
    public void setNetworkListener(NetworkInfoReceiverListener listener) {
        mListener = listener;
    }
}
