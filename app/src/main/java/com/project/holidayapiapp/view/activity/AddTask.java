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

public class AddTask extends AppCompatActivity {
    private EditText editTextDate, editTextTime, editTextActivity , editTextDescription;
    public static final int REQUEST_ADD = 100;
    public static final int RESULT_ADD = 110;
    public static final String EXTRA_ADD = "extra_add";
    Button buttonSave;
    private TaskDAO taskDAO;
    String date , time , activity , description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        editTextDate = findViewById(R.id.editTextDate);
        editTextTime = findViewById(R.id.editTextTime);
        editTextActivity = findViewById(R.id.editTextActivity);
        editTextDescription = findViewById(R.id.editTextDescription);
        taskDAO = TaskDatabase.getInstance(this).taskDAO();
        buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
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

                    Task task = new Task(date, time, activity, description);
                    taskDAO.insertData(task);

                    Intent intent = new Intent();
                    intent.putExtra(EXTRA_ADD, task);
                    setResult(RESULT_ADD);
                    finish();
                }
            }
        });
    }
}