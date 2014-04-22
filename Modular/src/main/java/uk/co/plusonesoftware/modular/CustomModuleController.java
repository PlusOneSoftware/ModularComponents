package uk.co.plusonesoftware.modular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.plusonesoftware.modular.fragment.InstanceStateCallbacks;
import uk.co.plusonesoftware.modular.fragment.LifeCycleCallbacks;
import uk.co.plusonesoftware.modular.fragment.MenuCallbacks;

/**
 * Created by James on 18/04/2014.
 */
public abstract class CustomModuleController {

    public interface ComponentCallback {
        // For known API methods
    }

    public interface ModuleMethodCallback<T> {
        void trigger(T args);
    }

    private Map<String, List<ModuleMethodCallback>> mMethods = new HashMap<String, List<ModuleMethodCallback>>();

    public abstract void addCallbackListener(ComponentCallback cb);

    public abstract void removeCallbackListener(ComponentCallback cb);

    /**
     * Register a method. A registered method can have callbacks registered to listen for it, which will be called if the method is triggered
     * @param method method to add
     */
    public void registerMethod(String method) {
        if(!mMethods.containsKey(method)) {
            mMethods.put(method, new ArrayList<ModuleMethodCallback>());
        }
    }

    /**
     * unregister a method (removing all callbacks)
     * @param method method to remove
     */
    public void removeMethod(String method) {
        mMethods.remove(method);
    }

    /**
     * Trigger registered callbacks for a given method
     * @param method name of the method, registered using registerMethod
     * @param args input to pass to the callbacks
     * @param <T> type of input
     * @return true if at least one callback listener was triggered
     */

    public <T> boolean trigger(String method, T args) {
        if(mMethods.containsKey(method)) {
            final List<ModuleMethodCallback> callbacks = mMethods.get(method);
            for(ModuleMethodCallback callback : callbacks) {
                callback.trigger(args);
            }

            return !callbacks.isEmpty();
        }

        return false;
    }

    /**
     * Add a listener to a specific method, registering the method if it hasn't been before
     * @param method method to add the callback to
     * @param callback the callback which will be called if the method is triggered
     */
    public void addCallbackListener(String method, ModuleMethodCallback callback) {
        if(!mMethods.containsKey(method)) {
            registerMethod(method);
        }
        final List<ModuleMethodCallback> callbacks = mMethods.get(method);
        callbacks.add(callback);
    }

    /**
     * Remove a listener from a specific method
     * @param method method to remove callback from
     * @param callback the callback to remove
     * @return true if callback was removed from the registered method
     */
    public boolean removeCallbackListener(String method, ModuleMethodCallback callback) {
        if(mMethods.containsKey(method)) {
            final List<ModuleMethodCallback> callbacks = mMethods.get(method);
            return callbacks.remove(callback);
        }

        return false;
    }
}
