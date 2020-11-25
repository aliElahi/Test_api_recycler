package com.test.mytest.model.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@androidx.room.Database(entities = {JokeModel.class},version = 1 ,exportSchema = false)
@TypeConverters(DatabaseTypeConverter.class)
public abstract class Database extends RoomDatabase {

    private static volatile Database INSTANCE;

    public abstract JokeDao getJokeDao();

    private static final ExecutorService service = Executors.
            newFixedThreadPool(4);

    public static synchronized Database getDatabase(Context context) {

        if (INSTANCE == null)
            INSTANCE = Room
                    .databaseBuilder(context.getApplicationContext(), Database.class, "database")
                    .build();

        return INSTANCE;

    }

    public static ExecutorService getService() {
        return service;
    }
}
