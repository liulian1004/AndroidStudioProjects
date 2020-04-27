package com.laioffer.tinnews;

import android.app.Application;

import androidx.room.Room;

import com.ashokvarma.gander.Gander;
import com.ashokvarma.gander.imdb.GanderIMDB;
import com.facebook.stetho.Stetho;
import com.laioffer.tinnews.database.AppDatabase;

public class TinNewsApplication extends Application {

    private static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        Gander.setGanderStorage(GanderIMDB.getInstance());
        Stetho.initializeWithDefaults(this);
        //database name:
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "tin_db").build();
    }
//singleton
    //作用在于application scope
    public static AppDatabase getDatabase() {
        return database;
    }
}
