package com.beijing.zzu.plugindemo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * Created by jiayongkai on 2017/9/29.
 */

public class PluginManager {
    public static PluginManager instance;

    private DexClassLoader pluginClassLoader;
    private Resources pluginResource;
    private Context context;
    private PackageInfo pluginPackageAricheInfo;

    private PluginManager() {
    }

    public static PluginManager getInstance() {
        if (instance == null) {
            synchronized (PluginManager.class) {
                if (instance == null) {
                    instance = new PluginManager();
                }
            }
        }
        return instance;
    }

    public void setContext(Context context) {
        this.context = context.getApplicationContext();
    }

    public void loadApk(String dexPath) {
        pluginClassLoader = new DexClassLoader(dexPath, context.getDir("dex", Context.MODE_PRIVATE).getAbsolutePath(), null, context.getClassLoader());

        pluginPackageAricheInfo = context.getPackageManager().getPackageArchiveInfo(dexPath, PackageManager.GET_ACTIVITIES);

        AssetManager assets = null;
        try {
            assets = AssetManager.class.newInstance();
            Method addAssetPath = AssetManager.class.getMethod("addAssetPath", String.class);
            addAssetPath.invoke(assets, dexPath);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        pluginResource = new Resources(assets, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
    }

    public Resources getPluginResource() {
        return pluginResource;
    }

    public DexClassLoader getPluginClassLoader() {
        return pluginClassLoader;
    }


    public PackageInfo getPluginPackageAricheInfo() {
        return pluginPackageAricheInfo;
    }
}
