package uk.co.plusonesoftware.modular.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

/**
 * Created by James on 18/04/2014.
 */
public class FragmentCallbacks {

    public interface FragmentCallback extends ActivityModuleController.ActivityCallback {

    }

    public interface onAttachFragmentCallback extends FragmentCallback {
        void onAttachFragment(Fragment fragment);
    }

    public interface onFragmentViewCreatedCallback extends FragmentCallback {
        void onFragmentViewCreated(Fragment fragment, View view, Bundle savedInstanceState);
    }
}
