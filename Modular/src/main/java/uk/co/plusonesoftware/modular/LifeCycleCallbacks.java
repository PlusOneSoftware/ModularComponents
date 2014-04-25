package uk.co.plusonesoftware.modular;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * Created by James on 24/04/2014.
 */
public class LifeCycleCallbacks {

    public interface LifeCycleCallback extends ModuleController.ComponentCallback {

    }

    public interface onCreateCallback extends LifeCycleCallback {
        void onCreate(Bundle savedInstanceState);
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

    public interface onDestroyCallback extends LifeCycleCallback {
        void onDestroy();
    }

    public interface onConfigurationChangedCallback extends LifeCycleCallback {
        void onConfigurationChanged(Configuration newConfig);
    }

    public interface onActivityResultCallback extends LifeCycleCallback {
        void onActivityResult(int requestCode, int resultCode, Intent data);
    }

    public interface focusedCallback extends onResumeCallback, onPauseCallback {

    }

    public interface visibleCallback extends onStartCallback, onStopCallback {

    }

    public interface activeCallback extends onCreateCallback, onDestroyCallback {

    }

}
