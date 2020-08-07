package com.zt.chint_gis.database;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {SecuritycheckBean.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract SecuritycheckDao userDao();

}


