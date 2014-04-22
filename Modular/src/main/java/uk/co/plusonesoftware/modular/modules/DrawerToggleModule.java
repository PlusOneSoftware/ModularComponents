package uk.co.plusonesoftware.modular.modules;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Pair;
import android.view.View;

import uk.co.plusonesoftware.modular.CustomModuleController;
import uk.co.plusonesoftware.modular.activity.LifeCycleCallbacks;
import uk.co.plusonesoftware.modular.activity.MenuCallbacks;
import uk.co.plusonesoftware.modular.activity.ModularActivity;

/**
 * Created by James on 22/04/2014.
 */
public class DrawerToggleModule extends ActionBarDrawerToggle implements LifeCycleCallbacks.onPostCreateCallback, LifeCycleCallbacks.onConfigurationChangedCallback, MenuCallbacks.onOptionsItemSelectedCallback {

    public DrawerToggleModule(ModularActivity activity, DrawerLayout drawer, int icon, int open, int close) {
        super(activity, drawer, icon, open, close);
        activity.addCallbackListener(DrawerListenerModule.onDrawerSlide, new CustomModuleController.ModuleMethodCallback<Pair<View, Float>>() {
            @Override
            public void trigger(Pair<View, Float> args) {
                onDrawerSlide(args.first, args.second);
            }
        });
        activity.addCallbackListener(DrawerListenerModule.onDrawerOpened, new CustomModuleController.ModuleMethodCallback<View>() {
            @Override
            public void trigger(View args) {
                onDrawerOpened(args);
            }
        });
        activity.addCallbackListener(DrawerListenerModule.onDrawerClosed, new CustomModuleController.ModuleMethodCallback<View>() {
            @Override
            public void trigger(View args) {
                onDrawerClosed(args);
            }
        });
        activity.addCallbackListener(DrawerListenerModule.onDrawerStateChanged, new CustomModuleController.ModuleMethodCallback<Integer>() {
            @Override
            public void trigger(Integer args) {
                onDrawerStateChanged(args);
            }
        });
    }

    //// ActionBarDrawerToggler doesn't have a onPostCreate method, so we override it to provide the correct implementation
    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        syncState();
    }
}
