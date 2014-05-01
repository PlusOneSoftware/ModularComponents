/**
 * Copyright 2014 James R Wilding
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.plusonesoftware.modular.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by James on 18/04/2014.
 */
public class SupportFragmentCallbacks {

    public interface SupportFragmentCallback extends ActivityModuleController.ActivityCallback {

    }

    public interface onAttachFragmentCallback extends SupportFragmentCallback {
        void onAttachFragment(Fragment fragment);
    }

    public interface onFragmentViewCreatedCallback extends SupportFragmentCallback {
        void onFragmentViewCreated(Fragment fragment, View view, Bundle savedInstanceState);
    }

    public interface allCallbacks extends onAttachFragmentCallback, onFragmentViewCreatedCallback {

    }
}
