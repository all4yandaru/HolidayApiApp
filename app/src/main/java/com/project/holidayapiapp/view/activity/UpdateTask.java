package com.project.holidayapiapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.project.holidayapiapp.R;
import com.project.holidayapiapp.database.TaskDAO;
import com.project.holidayapiapp.database.TaskDatabase;
import com.project.holidayapiapp.model.Task;

import java.util.Calendar;

public class UpdateTask extends AppCompatActivity {
    private EditText editTextTime, editTextActivity, editTextDescription;
    private TextView textViewDate;
    Task task;
    Button buttonDelete;
    Button buttonUpdate;
    String date,time,activity,description;
    TaskDAO taskDAO;

    TextView tvtgl;
    Calendar c;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_task);
        textViewDate = findViewById(R.id.textViewDate);
        editTextTime = findViewById(R.id.editTextTime);
        editTextActivity = findViewById(R.id.editTextActivity);
        editTextDescription = findViewById(R.id.editTextDescription);
        task = getIntent().getParcelableExtra("task");
        taskDAO = TaskDatabase.getInstance(this).taskDAO();
        textViewDate.setText(task.getDate());
        editTextTime.setText(task.getTime());
        editTextActivity.setText(task.getActivity());
        editTextDescription.setText(task.getDescription());
        buttonDelete = findViewById(R.id.button_delete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taskDAO.deleteData(task);
                finish();
            }
        });

        textViewDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(UpdateTask.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        textViewDate.setText(mDay + "/" + (mMonth+1) + "/" + (mYear + 121));
                    }
                }, day, month, year);
                dpd.show();
            }
        });

        buttonUpdate = findViewById(R.id.button_update);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                date = textViewDate.getText().toString();
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
                    Toast.makeText(getBaseContext(), "Update data berhasil, silakan refresh page!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}