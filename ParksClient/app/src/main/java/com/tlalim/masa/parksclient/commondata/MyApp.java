package com.tlalim.masa.parksclient.commondata;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Marina on 27.12.2015.
 */
public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "tmEzAto95Qc7H54QPH8X3CVsUuvqUdDffYaGEG3H",
                "qFNXYH3lruZS7jFobbIWiqPPpD1glvCBvACNfkIS");
    }
}
