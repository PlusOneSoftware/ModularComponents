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
package uk.co.plusonesoftware.modular;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by James on 18/04/2014.
 */
public class MenuCallbacks {

    public interface MenuCallback extends ModuleController.ComponentCallback  {

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
}
