package uk.co.plusonesoftware.modular.service;

import android.content.Intent;

import uk.co.plusonesoftware.modular.ModuleController;

/**
 * Created by James on 01/05/2014.
 */
public class ServiceMiscCallbacks {
    public interface ServiceMiscCallback extends ServiceModuleController.ServiceCallback {

    }

    public interface onHandleIntentCallback extends ServiceMiscCallback {
        void onHandleIntent(Intent intent);
    }
}
