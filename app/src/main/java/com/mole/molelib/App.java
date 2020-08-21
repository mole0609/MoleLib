package com.mole.molelib;

import android.app.Application;

import com.mole.molelibrary.LibManager;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new LibManager().init();
    }
}
