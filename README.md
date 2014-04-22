ModularComponents
=================

Modular Activities &amp; Fragments for Android - for composition over inheritance

Say you have a component which requires hooking into various activity / fragment life-cycle callbacks.
Create a module and register it with an Activity / Fragment which has the corresponding `CustomModuleController` (`ActivityModuleController` and `FragmentModuleController`) setup to avoid code duplication.

`ModularActivity`, `ModularFragmentActivity`, `ModularFragment` and `ModularSupportFragment` are provided in the library to extend from.

`CustomModuleController` (which the Activity and Fragment controllers extends from) also provides a way to register callbacks to custom events.

Example
------
Facebook's `UiLifeCycleHelper` requires you to override `onCreate`, `onResume`, `onActivityResult`, `onSaveInstanceState`, `onPause`, `onStop` and `onDestroy`. If you have multiple Activities that interface with the Facebook SDK, you might be tempted to make a BaseFacebookActivity that does this, and then extend from it for each of the Activities.

But what about `ActionBarDrawerToggle`, which requires you to override `onPostCreate`, `onConfigurationChanged` and `onOptionsItemSelected`.
Again, you might be tempted to make a BaseDrawerToggleActivity, but you can't extend from both.

Instead, extend from `ModularActivity` or `ModularFragmentActivity`, and register an instance of each of these modules:

    public class FacebookUiLifecycleModule extends UiLifeCycleHelper implements LifeCycleCallbacks.onCreateCallback, LifeCycleCallbacks.onResumeCallback, 
             LifeCycleCallbacks.onActivityResultCallback, InstanceStateCallbacks.onSaveInstanceStateCallback, 
             LifeCycleCallbacks.onPauseCallback, LifeCycleCallbacks.onStopCallback, LifeCycleCallbacks.onDestroyCallback {

        FacebookUiLifecycle(Activity activity, Session.StatusCallback callback) {
            super(activity, callback);
        }

        //// The callback methods have the same signature as what UiLifeCycleHelper already declares, so we don't need to redefine them
    }

and

    public class DrawerToggleModule extends ActionBarDrawerToggle implements LifeCycleCallbacks.onPostCreateCallback, LifeCycleCallbacks.onConfigurationChangedCallback, MenuCallbacks.onOptionsItemSelectedCallback {
    
        public DrawerToggleModule(Activity activity, DrawerLayout drawer, int icon, int open, int close) {
            super(activity, drawer, icon, open, close);
            drawer.setDrawerListener(this);
        }
    
        //// ActionBarDrawerToggler doesn't have a onPostCreate method, so we override it to provide the correct implementation
        @Override
        public void onPostCreate(Bundle savedInstanceState) {
            syncState();
        }
    }


To use:

    public class LoginActivity extends ModularFragmentActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            ...
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
            addCallbackListener(new FacebookUiLifecycle(this, null));
            addCallbackListener(new DrawerToggle(this, drawer, R.id.ic_icon, R.string.open, R.string.close);
            ...
        }
    ...
    }


Custom Method Example
----

In the example above, our `DrawerToggleModule` registers itself as the `DrawerListener` to the `DrawerLayout`. Since you might want to provide your own `DrawerListener` you could just call through to the instance of the `DrawerToggleModule` for each of `DrawerListener`'s 4 methods: `onDrawerSlide(View drawer, float slideOffset)`, `onDrawerOpened(View drawer)`, `onDrawerClosed(View drawer)` and `onDrawerStateChanged(View drawer, int state)`

Using Custom Method Callbacks, you could instead use this class:

    public class DrawerListenerModule implements DrawerLayout.DrawerListener {

        public static final String onDrawerSlide = "onDrawerSlide";
        public static final String onDrawerOpened = "onDrawerOpened";
        public static final String onDrawerClosed = "onDrawerClosed";
        public static final String onDrawerStateChanged = "onDrawerStateChanged";
    
        private CustomModuleController mController;
    
        DrawerListenerModule(CustomModuleController controller, DrawerLayout drawer) {
            mController = controller;
            mController.registerMethod(onDrawerSlide);
            mController.registerMethod(onDrawerOpened);
            mController.registerMethod(onDrawerClosed);
            mController.registerMethod(onDrawerStateChanged);
            drawer.setDrawerListener(this);
        }
    
        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            // Creating a Pair here isn't a great idea (this will be called lots of times).
            mController.trigger(onDrawerSlide, Pair.create(drawerView, slideOffset));
        }
    
        @Override
        public void onDrawerOpened(View drawerView) {
            mController.trigger(onDrawerOpened, drawerView);
        }
    
        @Override
        public void onDrawerClosed(View drawerView) {
            mController.trigger(onDrawerClosed, drawerView);
        }
    
        @Override
        public void onDrawerStateChanged(int newState) {
            mController.trigger(onDrawerStateChanged, newState);
        }
    }

and a modified version of the above DrawerToggleModule:

    public class DrawerToggleModule extends ActionBarDrawerToggle implements LifeCycleCallbacks.onPostCreateCallback, LifeCycleCallbacks.onConfigurationChangedCallback, MenuCallbacks.onOptionsItemSelectedCallback {

        public DrawerToggleModule(ModularActivity activity, DrawerLayout drawer, int icon, int open, int close) {
            super(activity, drawer, icon, open, close);
            activity.addCallbackListener(DrawerListenerModule.onDrawerSlide, new CustomModuleController.ModuleMethodCallback<Pair<View, Float>>() {
                @Override
                public void trigger(Pair<View, Float> args) {
                    onDrawerSlide(args.first, args.second);
                }
            });
            activity.addCallbackListener(DrawerListenerModule.onDrawerOpened, new CustomModuleController.ModuleMethodCallback<View>() {
                @Override
                public void trigger(View args) {
                    onDrawerOpened(args);
                }
            });
            activity.addCallbackListener(DrawerListenerModule.onDrawerClosed, new CustomModuleController.ModuleMethodCallback<View>() {
                @Override
                public void trigger(View args) {
                    onDrawerClosed(args);
                }
            });
            activity.addCallbackListener(DrawerListenerModule.onDrawerStateChanged, new CustomModuleController.ModuleMethodCallback<Integer>() {
                @Override
                public void trigger(Integer args) {
                    onDrawerStateChanged(args);
                }
            });
        }

        //// ActionBarDrawerToggler doesn't have a onPostCreate method, so we override it to provide the correct implementation
        @Override
        public void onPostCreate(Bundle savedInstanceState) {
            syncState();
        }
    }

Then in your activity, you can `addCallbackListener`s (multiple callbacks for the same methods) to the methods you're interested in:

    public class LoginActivity extends ModularFragmentActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            ...
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
            addCallbackListener(new FacebookUiLifecycle());
            // setup the DrawerListener and register the methods, this has to be created before the DrawerToggle so that it's callbacks are registered to the methods
            DrawerListenerModule module = new DrawerListenerModule(getModuleController(), drawer);
            addCallbackListener(new DrawerToggle(this, drawer, R.id.ic_icon, R.string.open, R.string.close);
            addCallbackListener(DrawerListenerModule.onDrawerSlide, new CustomModuleController.ModuleMethodCallback<Pair<View, Float>>() {
                @Override
                public void trigger(Pair<View, Float> args) {
                    // do something cool as the menu slides
                }
            });            
            ...
        }
    ...
    }
