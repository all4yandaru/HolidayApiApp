package com.project.holidayapiapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "task")
public class Task implements Parcelable {

    @PrimaryKey(autoGenerate = true) // auto increment
    @ColumnInfo(name = "Id") // nama kolom
    private int id;

    @ColumnInfo(name = "Date")
    private String date;

    @ColumnInfo(name = "Time")
    private String time;

    @ColumnInfo(name = "Activity")
    private String activity;

    @ColumnInfo(name = "Description")
    private String description;

    @Ignore
    public Task(String date, String time, String activity, String description) {
        this.date = date;
        this.time = time;
        this.activity = activity;
        this.description = description;
    }

    public Task(int id , String date, String time, String activity, String description) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.activity = activity;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected Task(Parcel in) {
        id = in.readInt();
        date = in.readString();
        time = in.readString();
        activity = in.readString();
        description = in.readString();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(date);
        parcel.writeString(time);
        parcel.writeString(activity);
        parcel.writeString(description);
    }
}