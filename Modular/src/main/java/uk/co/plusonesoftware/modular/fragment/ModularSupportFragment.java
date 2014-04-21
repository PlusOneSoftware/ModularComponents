package uk.co.plusonesoftware.modular.fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import uk.co.plusonesoftware.modular.ComponentModule;
import uk.co.plusonesoftware.modular.activity.SupportFragmentCallbacks;

/**
 * Created by James on 18/04/2014.
 */
public class ModularSupportFragment extends Fragment {

    private FragmentModule mModule = new FragmentModule();

    public void addCallbackListener(FragmentModule.FragmentCallback callback) {
        mModule.addCallbackListener(callback);
    }

    public void removeCallbackListener(FragmentModule.FragmentCallback callback) {
        mModule.removeCallbackListener(callback);
    }

    public <IR, IT, TR, TT> IR registerMethod(ComponentModule.ModuleMethod<IR, IT, TR, TT> callback, IT args) {
        return mModule.registerMethod(callback, args);
    }

    public void removeMethod(ComponentModule.ModuleMethod callback) {
        mModule.removeMethod(callback);
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

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mModule.onViewCreated(view, savedInstanceState);
        if(getActivity() instanceof SupportFragmentCallbacks.onFragmentViewCreatedCallback) {
            SupportFragmentCallbacks.onFragmentViewCreatedCallback cb = (SupportFragmentCallbacks.onFragmentViewCreatedCallback) getActivity();
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
