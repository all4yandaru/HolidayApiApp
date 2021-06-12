package com.project.holidayapiapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.project.holidayapiapp.model.Task;

@Database(entities = Task.class, version = 1)
public abstract class TaskDatabase extends RoomDatabase {
    private static final String DB_NAME = "db_task";
    private static TaskDatabase instance;

    public abstract TaskDAO taskDAO();

    public static TaskDatabase getInstance(Context context) {
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), TaskDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}