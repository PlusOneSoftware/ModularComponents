package uk.co.plusonesoftware.modular.activity;

/**
 * Created by James on 18/04/2014.
 */
public class UserInteractionCallbacks {

    public interface UserInteractionCallback extends ActivityModule.ActivityCallback {

    }

    public interface onBackPressedCallback extends UserInteractionCallback {
        void onBackPressed();
    }

    public interface onUserInteractionCallback extends UserInteractionCallback {
        void onUserInteraction();
    }
}
