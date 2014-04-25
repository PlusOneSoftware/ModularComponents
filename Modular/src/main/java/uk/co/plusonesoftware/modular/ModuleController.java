/**
 * Copyright 2014 James R Wilding
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.plusonesoftware.modular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by James on 18/04/2014.
 */
public abstract class ModuleController {

    public interface ComponentCallback {
        // For known API methods
    }

    public interface MethodCallback<T> {
        void trigger(T args);
    }

    private Map<String, List<MethodCallback>> mMethods = new HashMap<String, List<MethodCallback>>();

    public abstract void addCallbackListener(ComponentCallback cb);

    public abstract void removeCallbackListener(ComponentCallback cb);

    /**
     * Register a method. A registered method can have callbacks registered to listen for it, which will be called if the method is triggered
     * @param method method to add
     */
    public void registerMethod(String method) {
        if(!mMethods.containsKey(method)) {
            mMethods.put(method, new ArrayList<MethodCallback>());
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
            final List<MethodCallback> callbacks = mMethods.get(method);
            for(MethodCallback callback : callbacks) {
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
    public void addCallbackListener(String method, MethodCallback callback) {
        if(!mMethods.containsKey(method)) {
            registerMethod(method);
        }
        final List<MethodCallback> callbacks = mMethods.get(method);
        callbacks.add(callback);
    }

    /**
     * Remove a listener from a specific method
     * @param method method to remove callback from
     * @param callback the callback to remove
     * @return true if callback was removed from the registered method
     */
    public boolean removeCallbackListener(String method, MethodCallback callback) {
        if(mMethods.containsKey(method)) {
            final List<MethodCallback> callbacks = mMethods.get(method);
            return callbacks.remove(callback);
        }

        return false;
    }
}
