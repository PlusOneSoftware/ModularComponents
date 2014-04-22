package uk.co.plusonesoftware.modular.activity;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by James on 18/04/2014.
 */
public class MenuCallbacks {

    public interface MenuCallback extends ActivityModuleController.ActivityCallback {

    }

    public interface onCreateOptionsMenuCallback extends MenuCallback {
        boolean onCreateOptionsMenu(Menu menu);
    }

    public interface onPrepareOptionsMenuCallback extends MenuCallback {
        boolean onPrepareOptionsMenu(Menu menu);
    }

    public interface onOptionsItemSelectedCallback extends MenuCallback {
        boolean onOptionsItemSelected(MenuItem item);
    }

    public interface onOptionsMenuClosedCallback extends MenuCallback {
        void onOptionsMenuClosed(Menu menu);
    }

    public interface onCreateContextMenuCallback extends MenuCallback {
        void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo);
    }

    public interface onContextItemSelectedCallback extends MenuCallback {
        boolean onContextItemSelected(MenuItem item);
    }

    public interface onContextMenuClosedCallback extends MenuCallback {
        void onContextMenuClosed(Menu menu);
    }
}
