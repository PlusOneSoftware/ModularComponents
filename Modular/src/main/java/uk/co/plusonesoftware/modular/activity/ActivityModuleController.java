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
package uk.co.plusonesoftware.modular.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class ActivityModuleController extends ModuleController {

    public interface ActivityCallback extends ComponentCallback {

    }

    protected List<LifeCycleCallbacks.LifeCycleCallback> mLifeCycleCallbacks = new ArrayList<LifeCycleCallbacks.LifeCycleCallback>();
    protected List<InstanceStateCallbacks.InstanceStateCallback> mInstanceStateCallbacks = new ArrayList<InstanceStateCallbacks.InstanceStateCallback>();
    protected List<UserInteractionCallbacks.UserInteractionCallback> mUserInteractionCallbacks = new ArrayList<UserInteractionCallbacks.UserInteractionCallback>();
    protected List<FragmentCallbacks.FragmentCallback> mFragmentCallbacks = new ArrayList<FragmentCallbacks.FragmentCallback>();
    protected List<SupportFragmentCallbacks.SupportFragmentCallback> mSupportFragmentCallbacks = new ArrayList<SupportFragmentCallbacks.SupportFragmentCallback>();
    protected List<MenuCallbacks.MenuCallback> mMenuCallbacks = new ArrayList<MenuCallbacks.MenuCallback>();

    @Override
    public void addCallbackListener(ComponentCallback cb) {
        if(cb instanceof LifeCycleCallbacks.LifeCycleCallback) {
            mLifeCycleCallbacks.add((LifeCycleCallbacks.LifeCycleCallback) cb);
        }

        if(cb instanceof InstanceStateCallbacks.InstanceStateCallback) {
            mInstanceStateCallbacks.add((InstanceStateCallbacks.InstanceStateCallback) cb);
        }

        if(cb instanceof UserInteractionCallbacks.UserInteractionCallback) {
            mUserInteractionCallbacks.add((UserInteractionCallbacks.UserInteractionCallback) cb);
        }

        if(cb instanceof FragmentCallbacks.FragmentCallback) {
            mFragmentCallbacks.add((FragmentCallbacks.FragmentCallback) cb);
        }

        if(cb instanceof SupportFragmentCallbacks.SupportFragmentCallback) {
            mSupportFragmentCallbacks.add((SupportFragmentCallbacks.SupportFragmentCallback) cb);
        }

        if(cb instanceof MenuCallbacks.MenuCallback) {
            mMenuCallbacks.add((MenuCallbacks.MenuCallback) cb);
        }
    }

    @Override
    public void removeCallbackListener(ComponentCallback cb) {
        mLifeCycleCallbacks.remove(cb);
        mInstanceStateCallbacks.remove(cb);
        mUserInteractionCallbacks.remove(cb);
        mFragmentCallbacks.remove(cb);
        mSupportFragmentCallbacks.remove(cb);
        mMenuCallbacks.remove(cb);
    }

    public void onAttachedToWindow() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof ActivityLifeCycleCallbacks.onAttachedToWindowCallback) {
                ((ActivityLifeCycleCallbacks.onAttachedToWindowCallback) cb).onAttachedToWindow();
            }
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof ActivityLifeCycleCallbacks.onCreateCallback) {
                ((ActivityLifeCycleCallbacks.onCreateCallback) cb).onCreate(savedInstanceState);
            }
        }
    }

    public void onPostCreate(Bundle savedInstanceState) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof ActivityLifeCycleCallbacks.onPostCreateCallback) {
                ((ActivityLifeCycleCallbacks.onPostCreateCallback) cb).onPostCreate(savedInstanceState);
            }
        }
    }

    public void onStart() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof ActivityLifeCycleCallbacks.onStartCallback) {
                ((ActivityLifeCycleCallbacks.onStartCallback) cb).onStart();
            }
        }
    }

    public void onResume() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof ActivityLifeCycleCallbacks.onResumeCallback) {
                ((ActivityLifeCycleCallbacks.onResumeCallback) cb).onResume();
            }
        }
    }

    public void onPostResume() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof ActivityLifeCycleCallbacks.onPostResumeCallback) {
                ((ActivityLifeCycleCallbacks.onPostResumeCallback) cb).onPostResume();
            }
        }
    }

    public void onPause() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof ActivityLifeCycleCallbacks.onPauseCallback) {
                ((ActivityLifeCycleCallbacks.onPauseCallback) cb).onPause();
            }
        }
    }

    public void onStop() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof ActivityLifeCycleCallbacks.onStopCallback) {
                ((ActivityLifeCycleCallbacks.onStopCallback) cb).onStop();
            }
        }
    }

    public void onFinish() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof ActivityLifeCycleCallbacks.onFinishCallback) {
                ((ActivityLifeCycleCallbacks.onFinishCallback) cb).onFinish();
            }
        }
    }
    public void onDestroy() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof ActivityLifeCycleCallbacks.onDestroyCallback) {
                ((ActivityLifeCycleCallbacks.onDestroyCallback) cb).onDestroy();
            }
        }
    }

    public void onDetachedFromWindow() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof ActivityLifeCycleCallbacks.onDetachedFromWindowCallback) {
                ((ActivityLifeCycleCallbacks.onDetachedFromWindowCallback) cb).onDetachedFromWindow();
            }
        }
    }

    public void onRestart() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof ActivityLifeCycleCallbacks.onRestartCallback) {
                ((ActivityLifeCycleCallbacks.onRestartCallback) cb).onRestart();
            }
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof ActivityLifeCycleCallbacks.onConfigurationChangedCallback) {
                ((ActivityLifeCycleCallbacks.onConfigurationChangedCallback) cb).onConfigurationChanged( newConfig);
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

    public void onRestoreInstanceState(Bundle savedInstanceState) {
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
            if(cb instanceof ActivityLifeCycleCallbacks.onNewIntentCallback) {
                ((ActivityLifeCycleCallbacks.onNewIntentCallback) cb).onNewIntent(intent);
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof ActivityLifeCycleCallbacks.onActivityResultCallback) {
                ((ActivityLifeCycleCallbacks.onActivityResultCallback) cb).onActivityResult(requestCode, resultCode, data);
            }
        }
    }

    public void onBackPressed() {
        if(mUserInteractionCallbacks.isEmpty()) {
            return;
        }
        for(UserInteractionCallbacks.UserInteractionCallback cb : mUserInteractionCallbacks) {
            if (cb instanceof UserInteractionCallbacks.onBackPressedCallback) {
                ((UserInteractionCallbacks.onBackPressedCallback) cb).onBackPressed();
            }
        }
    }

    public void onUserInteraction() {
        if(mUserInteractionCallbacks.isEmpty()) {
            return;
        }
        for(UserInteractionCallbacks.UserInteractionCallback cb : mUserInteractionCallbacks) {
            if (cb instanceof UserInteractionCallbacks.onUserInteractionCallback) {
                ((UserInteractionCallbacks.onUserInteractionCallback) cb).onUserInteraction();
            }
        }
    }

    public void onUserLeaveHint() {
        if(mUserInteractionCallbacks.isEmpty()) {
            return;
        }
        for(UserInteractionCallbacks.UserInteractionCallback cb : mUserInteractionCallbacks) {
            if(cb instanceof UserInteractionCallbacks.onUserLeaveHintCallback) {
                ((UserInteractionCallbacks.onUserLeaveHintCallback) cb).onUserLeaveHintCallback();
            }
        }
    }

    public void onAttachFragment(Fragment fragment) {
        if(mSupportFragmentCallbacks.isEmpty()) {
            return;
        }
        for(SupportFragmentCallbacks.SupportFragmentCallback cb : mSupportFragmentCallbacks) {
            if (cb instanceof SupportFragmentCallbacks.onAttachFragmentCallback) {
                ((SupportFragmentCallbacks.onAttachFragmentCallback) cb).onAttachFragment(fragment);
            }
        }
    }

    public void onAttachFragment(android.app.Fragment fragment) {
        if(mFragmentCallbacks.isEmpty()) {
            return;
        }
        for(FragmentCallbacks.FragmentCallback cb : mFragmentCallbacks) {
            if (cb instanceof FragmentCallbacks.onAttachFragmentCallback) {
                ((FragmentCallbacks.onAttachFragmentCallback) cb).onAttachFragment(fragment);
            }
        }
    }

    public void onFragmentViewCreated(Fragment fragment, View view, Bundle savedInstanceState) {
        if(mSupportFragmentCallbacks.isEmpty()) {
            return;
        }
        for(SupportFragmentCallbacks.SupportFragmentCallback cb : mSupportFragmentCallbacks) {
            if(cb instanceof SupportFragmentCallbacks.onFragmentViewCreatedCallback) {
                ((SupportFragmentCallbacks.onFragmentViewCreatedCallback) cb).onFragmentViewCreated(fragment, view, savedInstanceState);
            }
        }
    }

    public void onFragmentViewCreated(android.app.Fragment fragment, View view, Bundle savedInstanceState) {
        if(mFragmentCallbacks.isEmpty()) {
            return;
        }
        for(FragmentCallbacks.FragmentCallback cb : mFragmentCallbacks) {
            if(cb instanceof FragmentCallbacks.onFragmentViewCreatedCallback) {
                ((FragmentCallbacks.onFragmentViewCreatedCallback) cb).onFragmentViewCreated(fragment, view, savedInstanceState);
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if(mMenuCallbacks.isEmpty()) {
            return false;
        }
        boolean out = false;
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof ActivityMenuCallbacks.onCreateOptionsMenuCallback) {
                out = out || ((ActivityMenuCallbacks.onCreateOptionsMenuCallback) cb).onCreateOptionsMenu(menu);
            }
        }
        return out;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if(mMenuCallbacks.isEmpty()) {
            return false;
        }
        boolean out = false;
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof ActivityMenuCallbacks.onPrepareOptionsMenuCallback) {
                out = out || ((ActivityMenuCallbacks.onPrepareOptionsMenuCallback) cb).onPrepareOptionsMenu(menu);
            }
        }
        return out;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(mMenuCallbacks.isEmpty()) {
            return false;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof ActivityMenuCallbacks.onOptionsItemSelectedCallback) {
                if(((ActivityMenuCallbacks.onOptionsItemSelectedCallback) cb).onOptionsItemSelected(item)) {
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
            if(cb instanceof ActivityMenuCallbacks.onOptionsMenuClosedCallback) {
                ((ActivityMenuCallbacks.onOptionsMenuClosedCallback) cb).onOptionsMenuClosed(menu);
            }
        }
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(mMenuCallbacks.isEmpty()) {
            return;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof ActivityMenuCallbacks.onCreateContextMenuCallback) {
                ((ActivityMenuCallbacks.onCreateContextMenuCallback) cb).onCreateContextMenu(menu, v, menuInfo);
            }
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        if(mMenuCallbacks.isEmpty()) {
            return false;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof ActivityMenuCallbacks.onContextItemSelectedCallback) {
                if(((ActivityMenuCallbacks.onContextItemSelectedCallback) cb).onContextItemSelected(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void onContextMenuClosed(Menu menu) {
        if(mMenuCallbacks.isEmpty()) {
            return;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof ActivityMenuCallbacks.onContextMenuClosedCallback) {
                ((ActivityMenuCallbacks.onContextMenuClosedCallback) cb).onContextMenuClosed(menu);
            }
        }
    }
}
