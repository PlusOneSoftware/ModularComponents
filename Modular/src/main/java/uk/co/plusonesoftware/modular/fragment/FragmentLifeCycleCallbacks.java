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

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import uk.co.plusonesoftware.modular.LifeCycleCallbacks;

/**
 * Created by James on 18/04/2014.
 */
public class FragmentLifeCycleCallbacks extends LifeCycleCallbacks {

    public interface FragmentLifeCycleCallback extends LifeCycleCallback, FragmentModuleController.FragmentCallback {

    }

    public interface onActivityCreatedCallback extends FragmentLifeCycleCallback {
        void onActivityCreated(Bundle savedInstanceState);
    }

    public interface onViewCreatedCallback extends FragmentLifeCycleCallback {
        void onViewCreated(View view, Bundle savedInstanceState);
    }

    public interface onDestroyViewCallback extends FragmentLifeCycleCallback {
        void onDestroyView();
    }

    public interface onAttachCallback extends FragmentLifeCycleCallback {
        void onAttach(Activity activity);
    }

    public interface onDetachCallback extends FragmentLifeCycleCallback {
        void onDetach();
    }

    public interface onConfigurationChangedCallback extends FragmentLifeCycleCallback {
        void onConfigurationChanged(Configuration newConfig);
    }

    public interface onNewIntentCallback extends FragmentLifeCycleCallback {
        void onNewIntent(Intent intent);
    }

    public interface onActivityResultCallback extends FragmentLifeCycleCallback {
        void onActivityResult(int requestCode, int resultCode, Intent data);
    }
}
