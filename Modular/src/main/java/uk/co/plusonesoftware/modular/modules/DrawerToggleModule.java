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

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Pair;
import android.view.View;

import uk.co.plusonesoftware.modular.ModuleController;
import uk.co.plusonesoftware.modular.activity.ActivityLifeCycleCallbacks;
import uk.co.plusonesoftware.modular.activity.ActivityMenuCallbacks;
import uk.co.plusonesoftware.modular.activity.ModularActivity;

/**
 * Created by James on 22/04/2014.
 */
public class DrawerToggleModule extends ActionBarDrawerToggle implements ActivityLifeCycleCallbacks.onPostCreateCallback, ActivityLifeCycleCallbacks.onConfigurationChangedCallback, ActivityMenuCallbacks.onOptionsItemSelectedCallback {

    public DrawerToggleModule(ModularActivity activity, DrawerLayout drawer, int icon, int open, int close) {
        super(activity, drawer, icon, open, close);
        activity.addCallbackListener(DrawerListenerModule.onDrawerSlide, new ModuleController.MethodCallback<Pair<View, Float>>() {
            @Override
            public void trigger(Pair<View, Float> args) {
                onDrawerSlide(args.first, args.second);
            }
        });
        activity.addCallbackListener(DrawerListenerModule.onDrawerOpened, new ModuleController.MethodCallback<View>() {
            @Override
            public void trigger(View args) {
                onDrawerOpened(args);
            }
        });
        activity.addCallbackListener(DrawerListenerModule.onDrawerClosed, new ModuleController.MethodCallback<View>() {
            @Override
            public void trigger(View args) {
                onDrawerClosed(args);
            }
        });
        activity.addCallbackListener(DrawerListenerModule.onDrawerStateChanged, new ModuleController.MethodCallback<Integer>() {
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
