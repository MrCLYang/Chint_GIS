package com.zt.chint_gis;

import android.app.Application;

import com.zt.chint_gis.database.AppDatabase;

import androidx.room.Room;
import androidx.room.migration.Migration;


public class AppApplication extends Application {

    private AppDatabase mAppDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "usercheck.db")
                .allowMainThreadQueries()
                .build();
    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }


}