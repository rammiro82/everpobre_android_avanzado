package io.keepcoding.rgs.everpobre;

import android.app.Application;
import android.util.Log;

import io.keepcoding.rgs.everpobre.model.db.DBConstants;
import io.keepcoding.rgs.everpobre.model.db.DBHelper;

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

        //inicalizamos la BD
        DBHelper.configure(DBConstants.DBNAME, getApplicationContext());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
