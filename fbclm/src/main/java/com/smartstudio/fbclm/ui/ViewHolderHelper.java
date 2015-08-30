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

import android.support.annotation.NonNull;
import android.view.ViewGroup;

/**
 * Interface definition for a helper class that creates and binds data into a view holder
 */
public interface ViewHolderHelper<VIEW_HOLDER_TYPE, MODEL_TYPE> {
    /**
     * Creates a new view holder for the specified type
     *
     * @param parent   View holder parent view
     * @param viewType Adapter view type
     * @return View holder for the given view type
     **/
    VIEW_HOLDER_TYPE getHolder(@NonNull ViewGroup parent, int viewType);

    /**
     * Binds the corresponding data into the view holder
     *
     * @param viewHolder View holder to bind the data to
     * @param item       Data to bind in the view holder
     **/
    void bind(@NonNull VIEW_HOLDER_TYPE viewHolder, @NonNull MODEL_TYPE item);
}
