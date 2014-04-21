package uk.co.plusonesoftware.modular.fragment;

import android.os.Bundle;

/**
 * Created by James on 18/04/2014.
 */
public class InstanceStateCallbacks {

    public interface InstanceStateCallback extends FragmentModule.FragmentCallback {

    }

    public interface onSaveInstanceStateCallback {
        public void onSaveInstanceState(Bundle outState);
    }

    public interface onViewStateRestoredCallback {
        public void onViewStateRestored(Bundle savedInstanceState);
    }

    public interface persistInstanceStateCallback extends onSaveInstanceStateCallback, onViewStateRestoredCallback {

    }
}
