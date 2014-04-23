/**
 * Copyright 2014 James R Wilding
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
