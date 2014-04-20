package uk.co.plusonesoftware.modular.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import uk.co.plusonesoftware.modular.ComponentModule;

/**
 * Created by James on 18/04/2014.
 */
public class ModularFragmentActivity extends FragmentActivity implements FragmentCallbacks.onFragmentViewCreatedCallback {

    private ActivityModule mModule = new ActivityModule();

    public void addCallbackListener(ActivityModule.ActivityCallback callback) {
        mModule.addCallbackListener(callback);
    }

    public void removeCallbackListener(ActivityModule.ActivityCallback callback) {
        mModule.removeCallbackListener(callback);
    }

    public <IR, IT, TR, TT> IR registerMethod(ComponentModule.ModuleMethod<IR, IT, TR, TT> callback, IT args) {
        return mModule.registerMethod(callback, args);
    }

    public void removeMethod(ComponentModule.ModuleMethod callback) {
        mModule.removeMethod(callback);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        mModule.onAttachedToWindow(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModule.onCreate(this, savedInstanceState);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mModule.onPostCreate(this, savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mModule.onStart(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mModule.onResume(this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mModule.onPostResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mModule.onPause(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mModule.onStop(this);
    }

    @Override
    public void finish() {
        mModule.onFinish(this);
        super.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mModule.onDestroy(this);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mModule.onDetachedFromWindow(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mModule.onRestart(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mModule.onSaveInstanceState(this, outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mModule.onRestoreInstanceState(this, savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mModule.onConfigurationChanged(this, newConfig);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mModule.onNewIntent(this, intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mModule.onActivityResult(this, requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mModule.onBackPressed(this);
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        mModule.onUserInteraction(this);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        mModule.onAttachFragment(this, fragment);
    }

    @Override
    public void onFragmentViewCreated(Activity activity, Fragment fragment, View view, Bundle savedInstanceState) {
        mModule.onFragmentViewCreated(this, fragment, view, savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean sup = super.onCreateOptionsMenu(menu);
        boolean mod = mModule.onCreateOptionsMenu(this, menu);
        return sup || mod;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean sup = super.onPrepareOptionsMenu(menu);
        boolean mod = mModule.onPrepareOptionsMenu(this, menu);
        return sup || mod;
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

    @Override
    public void onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
        mModule.onContextMenuClosed(this, menu);
    }
}
