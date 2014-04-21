package uk.co.plusonesoftware.modular.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by James on 18/04/2014.
 */
public class SupportFragmentCallbacks {

    public interface FragmentCallback extends ActivityModule.ActivityCallback {

    }

    public interface onAttachFragmentCallback extends FragmentCallback {
        void onAttachFragment(Fragment fragment);
    }

    public interface onFragmentViewCreatedCallback extends FragmentCallback {
        void onFragmentViewCreated(Fragment fragment, View view, Bundle savedInstanceState);
    }
}
