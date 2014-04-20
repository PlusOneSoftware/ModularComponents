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
import uk.co.plusonesoftware.modular.activity.FragmentCallbacks;

/**
 * Created by James on 18/04/2014.
 */
public class ModularFragment extends Fragment {

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
        mModule.onActivityCreated(this, savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mModule.onAttach(this, activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModule.onCreate(this, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mModule.onViewCreated(this, view, savedInstanceState);
        if(getActivity() instanceof FragmentCallbacks.onFragmentViewCreatedCallback) {
            FragmentCallbacks.onFragmentViewCreatedCallback cb = (FragmentCallbacks.onFragmentViewCreatedCallback) getActivity();
            cb.onFragmentViewCreated(getActivity(), this, view, savedInstanceState);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mModule.onStart(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mModule.onResume(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mModule.onPause(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        mModule.onStop(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mModule.onDestroyView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mModule.onDestroy(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mModule.onDetach(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mModule.onSaveInstanceState(this, outState);
    }

    @TargetApi(17)
    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        mModule.onViewStateRestored(this, savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mModule.onConfigurationChanged(this, newConfig);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mModule.onActivityResult(this, requestCode, resultCode, data);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        mModule.onCreateOptionsMenu(this, menu);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        mModule.onPrepareOptionsMenu(this, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mModule.onOptionsItemSelected(this, item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        mModule.onOptionsMenuClosed(this, menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        mModule.onCreateContextMenu(this, menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(mModule.onContextItemSelected(this, item)) {
            return true;
        }
        return super.onContextItemSelected(item);
    }
}
