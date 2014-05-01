package uk.co.plusonesoftware.modular.service;

import android.content.Intent;
import android.content.res.Configuration;

import java.util.ArrayList;
import java.util.List;

import uk.co.plusonesoftware.modular.ModuleController;

/**
 * Created by James on 01/05/2014.
 */
public class ServiceModuleController extends ModuleController {

    protected List<ServiceLifeCycleCallbacks.ServiceLifeCycleCallback> mLifeCycleCallbacks = new ArrayList<ServiceLifeCycleCallbacks.ServiceLifeCycleCallback>();
    protected List<ServiceBindCallbacks.ServiceBindCallback> mBindCallbacks = new ArrayList<ServiceBindCallbacks.ServiceBindCallback>();
    protected List<ServiceMiscCallbacks.ServiceMiscCallback> mMiscCallbacks = new ArrayList<ServiceMiscCallbacks.ServiceMiscCallback>();

    @Override
    public void addCallbackListener(ComponentCallback cb) {
        if(cb instanceof ServiceLifeCycleCallbacks) {
            mLifeCycleCallbacks.add((ServiceLifeCycleCallbacks.ServiceLifeCycleCallback) cb);
        }

        if(cb instanceof ServiceBindCallbacks) {
            mBindCallbacks.add((ServiceBindCallbacks.ServiceBindCallback) cb);
        }

        if(cb instanceof ServiceMiscCallbacks.ServiceMiscCallback) {
            mMiscCallbacks.add((ServiceMiscCallbacks.ServiceMiscCallback) cb);
        }
    }

    @Override
    public void removeCallbackListener(ComponentCallback cb) {
        mLifeCycleCallbacks.remove(cb);
        mBindCallbacks.remove(cb);
        mMiscCallbacks.remove(cb);
    }

    public void onBind(Intent intent) {
        if(mBindCallbacks.isEmpty()) {
            return;
        }

        for(ServiceBindCallbacks.ServiceBindCallback cb : mBindCallbacks) {
            if(cb instanceof ServiceBindCallbacks.onBindCallback) {
                ((ServiceBindCallbacks.onBindCallback) cb).onBind(intent);
            }
        }
    }

    public boolean onUnbind(Intent intent) {
        if(mBindCallbacks.isEmpty()) {
            return false;
        }

        boolean rebind = false;
        for(ServiceBindCallbacks.ServiceBindCallback cb : mBindCallbacks) {
            if(cb instanceof ServiceBindCallbacks.onUnbindCallback) {
                if(((ServiceBindCallbacks.onUnbindCallback) cb).onUnbind(intent)) {
                    rebind = true;
                }
            }
        }

        return rebind;
    }

    public void onRebind(Intent intent) {
        if(mBindCallbacks.isEmpty()) {
            return;
        }

        for(ServiceBindCallbacks.ServiceBindCallback cb : mBindCallbacks) {
            if(cb instanceof ServiceBindCallbacks.onRebindCallback) {
                ((ServiceBindCallbacks.onRebindCallback) cb).onRebind(intent);
            }
        }
    }

    public void onStartCommand(Intent intent, int flags, int startId) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }

        for(ServiceLifeCycleCallbacks.ServiceLifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof ServiceLifeCycleCallbacks.onStartCommandCallback) {
                ((ServiceLifeCycleCallbacks.onStartCommandCallback) cb).onStartCommand(intent, flags, startId);
            }
        }
    }


    public void onCreate() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }

        for(ServiceLifeCycleCallbacks.ServiceLifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof ServiceLifeCycleCallbacks.onCreateCallback) {
                ((ServiceLifeCycleCallbacks.onCreateCallback) cb).onCreate();
            }
        }
    }

    public void onDestroy() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }

        for(ServiceLifeCycleCallbacks.ServiceLifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof ServiceLifeCycleCallbacks.onDestroyCallback) {
                ((ServiceLifeCycleCallbacks.onDestroyCallback) cb).onDestroy();
            }
        }
    }

    public void onTaskRemoved(Intent rootIntent) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }

        for(ServiceLifeCycleCallbacks.ServiceLifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof ServiceLifeCycleCallbacks.onTaskRemovedCallback) {
                ((ServiceLifeCycleCallbacks.onTaskRemovedCallback) cb).onTaskRemoved(rootIntent);
            }
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }

        for(ServiceLifeCycleCallbacks.ServiceLifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof ServiceLifeCycleCallbacks.onConfigurationChangedCallback) {
                ((ServiceLifeCycleCallbacks.onConfigurationChangedCallback) cb).onConfigurationChanged(newConfig);
            }
        }
    }

    public void onHandleIntent(Intent intent) {
        if(mMiscCallbacks.isEmpty()) {
            return;
        }

        for(ServiceMiscCallbacks.ServiceMiscCallback cb : mMiscCallbacks) {
            if(cb instanceof ServiceMiscCallbacks.ServiceMiscCallback) {
                ((ServiceMiscCallbacks.onHandleIntentCallback) cb).onHandleIntent(intent);
            }
        }
    }
}
