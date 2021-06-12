package com.project.holidayapiapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.project.holidayapiapp.model.Task;

import java.util.List;

@Dao
public interface TaskDAO {
    @Query("SELECT * FROM task")
    List<Task> getAllData();

    @Insert
    void insertData(Task task);

    @Update
    void updateData(Task task);

    @Delete
    void deleteData(Task task);
}