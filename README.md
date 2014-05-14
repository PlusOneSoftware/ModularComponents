ModularComponents
=================

Modular Activities, Fragments &amp; Services for Android - for composition over inheritance

Say you have a component which requires hooking into various activity / fragment / service life-cycle callbacks.
Create a module and register it with an Activity / Fragment / Service which has the corresponding `ModuleController` (`ActivityModuleController`, `FragmentModuleController` and `ServiceModuleController`) setup to avoid code duplication.

`ModularActivity`, `ModularFragmentActivity`, `ModularFragment`, `ModularSupportFragment`, `ModularService` and `ModularIntentService` are provided in the library to extend from.

`ModuleController`s also provide a way to register callbacks to custom events.

Use
-----
Add it to your `build.gradle`:

    dependencies {
        repositories {
            mavenCentral()
        }

        compile 'com.github.plusonesoftware:modular:X.Y.Z'
    }

Where X.Y.Z is the latest version, currently `0.3.0`

Example
------
Facebook's `UiLifeCycleHelper` requires you to override `onCreate`, `onResume`, `onActivityResult`, `onSaveInstanceState`, `onPause`, `onStop` and `onDestroy`. If you have multiple Activities that interface with the Facebook SDK, you might be tempted to make a BaseFacebookActivity that does this, and then extend from it for each of the Activities.

But what about `ActionBarDrawerToggle`, which requires you to override `onPostCreate`, `onConfigurationChanged` and `onOptionsItemSelected`.
Again, you might be tempted to make a BaseDrawerToggleActivity, but you can't extend from both.

Instead, extend from `ModularActivity` or `ModularFragmentActivity`, and register an instance of each of these modules:

    public class FacebookUiLifeCycleModule extends UiLifeCycleHelper implements LifeCycleCallbacks.onCreateCallback, LifeCycleCallbacks.onResumeCallback, 
             LifeCycleCallbacks.onActivityResultCallback, InstanceStateCallbacks.onSaveInstanceStateCallback, 
             LifeCycleCallbacks.onPauseCallback, LifeCycleCallbacks.onStopCallback, LifeCycleCallbacks.onDestroyCallback {

        FacebookUiLifeCycleModule(Activity activity, Session.StatusCallback callback) {
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
    
    
Expanding
----
You can extend on top of ModularComponents to expand the events that it can handle.
As an example, we're going to implement a call back for `Activity.onTitleChanged(CharSequence title, int color)` 

Firstly, you'll need to define a new interface:
    
    class ActivityContentChangedCallbacks {
        public interface ActivityContentChangedCallback extends ActivityModuleController.ActivityCallback {
        }

        public interface onTitleChangedCallback extends ActivityContentChangedCallback {
            void onTitleChanged(CharSequence title, int colour);
        }
    }

Since the title changing doesn't really tie into the other activity callbacks group, we've made a new group of interfaces named `ActivityContentChangedCallback`, which is based off the common `ActivityCallback`, which in turn is a `ComponentCallback` (the base interface that `ModuleController` cares about).

Now we need to extend `AcitivtyModuleController` so that it knows how to handle it.

     public class ExtendedActivityModuleController extends ActivityModuleController {
    
        List<ActivityContentChangedCallbacks.ActivityContentChangedCallback> mContentChangedCallbacks 
                 = new ArrayList<ActivityContentChangedCallbacks.ActivityContentChangedCallback>();
    
        @Override
        public void addCallbackListener(ComponentCallback cb) {
            if(cb instanceof ActivityContentChangedCallbacks.ActivityContentChangedCallback) {
                mContentChangedCallbacks.add((ActivityContentChangedCallbacks.ActivityContentChangedCallback) cb);
            }
    
            super.addCallbackListener(cb);
        }
    
        @Override
        public void removeCallbackListener(ComponentCallback cb) {
            mContentChangedCallbacks.remove(cb);
            super.removeCallbackListener(cb);
        }
    
        public void onTitleChanged(CharSequence title, int colour) {
            if(mContentChangedCallbacks.isEmpty()) {
                return;
            }
    
            for(ActivityContentChangedCallbacks.ActivityContentChangedCallback cb : mContentChangedCallbacks) {
                if(cb instanceof ActivityContentChangedCallbacks.onTitleChangedCallback) {
                    ((ActivityContentChangedCallbacks.onTitleChangedCallback) cb).onTitleChanged(title, colour);
                }
            }
        }

The new `List`, overriding `addCallbackListener` and `removeCallbackListener` can be avoided if we reuse one of the existing interface groups.

Lastly, we need to instantiate the new version of the controller, and have the Activity tell it when the title changes. If you're extending from one of the ModularActivities, you can override `createModuleController`

    public class BaseActivity extends ModularActivity {

        @Override
        protected ActivityModuleController createModuleController() {
            return new ExtendedActivityModuleController();
        }
    
        @Override
        protected void onTitleChanged(CharSequence title, int colour) {
            super.onTitleChanged(title, color);
            getModuleController().onTitleChanged(title, colour);
        }
    }
License
----

    Copyright 2014 James R Wilding

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
