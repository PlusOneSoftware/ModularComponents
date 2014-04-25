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
package uk.co.plusonesoftware.modular.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import uk.co.plusonesoftware.modular.ModuleController;

/**
 * Created by James on 18/04/2014.
 */
public class ModularFragmentActivity extends FragmentActivity implements SupportFragmentCallbacks.onFragmentViewCreatedCallback {

    private ActivityModuleController mModule = new ActivityModuleController();

    public void addCallbackListener(ModuleController.ComponentCallback callback) {
        mModule.addCallbackListener(callback);
    }

    public void addCallbackListener(String method, ModuleController.MethodCallback callback) {
        mModule.addCallbackListener(method, callback);
    }

    public void removeCallbackListener(ActivityModuleController.ActivityCallback callback) {
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

    public ActivityModuleController getModuleController() {
        return mModule;
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        mModule.onAttachedToWindow();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mModule.onCreate(savedInstanceState);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mModule.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mModule.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mModule.onResume();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mModule.onPostResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mModule.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mModule.onStop();
    }

    @Override
    public void finish() {
        mModule.onFinish();
        super.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mModule.onDestroy();
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mModule.onDetachedFromWindow();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mModule.onRestart();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mModule.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mModule.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mModule.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mModule.onNewIntent(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mModule.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mModule.onBackPressed();
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        mModule.onUserInteraction();
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        mModule.onAttachFragment(fragment);
    }

    @Override
    public void onFragmentViewCreated(Fragment fragment, View view, Bundle savedInstanceState) {
        mModule.onFragmentViewCreated(fragment, view, savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean sup = super.onCreateOptionsMenu(menu);
        boolean mod = mModule.onCreateOptionsMenu(menu);
        return sup || mod;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean sup = super.onPrepareOptionsMenu(menu);
        boolean mod = mModule.onPrepareOptionsMenu(menu);
        return sup || mod;
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

    @Override
    public void onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
        mModule.onContextMenuClosed(menu);
    }
}
