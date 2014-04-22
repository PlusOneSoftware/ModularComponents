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
        void onActivityResultCallback(int requestCode, int resultCode, Intent data);
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
