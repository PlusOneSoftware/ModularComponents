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

import uk.co.plusonesoftware.modular.ModuleController;

/**
 * Created by James on 22/04/2014.
 */
public class DrawerListenerModule implements DrawerLayout.DrawerListener {

    public static final String onDrawerSlide = "DrawerLayout.DrawerListener.onDrawerSlide";
    public static final String onDrawerOpened = "DrawerLayout.DrawerListener.onDrawerOpened";
    public static final String onDrawerClosed = "DrawerLayout.DrawerListener.onDrawerClosed";
    public static final String onDrawerStateChanged = "DrawerLayout.DrawerListener.onDrawerStateChanged";

    private ModuleController mController;
    private onDrawerSlideParams mOnDrawerSlideParams = new onDrawerSlideParams();

    DrawerListenerModule(ModuleController controller, DrawerLayout drawer) {
        mController = controller;
        mController.registerMethod(onDrawerSlide);
        mController.registerMethod(onDrawerOpened);
        mController.registerMethod(onDrawerClosed);
        mController.registerMethod(onDrawerStateChanged);
        drawer.setDrawerListener(this);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        mOnDrawerSlideParams.drawerView = drawerView;
        mOnDrawerSlideParams.slideOffset = slideOffset;
        mController.trigger(onDrawerSlide, mOnDrawerSlideParams);
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

    public static class onDrawerSlideParams {
        public View drawerView;
        public float slideOffset;
    }

    public void registerListener(DrawerLayout.DrawerListener listener) {
        registerListener(mController, listener);
    }

    public static void registerListener(ModuleController controller, final DrawerLayout.DrawerListener listener) {
        ModuleController.MethodCallback cb = new ModuleController.MethodCallback() {
            @Override
            public void trigger(String methodName, Object args) {
                if(onDrawerSlide.equals(methodName)) {
                    onDrawerSlideParams params = (onDrawerSlideParams) args;
                    listener.onDrawerSlide(params.drawerView, params.slideOffset);
                }
                else if(onDrawerStateChanged.equals(methodName)) {
                    listener.onDrawerStateChanged((Integer) args);
                }
                else {
                    View view = (View) args;
                    if(onDrawerOpened.equals(methodName)) {
                        listener.onDrawerOpened(view);
                    }
                    else if(onDrawerClosed.equals(methodName)) {
                        listener.onDrawerClosed(view);
                    }
                }
            }
        };
        controller.addCallbackListener(onDrawerSlide, cb);
        controller.addCallbackListener(onDrawerOpened, cb);
        controller.addCallbackListener(onDrawerClosed, cb);
        controller.addCallbackListener(onDrawerStateChanged, cb);
    }
}
