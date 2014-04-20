package uk.co.plusonesoftware.modular.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by James on 18/04/2014.
 */
public class FragmentCallbacks {

    public interface FragmentCallback extends ActivityModule.ActivityCallback {

    }

    public interface onAttachFragmentCallback extends FragmentCallback {
        void onAttachFragment(Activity activity, Fragment fragment);
    }

    public interface onFragmentViewCreatedCallback extends FragmentCallback {
        void onFragmentViewCreated(Activity activity, Fragment fragment, View view, Bundle savedInstanceState);
    }
}
