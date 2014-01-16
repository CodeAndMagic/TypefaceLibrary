package org.codeandmagic.android;

import android.app.Application;

/**
 * Created by evelina on 16/01/2014.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceManager.setTextStyleExtractor(RobotoTextStyleExtractor.getInstance());
    }
}
