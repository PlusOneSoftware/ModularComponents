package uk.co.plusonesoftware.modular.activity;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by James on 18/04/2014.
 */
public class MenuCallbacks {

    public interface MenuCallback extends ActivityModule.ActivityCallback {

    }

    public interface onCreateOptionsMenuCallback extends MenuCallback {
        boolean onCreateOptionsMenu(Activity activity, Menu menu);
    }

    public interface onPrepareOptionsMenuCallback extends MenuCallback {
        boolean onPrepareOptionsMenu(Activity activity, Menu menu);
    }

    public interface onOptionsItemSelectedCallback extends MenuCallback {
        boolean onOptionsItemSelectedActivity(Activity activity, MenuItem item);
    }

    public interface onOptionsMenuClosedCallback extends MenuCallback {
        void onOptionsMenuClosed(Activity activity, Menu menu);
    }

    public interface onCreateContextMenuCallback extends MenuCallback {
        void onCreateContextMenu(Activity activity, ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);
    }

    public interface onContextItemSelectedCallback extends MenuCallback {
        boolean onContextItemSelected(Activity activity, MenuItem item);
    }

    public interface onContextMenuClosedCallback extends MenuCallback {
        void onContextMenuClosed(Activity activity, Menu menu);
    }
}
