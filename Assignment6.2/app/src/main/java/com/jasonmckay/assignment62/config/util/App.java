package com.jasonmckay.assignment62.config.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by JasonMckay on 19-Apr-16.
 */
public class App extends Application
{
    private static Context context;
    private static App singleton;

    @Override
    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
        singleton = this;
    }

    public static Context getAppContext()
    {
        return App.context;
    }
}
