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

public class AddTask extends AppCompatActivity {
    private EditText editTextTime, editTextActivity , editTextDescription;
    private TextView textViewDate;
    public static final int REQUEST_ADD = 100;
    public static final int RESULT_ADD = 110;
    public static final String EXTRA_ADD = "extra_add";
    Button buttonSave;
    private TaskDAO taskDAO;
    String date , time , activity , description;

    TextView tvtgl;
    Calendar c;
    DatePickerDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        textViewDate = findViewById(R.id.textViewDate);
        editTextTime = findViewById(R.id.editTextTime);
        editTextActivity = findViewById(R.id.editTextActivity);
        editTextDescription = findViewById(R.id.editTextDescription);
        taskDAO = TaskDatabase.getInstance(this).taskDAO();
        buttonSave = findViewById(R.id.button_save);

        textViewDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(AddTask.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        textViewDate.setText(mDay + "/" + (mMonth+1) + "/" + (mYear + 121));
                    }
                }, day, month, year);
                dpd.show();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
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