package uk.co.plusonesoftware.modular.modules;

import android.support.v4.widget.DrawerLayout;
import android.util.Pair;
import android.view.View;

import uk.co.plusonesoftware.modular.CustomModuleController;

/**
 * Created by James on 22/04/2014.
 */
public class DrawerListenerModule implements DrawerLayout.DrawerListener {

    public static final String onDrawerSlide = "DrawerLayout.DrawerListener.onDrawerSlide";
    public static final String onDrawerOpened = "DrawerLayout.DrawerListener.onDrawerOpened";
    public static final String onDrawerClosed = "DrawerLayout.DrawerListener.onDrawerClosed";
    public static final String onDrawerStateChanged = "DrawerLayout.DrawerListener.onDrawerStateChanged";

    private CustomModuleController mController;

    DrawerListenerModule(CustomModuleController controller, DrawerLayout drawer) {
        mController = controller;
        mController.registerMethod(onDrawerSlide);
        mController.registerMethod(onDrawerOpened);
        mController.registerMethod(onDrawerClosed);
        mController.registerMethod(onDrawerStateChanged);
        drawer.setDrawerListener(this);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        mController.trigger(onDrawerSlide, Pair.create(drawerView, slideOffset));
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        mController.trigger(onDrawerOpened, drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        mController.trigger(onDrawerClosed, drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        mController.trigger(onDrawerStateChanged, newState);
    }
}
