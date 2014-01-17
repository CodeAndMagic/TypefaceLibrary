package org.codeandmagic.android;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by evelina on 16/01/2014.
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceManager.addTextStyleExtractor(RobotoTextStyleExtractor.getInstance());
        TypefaceManager.addTextStyleExtractor(SourceSansProTextStyleExtractor.getInstance());
    }

    public static int getThemeId(Context context) {
        try {
            String packageName = MyApp.class.getPackage().getName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, PackageManager.GET_META_DATA);
            return packageInfo.applicationInfo.theme;
        } catch (Exception e) {
            return 0;
        }
    }
}
