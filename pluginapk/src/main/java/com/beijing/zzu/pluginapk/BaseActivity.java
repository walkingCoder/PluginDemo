package com.beijing.zzu.pluginapk;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.beijing.zzu.plugin.PluginInterface;

/**
 * Created by jiayongkai on 2017/9/29.
 */

public class BaseActivity extends FragmentActivity implements PluginInterface{

    protected FragmentActivity thisContext;

    @Override
    public void onCreate(Bundle bundle) {

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        thisContext.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        thisContext.setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        thisContext.setContentView(view, params);
    }

    @NonNull
    @Override
    public LayoutInflater getLayoutInflater() {
        return thisContext.getLayoutInflater();
    }

    @Override
    public Window getWindow() {
        return thisContext.getWindow();
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return thisContext.findViewById(id);
    }

    @Override
    public void attachContext(FragmentActivity context) {
        thisContext=context;
    }

    @Override
    public WindowManager getWindowManager() {
        return thisContext.getWindowManager();
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        return thisContext.getApplicationInfo();
    }

    @Override
    public ClassLoader getClassLoader() {
        return thisContext.getClassLoader();
    }

    @Override
    public void finish() {
        thisContext.finish();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onDestroy() {

    }

    protected void onSaveInstanceState(Bundle outState) {

    }

    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public void onBackPressed() {
        thisContext.onBackPressed();
    }

    public void startActivity(Intent intent) {
        thisContext.startActivity(intent);
    }
}
