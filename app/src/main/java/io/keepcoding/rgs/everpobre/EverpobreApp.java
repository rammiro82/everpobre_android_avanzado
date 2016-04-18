package io.keepcoding.rgs.everpobre;

import android.app.Application;
import android.util.Log;

/**
 * Created by RamiroGarcia on 18/4/16.
 */
public class EverpobreApp extends Application {
    public static final String TAG = EverpobreApp.class.getName();

    // like AppDelegate from iOS


    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "Hello world!!!");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
