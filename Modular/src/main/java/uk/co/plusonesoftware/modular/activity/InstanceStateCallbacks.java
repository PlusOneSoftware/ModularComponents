package uk.co.plusonesoftware.modular.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by James on 18/04/2014.
 */
public class InstanceStateCallbacks {

    public interface InstanceStateCallback extends ActivityModule.ActivityCallback {

    }

    public interface onSaveInstanceStateCallback {
        public void onSaveInstanceState(Activity activity, Bundle outState);
    }

    public interface onRestoreInstanceStateCallback {
        public void onRestoreInstanceState(Activity activity, Bundle savedInstanceState);
    }

    public interface persistInstanceStateCallback extends onSaveInstanceStateCallback, onRestoreInstanceStateCallback {

    }
}
