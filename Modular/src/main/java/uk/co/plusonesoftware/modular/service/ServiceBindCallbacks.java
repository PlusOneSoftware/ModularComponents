package uk.co.plusonesoftware.modular.service;

import android.content.Intent;

import uk.co.plusonesoftware.modular.ModuleController;

/**
 * Created by James on 01/05/2014.
 */
public class ServiceBindCallbacks {
    public interface ServiceBindCallback extends ModuleController.ComponentCallback {

    }

    public interface onBindCallback extends ServiceBindCallback {
        void onBind(Intent intent);
    }

    public interface onUnbindCallback extends ServiceBindCallback {
        boolean onUnbind(Intent intent);
    }

    public interface onRebindCallback extends ServiceBindCallback {
        void onRebind(Intent intent);
    }
}
