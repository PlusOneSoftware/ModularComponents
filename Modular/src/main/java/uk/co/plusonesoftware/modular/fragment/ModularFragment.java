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
package uk.co.plusonesoftware.modular.fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import uk.co.plusonesoftware.modular.ModuleController;
import uk.co.plusonesoftware.modular.activity.FragmentCallbacks;

/**
 * Created by James on 18/04/2014.
 */
@TargetApi(11)
public class ModularFragment extends Fragment {

    private FragmentModuleController mModule = createModuleController();

    protected FragmentModuleController createModuleController() {
        return new FragmentModuleController();
    }

    public void addCallbackListener(ModuleController.ComponentCallback callback) {
        mModule.addCallbackListener(callback);
    }

    public void addCallbackListener(String method, ModuleController.MethodCallback callback) {
        mModule.addCallbackListener(method, callback);
    }

    public void removeCallbackListener(ModuleController.ComponentCallback callback) {
        mModule.removeCallbackListener(callback);
    }

    public boolean removeCallbackListener(String method, ModuleController.MethodCallback callback) {
        return mModule.removeCallbackListener(method, callback);
    }

    public void registerMethod(String method) {
        mModule.registerMethod(method);
    }

    public void removeMethod(String method) {
        mModule.removeMethod(method);
    }

    public FragmentModuleController getModuleController() {
        return mModule;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mModule.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mModule.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModule.onCreate(savedInstanceState);
    }

    @TargetApi(13)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        if(Build.VERSION.SDK_INT >= 13) {
            super.onViewCreated(view, savedInstanceState);
        }
        mModule.onViewCreated(view, savedInstanceState);
        if(getActivity() instanceof FragmentCallbacks.onFragmentViewCreatedCallback) {
            FragmentCallbacks.onFragmentViewCreatedCallback cb = (FragmentCallbacks.onFragmentViewCreatedCallback) getActivity();
            cb.onFragmentViewCreated(this, view, savedInstanceState);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mModule.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mModule.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mModule.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mModule.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mModule.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mModule.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mModule.onDetach();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mModule.onSaveInstanceState(outState);
    }

    @TargetApi(17)
    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        mModule.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mModule.onConfigurationChanged(newConfig);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mModule.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        mModule.onCreateOptionsMenu(menu);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mModule.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mModule.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        mModule.onOptionsMenuClosed(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        mModule.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(mModule.onContextItemSelected(item)) {
            return true;
        }
        return super.onContextItemSelected(item);
    }
}
