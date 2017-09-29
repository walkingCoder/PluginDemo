package com.beijing.zzu.plugin;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by jiayongkai on 2017/9/29.
 */

public interface PluginInterface {

    void onCreate(Bundle bundle);

    void attachContext(FragmentActivity context);

    void onResume();

    void onStart();

    void onPause();

    void onStop();

    void onRestart();

    void onDestroy();

}
