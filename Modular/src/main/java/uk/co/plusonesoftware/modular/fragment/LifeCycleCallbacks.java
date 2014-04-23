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

/**
 * Created by James on 18/04/2014.
 */
public class LifeCycleCallbacks {
    public interface LifeCycleCallback extends FragmentModuleController.FragmentCallback {

    }

    public interface onActivityCreatedCallback extends LifeCycleCallback {
        void onActivityCreated(Bundle savedInstanceState);
    }

    public interface onCreateCallback extends LifeCycleCallback {
        void onCreate(Bundle savedInstanceState);
    }

    public interface onViewCreatedCallback extends LifeCycleCallback {
        void onViewCreated(View view, Bundle savedInstanceState);
    }

    public interface onStartCallback extends LifeCycleCallback {
        void onStart();
    }

    public interface onResumeCallback extends LifeCycleCallback {
        void onResume();
    }

    public interface onPauseCallback extends LifeCycleCallback {
        void onPause();
    }

    public interface onStopCallback extends LifeCycleCallback {
        void onStop();
    }

    public interface onDestroyViewCallback extends LifeCycleCallback {
        void onDestroyView();
    }

    public interface onDestroyCallback extends LifeCycleCallback {
        void onDestroy();
    }

    public interface onAttachCallback extends LifeCycleCallback {
        void onAttach(Activity activity);
    }

    public interface onDetachCallback extends LifeCycleCallback {
        void onDetach();
    }

    public interface onConfigurationChangedCallback extends LifeCycleCallback {
        void onConfigurationChanged(Configuration newConfig);
    }

    public interface onNewIntentCallback extends LifeCycleCallback {
        void onNewIntent(Intent intent);
    }

    public interface onActivityResultCallback extends LifeCycleCallback {
        void onActivityResultCallback(int requestCode, int resultCode, Intent data);
    }

    public interface focusedCallback extends onResumeCallback, onPauseCallback {

    }

    public interface visibleCallback extends onStartCallback, onStopCallback {

    }

    public interface activeCallback extends onCreateCallback, onDestroyCallback {

    }

    public interface attachedCallback extends onAttachCallback, onDetachCallback {

    }
}
