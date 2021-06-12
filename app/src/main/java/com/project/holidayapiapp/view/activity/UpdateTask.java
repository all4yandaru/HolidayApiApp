package com.project.holidayapiapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project.holidayapiapp.R;
import com.project.holidayapiapp.database.TaskDAO;
import com.project.holidayapiapp.database.TaskDatabase;
import com.project.holidayapiapp.model.Task;

public class UpdateTask extends AppCompatActivity {
    private EditText editTextDate, editTextTime, editTextActivity, editTextDescription;
    Task task;
    Button buttonDelete;
    Button buttonUpdate;
    String date,time,activity,description;
    TaskDAO taskDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_task);
        editTextDate = findViewById(R.id.editTextDate);
        editTextTime = findViewById(R.id.editTextTime);
        editTextActivity = findViewById(R.id.editTextActivity);
        editTextDescription = findViewById(R.id.editTextDescription);
        task = getIntent().getParcelableExtra("task");
        taskDAO = TaskDatabase.getInstance(this).taskDAO();
        editTextDate.setText(task.getDate());
        editTextTime.setText(task.getTime());
        editTextActivity.setText(task.getActivity());
        editTextDescription.setText(task.getDescription());
        buttonUpdate = findViewById(R.id.button_update);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date = editTextDate.getText().toString();
                time = editTextTime.getText().toString();
                activity = editTextActivity.getText().toString();
                description = editTextDescription.getText().toString();

                if (TextUtils.isEmpty(date) || TextUtils.isEmpty(time) || TextUtils.isEmpty(activity)|| TextUtils.isEmpty(description)){
                    Toast.makeText(getBaseContext(), "Lengkapi Data Terlebih Dahulu!", Toast.LENGTH_SHORT).show();
                } else {

                    Log.d("testAdd", date);
                    Log.d("testAdd", time);
                    Log.d("testAdd", activity);
                    Log.d("testAdd", description);

                    Task taskupdate = new Task(task.getId(),date, time, activity, description);
                    taskDAO.updateData(taskupdate);
                    finish();
                }
            }
        });
    }
}