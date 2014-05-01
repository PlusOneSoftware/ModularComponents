package uk.co.plusonesoftware.modular.service;

import android.content.Intent;
import android.content.res.Configuration;

/**
 * Created by James on 01/05/2014.
 */
public class ServiceLifeCycleCallbacks {
    public interface ServiceLifeCycleCallback extends ServiceModuleController.ServiceCallback {

    }

    public interface onStartCommandCallback extends ServiceLifeCycleCallback {
        void onStartCommand(Intent intent, int flags, int startId);
    }

    public interface onCreateCallback extends ServiceLifeCycleCallback {
        void onCreate();
    }

    public interface onDestroyCallback extends ServiceLifeCycleCallback {
        void onDestroy();
    }

    public interface onTaskRemovedCallback extends ServiceLifeCycleCallback {
        void onTaskRemoved(Intent rootIntent);
    }

    public interface onConfigurationChangedCallback extends ServiceLifeCycleCallback {
        void onConfigurationChanged(Configuration newConfig);
    }
}
