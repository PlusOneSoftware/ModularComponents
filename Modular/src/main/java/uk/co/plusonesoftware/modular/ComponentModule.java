package uk.co.plusonesoftware.modular;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by James on 18/04/2014.
 */
public class ComponentModule {

    public interface ModuleMethodCallback<R, T> {
        R trigger(T args);
    }

    public interface ModuleMethod<IR, IT, TR, TT> extends ModuleMethodCallback<TR, TT> {
        String getMethodName();
        IR init(IT args);
    }

    private Map<String, ModuleMethod> mCallbacks = new HashMap<String, ModuleMethod>();

    public <IR, IT, TR, TT> IR registerMethod(ModuleMethod<IR, IT, TR, TT> callback, IT args) {
        mCallbacks.put(callback.getMethodName(), callback);
        return callback.init(args);
    }

    public void removeMethod(ModuleMethod callback) {
        mCallbacks.remove(callback.getMethodName());
    }

    public <R, T> R trigger(String methodName, T args) {
        if(mCallbacks.containsKey(methodName)) {
            return (R) mCallbacks.get(methodName).trigger(args);
        }

        return null;
    }
}
