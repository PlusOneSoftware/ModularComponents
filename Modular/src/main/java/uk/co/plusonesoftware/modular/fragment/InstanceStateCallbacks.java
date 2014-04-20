package uk.co.plusonesoftware.modular.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by James on 18/04/2014.
 */
public class InstanceStateCallbacks {

    public interface InstanceStateCallback extends FragmentModule.FragmentCallback {

    }

    public interface onSaveInstanceStateCallback {
        public void onSaveInstanceState(Fragment fragment, Bundle outState);
    }

    public interface onViewStateRestoredCallback {
        public void onViewStateRestored(Fragment fragment, Bundle savedInstanceState);
    }

    public interface persistInstanceStateCallback extends onSaveInstanceStateCallback, onViewStateRestoredCallback {

    }
}
