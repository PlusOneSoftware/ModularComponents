package uk.co.plusonesoftware.modular.service;

import android.annotation.TargetApi;
import android.app.IntentService;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.IBinder;

import uk.co.plusonesoftware.modular.ModuleController;
import uk.co.plusonesoftware.modular.activity.ActivityModuleController;

/**
 * Created by James on 01/05/2014.
 */
public class ModularIntentService extends IntentService implements ModuleController.ModularComponent {

    ServiceModuleController mModule = createModuleController();

    public ModularIntentService(String name) {
        super(name);
    }

    protected ServiceModuleController createModuleController() {
        return new ServiceModuleController();
    }

    public ModuleController getModuleController() {
        return mModule;
    }

    @Override
    public void addCallbackListener(ModuleController.ComponentCallback callback) {
        mModule.addCallbackListener(callback);
    }

    @Override
    public void addCallbackListener(String method, ModuleController.MethodCallback callback) {
        mModule.addCallbackListener(method, callback);
    }

    @Override
    public void removeCallbackListener(ModuleController.ComponentCallback callback) {
        mModule.removeCallbackListener(callback);
    }

    @Override
    public boolean removeCallbackListener(String method, ModuleController.MethodCallback callback) {
        return mModule.removeCallbackListener(method, callback);
    }

    @Override
    public void registerMethod(String method) {
        mModule.registerMethod(method);
    }

    @Override
    public void removeMethod(String method) {
        mModule.removeMethod(method);
    }

    @Override
    public IBinder onBind(Intent intent) {
        mModule.onBind(intent);
        return null;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        mModule.onHandleIntent(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return mModule.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        mModule.onRebind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mModule.onStartCommand(intent, flags, startId);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mModule.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mModule.onDestroy();
    }

    @TargetApi(14)
    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        mModule.onTaskRemoved(rootIntent);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mModule.onConfigurationChanged(newConfig);
    }
}
