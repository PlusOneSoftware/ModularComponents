package uk.co.plusonesoftware.modular.activity;

import android.app.Activity;

/**
 * Created by James on 18/04/2014.
 */
public class UserInteractionCallbacks {

    public interface UserInteractionCallback extends ActivityModule.ActivityCallback {

    }

    public interface onBackPressedCallback extends UserInteractionCallback {
        void onBackPressed(Activity activity);
    }

    public interface onUserInteractionCallback extends UserInteractionCallback {
        void onUserInteraction(Activity activity);
    }
}
