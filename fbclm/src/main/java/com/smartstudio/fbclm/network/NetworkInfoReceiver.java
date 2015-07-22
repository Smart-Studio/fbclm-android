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

import android.content.BroadcastReceiver;

/**
 * Network info receiver that keeps track of the status of the network connection
 */
public abstract class NetworkInfoReceiver extends BroadcastReceiver {
    /**
     * Set the listener to notify of a change in the network to
     *
     * @param listener Listener to be notified
     **/
    public abstract void setNetworkListener(NetworkInfoReceiverListener listener);
}
