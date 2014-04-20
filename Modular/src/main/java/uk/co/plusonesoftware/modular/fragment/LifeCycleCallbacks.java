package uk.co.plusonesoftware.modular.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by James on 18/04/2014.
 */
public class LifeCycleCallbacks {
    public interface LifeCycleCallback extends FragmentModule.FragmentCallback {

    }

    public interface onActivityCreatedCallback extends LifeCycleCallback {
        void onActivityCreated(Fragment fragment, Bundle savedInstanceState);
    }

    public interface onCreateCallback extends LifeCycleCallback {
        void onCreate(Fragment fragment, Bundle savedInstanceState);
    }

    public interface onViewCreatedCallback extends LifeCycleCallback {
        void onViewCreated(Fragment fragment, View view, Bundle savedInstanceState);
    }

    public interface onStartCallback extends LifeCycleCallback {
        void onStart(Fragment fragment);
    }

    public interface onResumeCallback extends LifeCycleCallback {
        void onResume(Fragment fragment);
    }

    public interface onPauseCallback extends LifeCycleCallback {
        void onPause(Fragment fragment);
    }

    public interface onStopCallback extends LifeCycleCallback {
        void onStop(Fragment fragment);
    }

    public interface onDestroyViewCallback extends LifeCycleCallback {
        void onDestroyView(Fragment fragment);
    }

    public interface onDestroyCallback extends LifeCycleCallback {
        void onDestroy(Fragment fragment);
    }

    public interface onAttachCallback extends LifeCycleCallback {
        void onAttach(Fragment fragment, Activity activity);
    }

    public interface onDetachCallback extends LifeCycleCallback {
        void onDetach(Fragment fragment);
    }

    public interface onConfigurationChangedCallback extends LifeCycleCallback {
        void onConfigurationChanged(Fragment fragment, Configuration newConfig);
    }

    public interface onNewIntentCallback extends LifeCycleCallback {
        void onNewIntent(Fragment fragment, Intent intent);
    }

    public interface onActivityResultCallback extends LifeCycleCallback {
        void onActivityResultCallback(Fragment fragment, int requestCode, int resultCode, Intent data);
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
