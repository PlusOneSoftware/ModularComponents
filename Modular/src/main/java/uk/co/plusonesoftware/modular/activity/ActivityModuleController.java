package uk.co.plusonesoftware.modular.activity;

import android.app.Activity;
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

import uk.co.plusonesoftware.modular.CustomModuleController;

/**
 * Created by James on 18/04/2014.
 */
public class ActivityModuleController extends CustomModuleController {

    public interface ActivityCallback {

    }

    private List<LifeCycleCallbacks.LifeCycleCallback> mLifeCycleCallbacks = new ArrayList<LifeCycleCallbacks.LifeCycleCallback>();
    private List<InstanceStateCallbacks.InstanceStateCallback> mInstanceStateCallbacks = new ArrayList<InstanceStateCallbacks.InstanceStateCallback>();
    private List<UserInteractionCallbacks.UserInteractionCallback> mUserInteractionCallbacks = new ArrayList<UserInteractionCallbacks.UserInteractionCallback>();
    private List<FragmentCallbacks.FragmentCallback> mFragmentCallbacks = new ArrayList<FragmentCallbacks.FragmentCallback>();
    private List<SupportFragmentCallbacks.SupportFragmentCallback> mSupportFragmentCallbacks = new ArrayList<SupportFragmentCallbacks.SupportFragmentCallback>();
    private List<MenuCallbacks.MenuCallback> mMenuCallbacks = new ArrayList<MenuCallbacks.MenuCallback>();

    public void addCallbackListener(ActivityCallback cb) {
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

    public void removeCallbackListener(ActivityCallback cb) {
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
            if (cb instanceof LifeCycleCallbacks.onAttachedToWindowCallback) {
                ((LifeCycleCallbacks.onAttachedToWindowCallback) cb).onAttachedToWindow();
            }
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onCreateCallback) {
                ((LifeCycleCallbacks.onCreateCallback) cb).onCreate(savedInstanceState);
            }
        }
    }

    public void onPostCreate(Bundle savedInstanceState) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onPostCreateCallback) {
                ((LifeCycleCallbacks.onPostCreateCallback) cb).onPostCreate(savedInstanceState);
            }
        }
    }

    public void onStart() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onStartCallback) {
                ((LifeCycleCallbacks.onStartCallback) cb).onStart();
            }
        }
    }

    public void onResume() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onResumeCallback) {
                ((LifeCycleCallbacks.onResumeCallback) cb).onResume();
            }
        }
    }

    public void onPostResume(Activity activity) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onPostResumeCallback) {
                ((LifeCycleCallbacks.onPostResumeCallback) cb).onPostResume();
            }
        }
    }

    public void onPause() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onPauseCallback) {
                ((LifeCycleCallbacks.onPauseCallback) cb).onPause();
            }
        }
    }

    public void onStop() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onStopCallback) {
                ((LifeCycleCallbacks.onStopCallback) cb).onStop();
            }
        }
    }

    public void onFinish() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onFinishCallback) {
                ((LifeCycleCallbacks.onFinishCallback) cb).onFinish();
            }
        }
    }
    public void onDestroy() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onDestroyCallback) {
                ((LifeCycleCallbacks.onDestroyCallback) cb).onDestroy();
            }
        }
    }

    public void onDetachedFromWindow() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onDetachedFromWindowCallback) {
                ((LifeCycleCallbacks.onDetachedFromWindowCallback) cb).onDetachedFromWindow();
            }
        }
    }

    public void onRestart() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onRestartCallback) {
                ((LifeCycleCallbacks.onRestartCallback) cb).onRestart();
            }
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onConfigurationChangedCallback) {
                ((LifeCycleCallbacks.onConfigurationChangedCallback) cb).onConfigurationChanged( newConfig);
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
            if(cb instanceof LifeCycleCallbacks.onNewIntentCallback) {
                ((LifeCycleCallbacks.onNewIntentCallback) cb).onNewIntent(intent);
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onActivityResultCallback) {
                ((LifeCycleCallbacks.onActivityResultCallback) cb).onActivityResult(requestCode, resultCode, data);
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
            if(cb instanceof MenuCallbacks.onCreateOptionsMenuCallback) {
                out = out || ((MenuCallbacks.onCreateOptionsMenuCallback) cb).onCreateOptionsMenu(menu);
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
            if(cb instanceof MenuCallbacks.onPrepareOptionsMenuCallback) {
                out = out || ((MenuCallbacks.onPrepareOptionsMenuCallback) cb).onPrepareOptionsMenu(menu);
            }
        }
        return out;
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

    public void onContextMenuClosed(Menu menu) {
        if(mMenuCallbacks.isEmpty()) {
            return;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onContextMenuClosedCallback) {
                ((MenuCallbacks.onContextMenuClosedCallback) cb).onContextMenuClosed(menu);
            }
        }
    }
}
