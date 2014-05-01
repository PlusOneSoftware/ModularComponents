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
import android.os.Bundle;

import uk.co.plusonesoftware.modular.LifeCycleCallbacks;

/**
 * Created by James on 18/04/2014.
 */
public class ActivityLifeCycleCallbacks extends LifeCycleCallbacks {

    public interface ActivityLifeCycleCallback extends LifeCycleCallback, ActivityModuleController.ActivityCallback {

    }

    public interface onPostCreateCallback extends ActivityLifeCycleCallback {
        void onPostCreate(Bundle savedInstanceState);
    }

    public interface onPostResumeCallback extends ActivityLifeCycleCallback {
        void onPostResume();
    }

    public interface onFinishCallback extends ActivityLifeCycleCallback {
        void onFinish();
    }

    public interface onAttachedToWindowCallback extends ActivityLifeCycleCallback {
        void onAttachedToWindow();
    }

    public interface onDetachedFromWindowCallback extends ActivityLifeCycleCallback {
        void onDetachedFromWindow();
    }

    public interface onRestartCallback extends ActivityLifeCycleCallback {
        void onRestart();
    }

    public interface onNewIntentCallback extends ActivityLifeCycleCallback {
        void onNewIntent(Intent intent);
    }

    public interface attachedCallback extends onAttachedToWindowCallback, onDetachedFromWindowCallback {

    }

    public interface allCallbacks extends LifeCycleCallbacks.allCallbacks, onPostCreateCallback, onPostResumeCallback, onFinishCallback, onRestartCallback, onNewIntentCallback, attachedCallback {

    }
}
