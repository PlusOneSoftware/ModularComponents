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

import uk.co.plusonesoftware.modular.CustomModuleController;

/**
 * Created by James on 18/04/2014.
 */
public class FragmentModuleController extends CustomModuleController {

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

    public void onActivityCreated(Bundle savedInstanceState) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if (cb instanceof LifeCycleCallbacks.onActivityCreatedCallback) {
                ((LifeCycleCallbacks.onActivityCreatedCallback) cb).onActivityCreated(savedInstanceState);
            }
        }
    }

    public void onAttach(Activity activity) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onAttachCallback) {
                ((LifeCycleCallbacks.onAttachCallback) cb).onAttach(activity);
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

    public void onViewCreated(View view, Bundle savedInstanceState) {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onViewCreatedCallback) {
                ((LifeCycleCallbacks.onViewCreatedCallback) cb).onViewCreated(view, savedInstanceState);
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

    public void onDestroyView() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onDestroyViewCallback) {
                ((LifeCycleCallbacks.onDestroyViewCallback) cb).onDestroyView();
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

    public void onDetach() {
        if(mLifeCycleCallbacks.isEmpty()) {
            return;
        }
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onDetachCallback) {
                ((LifeCycleCallbacks.onDetachCallback) cb).onDetach();
            }
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        for(LifeCycleCallbacks.LifeCycleCallback cb : mLifeCycleCallbacks) {
            if(cb instanceof LifeCycleCallbacks.onConfigurationChangedCallback) {
                ((LifeCycleCallbacks.onConfigurationChangedCallback) cb).onConfigurationChanged(newConfig);
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
            if (cb instanceof InstanceStateCallbacks.onViewStateRestoredCallback) {
                ((InstanceStateCallbacks.onViewStateRestoredCallback) cb).onViewStateRestored(savedInstanceState);
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
                ((LifeCycleCallbacks.onActivityResultCallback) cb).onActivityResultCallback(requestCode, resultCode, data);
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
                if(((MenuCallbacks.onOptionsItemSelectedCallback) cb).onOptionsItemSelectedActivity(item)) {
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
