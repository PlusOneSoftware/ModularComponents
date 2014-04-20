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

import uk.co.plusonesoftware.modular.ComponentModule;

/**
 * Created by James on 18/04/2014.
 */
public class ActivityModule extends ComponentModule {

    public interface ActivityCallback {

    }

    private List<LifeCycleCallbacks.LifeCycleCallback> mLifeCycleCallbacks = new ArrayList<LifeCycleCallbacks.LifeCycleCallback>();
    private List<InstanceStateCallbacks.InstanceStateCallback> mInstanceStateCallbacks = new ArrayList<InstanceStateCallbacks.InstanceStateCallback>();
    private List<UserInteractionCallbacks.UserInteractionCallback> mUserInteractionCallbacks = new ArrayList<UserInteractionCallbacks.UserInteractionCallback>();
    private List<FragmentCallbacks.FragmentCallback> mFragmentCallbacks = new ArrayList<FragmentCallbacks.FragmentCallback>();
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

        if(cb instanceof MenuCallbacks.MenuCallback) {
            mMenuCallbacks.add((MenuCallbacks.MenuCallback) cb);
        }
    }

    public void removeCallbackListener(ActivityCallback cb) {
        mLifeCycleCallbacks.remove(cb);
        mInstanceStateCallbacks.remove(cb);
        mUserInteractionCallbacks.remove(cb);
        mFragmentCallbacks.remove(cb);
        mMenuCallbacks.remove(cb);
    }

    public void onAttachedToWindow(Activity activity) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onAttachedToWindowCallback) {
                ((LifeCycleCallbacks.onAttachedToWindowCallback) cb).onAttachedToWindow(activity);
            }
        }
    }

    public void onCreate(Activity activity, Bundle savedInstanceState) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onCreateCallback) {
                ((LifeCycleCallbacks.onCreateCallback) cb).onCreate(activity, savedInstanceState);
            }
        }
    }

    public void onPostCreate(Activity activity, Bundle savedInstanceState) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onPostCreateCallback) {
                ((LifeCycleCallbacks.onPostCreateCallback) cb).onPostCreate(activity, savedInstanceState);
            }
        }
    }

    public void onStart(Activity activity) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onStartCallback) {
                ((LifeCycleCallbacks.onStartCallback) cb).onStart(activity);
            }
        }
    }

    public void onResume(Activity activity) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onResumeCallback) {
                ((LifeCycleCallbacks.onResumeCallback) cb).onResume(activity);
            }
        }
    }

    public void onPostResume(Activity activity) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onPostResumeCallback) {
                ((LifeCycleCallbacks.onPostResumeCallback) cb).onPostResume(activity);
            }
        }
    }

    public void onPause(Activity activity) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onPauseCallback) {
                ((LifeCycleCallbacks.onPauseCallback) cb).onPause(activity);
            }
        }
    }

    public void onStop(Activity activity) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onStopCallback) {
                ((LifeCycleCallbacks.onStopCallback) cb).onStop(activity);
            }
        }
    }

    public void onFinish(Activity activity) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onFinishCallback) {
                ((LifeCycleCallbacks.onFinishCallback) cb).onFinish(activity);
            }
        }
    }
    public void onDestroy(Activity activity) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onDestroyCallback) {
                ((LifeCycleCallbacks.onDestroyCallback) cb).onDestroy(activity);
            }
        }
    }

    public void onDetachedFromWindow(Activity activity) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onDetachedFromWindowCallback) {
                ((LifeCycleCallbacks.onDetachedFromWindowCallback) cb).onDetachedFromWindow(activity);
            }
        }
    }

    public void onRestart(Activity activity) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onRestartCallback) {
                ((LifeCycleCallbacks.onRestartCallback) cb).onRestart(activity);
            }
        }
    }

    public void onConfigurationChanged(Activity activity, Configuration newConfig) {
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onConfigurationChangedCallback) {
                ((LifeCycleCallbacks.onConfigurationChangedCallback) cb).onConfigurationChanged(activity, newConfig);
            }
        }
    }

    public void onSaveInstanceState(Activity activity, Bundle outState) {
        if(mInstanceStateCallbacks.isEmpty()) {
            return;
        }
        for(InstanceStateCallbacks.InstanceStateCallback cb : mInstanceStateCallbacks) {
            if (cb instanceof InstanceStateCallbacks.onSaveInstanceStateCallback) {
                ((InstanceStateCallbacks.onSaveInstanceStateCallback) cb).onSaveInstanceState(activity, outState);
            }
        }
    }

    public void onRestoreInstanceState(Activity activity, Bundle savedInstanceState) {
        if(mInstanceStateCallbacks.isEmpty()) {
            return;
        }
        for(InstanceStateCallbacks.InstanceStateCallback cb: mInstanceStateCallbacks) {
            if (cb instanceof InstanceStateCallbacks.onRestoreInstanceStateCallback) {
                ((InstanceStateCallbacks.onRestoreInstanceStateCallback) cb).onRestoreInstanceState(activity, savedInstanceState);
            }
        }
    }

    public void onNewIntent(Activity activity, Intent intent) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onNewIntentCallback) {
                ((LifeCycleCallbacks.onNewIntentCallback) cb).onNewIntent(activity, intent);
            }
        }
    }

    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onActivityResultCallback) {
                ((LifeCycleCallbacks.onActivityResultCallback) cb).onActivityResultCallback(activity, requestCode, resultCode, data);
            }
        }
    }

    public void onBackPressed(Activity activity) {
        if(mUserInteractionCallbacks.isEmpty()) {
            return;
        }
        for(UserInteractionCallbacks.UserInteractionCallback cb : mUserInteractionCallbacks) {
            if (cb instanceof UserInteractionCallbacks.onBackPressedCallback) {
                ((UserInteractionCallbacks.onBackPressedCallback) cb).onBackPressed(activity);
            }
        }
    }

    public void onUserInteraction(Activity activity) {
        if(mUserInteractionCallbacks.isEmpty()) {
            return;
        }
        for(UserInteractionCallbacks.UserInteractionCallback cb : mUserInteractionCallbacks) {
            if (cb instanceof UserInteractionCallbacks.onUserInteractionCallback) {
                ((UserInteractionCallbacks.onUserInteractionCallback) cb).onUserInteraction(activity);
            }
        }
    }

    public void onAttachFragment(Activity activity, Fragment fragment) {
        if(mFragmentCallbacks.isEmpty()) {
            return;
        }
        for(FragmentCallbacks.FragmentCallback cb : mFragmentCallbacks) {
            if (cb instanceof FragmentCallbacks.onAttachFragmentCallback) {
                ((FragmentCallbacks.onAttachFragmentCallback) cb).onAttachFragment(activity, fragment);
            }
        }
    }

    public void onFragmentViewCreated(Activity activity, Fragment fragment, View view, Bundle savedInstanceState) {
        if(mFragmentCallbacks.isEmpty()) {
            return;
        }
        for(FragmentCallbacks.FragmentCallback cb : mFragmentCallbacks) {
            if(cb instanceof FragmentCallbacks.onFragmentViewCreatedCallback) {
                ((FragmentCallbacks.onFragmentViewCreatedCallback) cb).onFragmentViewCreated(activity, fragment, view, savedInstanceState);
            }
        }
    }

    public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
        if(mMenuCallbacks.isEmpty()) {
            return false;
        }
        boolean out = false;
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onCreateOptionsMenuCallback) {
                out = out || ((MenuCallbacks.onCreateOptionsMenuCallback) cb).onCreateOptionsMenu(activity, menu);
            }
        }
        return out;
    }

    public boolean onPrepareOptionsMenu(Activity activity, Menu menu) {
        if(mMenuCallbacks.isEmpty()) {
            return false;
        }
        boolean out = false;
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onPrepareOptionsMenuCallback) {
                out = out || ((MenuCallbacks.onPrepareOptionsMenuCallback) cb).onPrepareOptionsMenu(activity, menu);
            }
        }
        return out;
    }

    public boolean onOptionsItemSelected(Activity activity, MenuItem item) {
        if(mMenuCallbacks.isEmpty()) {
            return false;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onOptionsItemSelectedCallback) {
                if(((MenuCallbacks.onOptionsItemSelectedCallback) cb).onOptionsItemSelectedActivity(activity, item)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void onOptionsMenuClosed(Activity activity, Menu menu) {
        if(mMenuCallbacks.isEmpty()) {
            return;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onOptionsMenuClosedCallback) {
                ((MenuCallbacks.onOptionsMenuClosedCallback) cb).onOptionsMenuClosed(activity, menu);
            }
        }
    }

    public void onCreateContextMenu(Activity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(mMenuCallbacks.isEmpty()) {
            return;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onCreateContextMenuCallback) {
                ((MenuCallbacks.onCreateContextMenuCallback) cb).onCreateContextMenu(activity, menu, v, menuInfo);
            }
        }
    }

    public boolean onContextItemSelected(Activity activity, MenuItem item) {
        if(mMenuCallbacks.isEmpty()) {
            return false;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onContextItemSelectedCallback) {
                if(((MenuCallbacks.onContextItemSelectedCallback) cb).onContextItemSelected(activity, item)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void onContextMenuClosed(Activity activity, Menu menu) {
        if(mMenuCallbacks.isEmpty()) {
            return;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onContextMenuClosedCallback) {
                ((MenuCallbacks.onContextMenuClosedCallback) cb).onContextMenuClosed(activity, menu);
            }
        }
    }
}
