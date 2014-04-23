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

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * Created by James on 18/04/2014.
 */
public class LifeCycleCallbacks {
    public interface LifeCycleCallback extends ActivityModuleController.ActivityCallback {

    }

    public interface onCreateCallback extends LifeCycleCallback {
        void onCreate(Bundle savedInstanceState);
    }

    public interface onPostCreateCallback extends LifeCycleCallback {
        void onPostCreate(Bundle savedInstanceState);
    }

    public interface onStartCallback extends LifeCycleCallback {
        void onStart();
    }

    public interface onResumeCallback extends LifeCycleCallback {
        void onResume();
    }

    public interface onPostResumeCallback extends LifeCycleCallback {
        void onPostResume();
    }

    public interface onPauseCallback extends LifeCycleCallback {
        void onPause();
    }

    public interface onStopCallback extends LifeCycleCallback {
        void onStop();
    }

    public interface onFinishCallback extends LifeCycleCallback {
        void onFinish();
    }

    public interface onDestroyCallback extends LifeCycleCallback {
        void onDestroy();
    }

    public interface onAttachedToWindowCallback extends LifeCycleCallback {
        void onAttachedToWindow();
    }

    public interface onDetachedFromWindowCallback extends LifeCycleCallback {
        void onDetachedFromWindow();
    }

    public interface onRestartCallback extends LifeCycleCallback {
        void onRestart();
    }

    public interface onConfigurationChangedCallback extends LifeCycleCallback {
        void onConfigurationChanged(Configuration newConfig);
    }

    public interface onNewIntentCallback extends LifeCycleCallback {
        void onNewIntent(Intent intent);
    }

    public interface onActivityResultCallback extends LifeCycleCallback {
        void onActivityResult(int requestCode, int resultCode, Intent data);
    }

    public interface attachedCallback extends onAttachedToWindowCallback, onDetachedFromWindowCallback {

    }

    public interface focusedCallback extends onResumeCallback, onPauseCallback {

    }

    public interface visibleCallback extends onStartCallback, onStopCallback {

    }

    public interface activeCallback extends onCreateCallback, onDestroyCallback {

    }
}
