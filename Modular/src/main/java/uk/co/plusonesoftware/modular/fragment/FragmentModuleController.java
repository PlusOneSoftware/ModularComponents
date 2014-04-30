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
package uk.co.plusonesoftware.modular.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import uk.co.plusonesoftware.modular.InstanceStateCallbacks;
import uk.co.plusonesoftware.modular.ModuleController;
import uk.co.plusonesoftware.modular.LifeCycleCallbacks;
import uk.co.plusonesoftware.modular.MenuCallbacks;

/**
 * Created by James on 18/04/2014.
 */
public class FragmentModuleController extends ModuleController {

    public interface FragmentCallback extends ComponentCallback {

    }

    protected List<LifeCycleCallbacks.LifeCycleCallback> mLifeCycleCallbacks = new ArrayList<LifeCycleCallbacks.LifeCycleCallback>();
    protected List<InstanceStateCallbacks.InstanceStateCallback> mInstanceStateCallbacks = new ArrayList<InstanceStateCallbacks.InstanceStateCallback>();
    protected List<MenuCallbacks.MenuCallback> mMenuCallbacks = new ArrayList<MenuCallbacks.MenuCallback>();

    @Override
    public void addCallbackListener(ComponentCallback cb) {
        if(cb instanceof LifeCycleCallbacks.LifeCycleCallback) {
            mLifeCycleCallbacks.add((LifeCycleCallbacks.LifeCycleCallback) cb);
        }

        if(cb instanceof InstanceStateCallbacks.InstanceStateCallback) {
            mInstanceStateCallbacks.add((InstanceStateCallbacks.InstanceStateCallback) cb);
        }

        if(cb instanceof MenuCallbacks.MenuCallback) {
            mMenuCallbacks.add((MenuCallbacks.MenuCallback) cb);
        }
    }

    @Override
    public void removeCallbackListener(ComponentCallback cb) {
        mLifeCycleCallbacks.remove(cb);
        mInstanceStateCallbacks.remove(cb);
        mMenuCallbacks.remove(cb);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof FragmentLifeCycleCallbacks.onActivityCreatedCallback) {
                ((FragmentLifeCycleCallbacks.onActivityCreatedCallback) cb).onActivityCreated(savedInstanceState);
            }
        }
    }

    public void onAttach(Activity activity) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof FragmentLifeCycleCallbacks.onAttachCallback) {
                ((FragmentLifeCycleCallbacks.onAttachCallback) cb).onAttach(activity);
            }
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof FragmentLifeCycleCallbacks.onCreateCallback) {
                ((FragmentLifeCycleCallbacks.onCreateCallback) cb).onCreate(savedInstanceState);
            }
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof FragmentLifeCycleCallbacks.onViewCreatedCallback) {
                ((FragmentLifeCycleCallbacks.onViewCreatedCallback) cb).onViewCreated(view, savedInstanceState);
            }
        }
    }
    public void onStart() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof FragmentLifeCycleCallbacks.onStartCallback) {
                ((FragmentLifeCycleCallbacks.onStartCallback) cb).onStart();
            }
        }
    }

    public void onResume() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof FragmentLifeCycleCallbacks.onResumeCallback) {
                ((FragmentLifeCycleCallbacks.onResumeCallback) cb).onResume();
            }
        }
    }

    public void onPause() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof FragmentLifeCycleCallbacks.onPauseCallback) {
                ((FragmentLifeCycleCallbacks.onPauseCallback) cb).onPause();
            }
        }
    }

    public void onStop() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof FragmentLifeCycleCallbacks.onStopCallback) {
                ((FragmentLifeCycleCallbacks.onStopCallback) cb).onStop();
            }
        }
    }

    public void onDestroyView() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof FragmentLifeCycleCallbacks.onDestroyViewCallback) {
                ((FragmentLifeCycleCallbacks.onDestroyViewCallback) cb).onDestroyView();
            }
        }
    }
    public void onDestroy() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof FragmentLifeCycleCallbacks.onDestroyCallback) {
                ((FragmentLifeCycleCallbacks.onDestroyCallback) cb).onDestroy();
            }
        }
    }

    public void onDetach() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof FragmentLifeCycleCallbacks.onDetachCallback) {
                ((FragmentLifeCycleCallbacks.onDetachCallback) cb).onDetach();
            }
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof FragmentLifeCycleCallbacks.onConfigurationChangedCallback) {
                ((FragmentLifeCycleCallbacks.onConfigurationChangedCallback) cb).onConfigurationChanged(newConfig);
            }
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        if(mInstanceStateCallbacks.isEmpty()) {
            return;
        }
        for(InstanceStateCallbacks.InstanceStateCallback cb : mInstanceStateCallbacks) {
            if (cb instanceof InstanceStateCallbacks.onSaveInstanceStateCallback) {
                ((InstanceStateCallbacks.onSaveInstanceStateCallback) cb).onSaveInstanceState(outState);
            }
        }
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        if(mInstanceStateCallbacks.isEmpty()) {
            return;
        }
        for(InstanceStateCallbacks.InstanceStateCallback cb: mInstanceStateCallbacks) {
            if (cb instanceof InstanceStateCallbacks.onRestoreInstanceStateCallback) {
                ((InstanceStateCallbacks.onRestoreInstanceStateCallback) cb).onRestoreInstanceState(savedInstanceState);
            }
        }
    }

    public void onNewIntent(Intent intent) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof FragmentLifeCycleCallbacks.onNewIntentCallback) {
                ((FragmentLifeCycleCallbacks.onNewIntentCallback) cb).onNewIntent(intent);
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof FragmentLifeCycleCallbacks.onActivityResultCallback) {
                ((FragmentLifeCycleCallbacks.onActivityResultCallback) cb).onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    public void onCreateOptionsMenu(Menu menu) {
        if(mMenuCallbacks.isEmpty()) {
            return;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onCreateOptionsMenuCallback) {
                ((MenuCallbacks.onCreateOptionsMenuCallback) cb).onCreateOptionsMenu(menu);
            }
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        if(mMenuCallbacks.isEmpty()) {
            return;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onPrepareOptionsMenuCallback) {
                ((MenuCallbacks.onPrepareOptionsMenuCallback) cb).onPrepareOptionsMenu(menu);
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(mMenuCallbacks.isEmpty()) {
            return false;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onOptionsItemSelectedCallback) {
                if(((MenuCallbacks.onOptionsItemSelectedCallback) cb).onOptionsItemSelected(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
        if(mMenuCallbacks.isEmpty()) {
            return;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onOptionsMenuClosedCallback) {
                ((MenuCallbacks.onOptionsMenuClosedCallback) cb).onOptionsMenuClosed(menu);
            }
        }
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(mMenuCallbacks.isEmpty()) {
            return;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onCreateContextMenuCallback) {
                ((MenuCallbacks.onCreateContextMenuCallback) cb).onCreateContextMenu(menu, v, menuInfo);
            }
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        if(mMenuCallbacks.isEmpty()) {
            return false;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onContextItemSelectedCallback) {
                if(((MenuCallbacks.onContextItemSelectedCallback) cb).onContextItemSelected(item)) {
                    return true;
                }
            }
        }
        return false;
    }
}
