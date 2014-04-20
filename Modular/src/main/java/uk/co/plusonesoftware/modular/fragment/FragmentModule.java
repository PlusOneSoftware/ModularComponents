package uk.co.plusonesoftware.modular.fragment;

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
public class FragmentModule extends ComponentModule {

    public interface FragmentCallback {

    }

    private List<LifeCycleCallbacks.LifeCycleCallback> mLifeCycleCallbacks = new ArrayList<LifeCycleCallbacks.LifeCycleCallback>();
    private List<InstanceStateCallbacks.InstanceStateCallback> mInstanceStateCallbacks = new ArrayList<InstanceStateCallbacks.InstanceStateCallback>();
    private List<MenuCallbacks.MenuCallback> mMenuCallbacks = new ArrayList<MenuCallbacks.MenuCallback>();

    public void addCallbackListener(FragmentCallback cb) {
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

    public void removeCallbackListener(FragmentCallback cb) {
        mLifeCycleCallbacks.remove(cb);
        mInstanceStateCallbacks.remove(cb);
        mMenuCallbacks.remove(cb);
    }

    public void onActivityCreated(Fragment fragment, Bundle savedInstanceState) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onActivityCreatedCallback) {
                ((LifeCycleCallbacks.onActivityCreatedCallback) cb).onActivityCreated(fragment, savedInstanceState);
            }
        }
    }

    public void onAttach(Fragment fragment, Activity activity) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onAttachCallback) {
                ((LifeCycleCallbacks.onAttachCallback) cb).onAttach(fragment, activity);
            }
        }
    }

    public void onCreate(Fragment fragment, Bundle savedInstanceState) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onCreateCallback) {
                ((LifeCycleCallbacks.onCreateCallback) cb).onCreate(fragment, savedInstanceState);
            }
        }
    }

    public void onViewCreated(Fragment fragment, View view, Bundle savedInstanceState) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onViewCreatedCallback) {
                ((LifeCycleCallbacks.onViewCreatedCallback) cb).onViewCreated(fragment, view, savedInstanceState);
            }
        }
    }
    public void onStart(Fragment fragment) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onStartCallback) {
                ((LifeCycleCallbacks.onStartCallback) cb).onStart(fragment);
            }
        }
    }

    public void onResume(Fragment fragment) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onResumeCallback) {
                ((LifeCycleCallbacks.onResumeCallback) cb).onResume(fragment);
            }
        }
    }

    public void onPause(Fragment fragment) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onPauseCallback) {
                ((LifeCycleCallbacks.onPauseCallback) cb).onPause(fragment);
            }
        }
    }

    public void onStop(Fragment fragment) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for (LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onStopCallback) {
                ((LifeCycleCallbacks.onStopCallback) cb).onStop(fragment);
            }
        }
    }

    public void onDestroyView(Fragment fragment) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onDestroyViewCallback) {
                ((LifeCycleCallbacks.onDestroyViewCallback) cb).onDestroyView(fragment);
            }
        }
    }
    public void onDestroy(Fragment fragment) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onDestroyCallback) {
                ((LifeCycleCallbacks.onDestroyCallback) cb).onDestroy(fragment);
            }
        }
    }

    public void onDetach(Fragment fragment) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onDetachCallback) {
                ((LifeCycleCallbacks.onDetachCallback) cb).onDetach(fragment);
            }
        }
    }

    public void onConfigurationChanged(Fragment fragment, Configuration newConfig) {
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onConfigurationChangedCallback) {
                ((LifeCycleCallbacks.onConfigurationChangedCallback) cb).onConfigurationChanged(fragment, newConfig);
            }
        }
    }

    public void onSaveInstanceState(Fragment fragment, Bundle outState) {
        if(mInstanceStateCallbacks.isEmpty()) {
            return;
        }
        for(InstanceStateCallbacks.InstanceStateCallback cb : mInstanceStateCallbacks) {
            if (cb instanceof InstanceStateCallbacks.onSaveInstanceStateCallback) {
                ((InstanceStateCallbacks.onSaveInstanceStateCallback) cb).onSaveInstanceState(fragment, outState);
            }
        }
    }

    public void onViewStateRestored(Fragment fragment, Bundle savedInstanceState) {
        if(mInstanceStateCallbacks.isEmpty()) {
            return;
        }
        for(InstanceStateCallbacks.InstanceStateCallback cb: mInstanceStateCallbacks) {
            if (cb instanceof InstanceStateCallbacks.onViewStateRestoredCallback) {
                ((InstanceStateCallbacks.onViewStateRestoredCallback) cb).onViewStateRestored(fragment, savedInstanceState);
            }
        }
    }

    public void onNewIntent(Fragment fragment, Intent intent) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onNewIntentCallback) {
                ((LifeCycleCallbacks.onNewIntentCallback) cb).onNewIntent(fragment, intent);
            }
        }
    }

    public void onActivityResult(Fragment fragment, int requestCode, int resultCode, Intent data) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onActivityResultCallback) {
                ((LifeCycleCallbacks.onActivityResultCallback) cb).onActivityResultCallback(fragment, requestCode, resultCode, data);
            }
        }
    }

    public void onCreateOptionsMenu(Fragment fragment, Menu menu) {
        if(mMenuCallbacks.isEmpty()) {
            return;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onCreateOptionsMenuCallback) {
                ((MenuCallbacks.onCreateOptionsMenuCallback) cb).onCreateOptionsMenu(fragment, menu);
            }
        }
    }

    public void onPrepareOptionsMenu(Fragment fragment, Menu menu) {
        if(mMenuCallbacks.isEmpty()) {
            return;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onPrepareOptionsMenuCallback) {
                ((MenuCallbacks.onPrepareOptionsMenuCallback) cb).onPrepareOptionsMenu(fragment, menu);
            }
        }
    }

    public boolean onOptionsItemSelected(Fragment fragment, MenuItem item) {
        if(mMenuCallbacks.isEmpty()) {
            return false;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onOptionsItemSelectedCallback) {
                if(((MenuCallbacks.onOptionsItemSelectedCallback) cb).onOptionsItemSelectedActivity(fragment, item)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void onOptionsMenuClosed(Fragment fragment, Menu menu) {
        if(mMenuCallbacks.isEmpty()) {
            return;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onOptionsMenuClosedCallback) {
                ((MenuCallbacks.onOptionsMenuClosedCallback) cb).onOptionsMenuClosed(fragment, menu);
            }
        }
    }

    public void onCreateContextMenu(Fragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(mMenuCallbacks.isEmpty()) {
            return;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onCreateContextMenuCallback) {
                ((MenuCallbacks.onCreateContextMenuCallback) cb).onCreateContextMenu(fragment, menu, v, menuInfo);
            }
        }
    }

    public boolean onContextItemSelected(Fragment fragment, MenuItem item) {
        if(mMenuCallbacks.isEmpty()) {
            return false;
        }
        for(MenuCallbacks.MenuCallback cb : mMenuCallbacks) {
            if(cb instanceof MenuCallbacks.onContextItemSelectedCallback) {
                if(((MenuCallbacks.onContextItemSelectedCallback) cb).onContextItemSelected(fragment, item)) {
                    return true;
                }
            }
        }
        return false;
    }
}
