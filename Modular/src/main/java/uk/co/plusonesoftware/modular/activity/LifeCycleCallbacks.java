package uk.co.plusonesoftware.modular.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * Created by James on 18/04/2014.
 */
public class LifeCycleCallbacks {
    public interface LifeCycleCallback extends ActivityModule.ActivityCallback {

    }

    public interface onCreateCallback extends LifeCycleCallback {
        void onCreate(Activity activity, Bundle savedInstanceState);
    }

    public interface onPostCreateCallback extends LifeCycleCallback {
        void onPostCreate(Activity activity, Bundle savedInstanceState);
    }

    public interface onStartCallback extends LifeCycleCallback {
        void onStart(Activity activity);
    }

    public interface onResumeCallback extends LifeCycleCallback {
        void onResume(Activity activity);
    }

    public interface onPostResumeCallback extends LifeCycleCallback {
        void onPostResume(Activity activity);
    }

    public interface onPauseCallback extends LifeCycleCallback {
        void onPause(Activity activity);
    }

    public interface onStopCallback extends LifeCycleCallback {
        void onStop(Activity activity);
    }

    public interface onFinishCallback extends LifeCycleCallback {
        void onFinish(Activity activity);
    }

    public interface onDestroyCallback extends LifeCycleCallback {
        void onDestroy(Activity activity);
    }

    public interface onAttachedToWindowCallback extends LifeCycleCallback {
        void onAttachedToWindow(Activity activity);
    }

    public interface onDetachedFromWindowCallback extends LifeCycleCallback {
        void onDetachedFromWindow(Activity activity);
    }

    public interface onRestartCallback extends LifeCycleCallback {
        void onRestart(Activity activity);
    }

    public interface onConfigurationChangedCallback extends LifeCycleCallback {
        void onConfigurationChanged(Activity activity, Configuration newConfig);
    }

    public interface onNewIntentCallback extends LifeCycleCallback {
        void onNewIntent(Activity activity, Intent intent);
    }

    public interface onActivityResultCallback extends LifeCycleCallback {
        void onActivityResultCallback(Activity activity, int requestCode, int resultCode, Intent data);
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
