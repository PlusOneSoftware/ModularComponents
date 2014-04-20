package uk.co.plusonesoftware.modular.fragment;

import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by James on 18/04/2014.
 */
public class MenuCallbacks {

    public interface MenuCallback extends FragmentModule.FragmentCallback {

    }

    public interface onCreateOptionsMenuCallback extends MenuCallback {
        void onCreateOptionsMenu(Fragment fragment, Menu menu);
    }

    public interface onPrepareOptionsMenuCallback extends MenuCallback {
        boolean onPrepareOptionsMenu(Fragment fragment, Menu menu);
    }

    public interface onOptionsItemSelectedCallback extends MenuCallback {
        boolean onOptionsItemSelectedActivity(Fragment fragment, MenuItem item);
    }

    public interface onOptionsMenuClosedCallback extends MenuCallback {
        void onOptionsMenuClosed(Fragment fragment, Menu menu);
    }

    public interface onCreateContextMenuCallback extends MenuCallback {
        void onCreateContextMenu(Fragment fragment, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);
    }

    public interface onContextItemSelectedCallback extends MenuCallback {
        boolean onContextItemSelected(Fragment fragment, MenuItem item);
    }
}
