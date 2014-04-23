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
package uk.co.plusonesoftware.modular.fragment;

import android.os.Bundle;

/**
 * Created by James on 18/04/2014.
 */
public class InstanceStateCallbacks {

    public interface InstanceStateCallback extends FragmentModuleController.FragmentCallback {

    }

    public interface onSaveInstanceStateCallback {
        public void onSaveInstanceState(Bundle outState);
    }

    public interface onViewStateRestoredCallback {
        public void onViewStateRestored(Bundle savedInstanceState);
    }

    public interface persistInstanceStateCallback extends onSaveInstanceStateCallback, onViewStateRestoredCallback {

    }
}
