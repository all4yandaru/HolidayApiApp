package com.project.holidayapiapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.holidayapiapp.R;

public class add_task extends AppCompatActivity {
    EditText editTextDate = findViewById(R.id.editTextDate);
    EditText editTextTime = findViewById(R.id.editTextTime);
    EditText editTextActivity = findViewById(R.id.editTextActivity);
    EditText editTextDescription = findViewById(R.id.editTextDescription);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);




    }
    private void saveTask() {
        final String sDate = editTextDate.getText().toString().trim();
        final String sTime = editTextTime.getText().toString().trim();
        final String sActivity = editTextActivity.getText().toString().trim();
        final String sDescription = editTextDescription.getText().toString().trim();

        if (sDate.isEmpty()) {
            editTextDate.setError("Task required");
            editTextDate.requestFocus();
            return;
        }

        if (sTime.isEmpty()) {
            editTextTime.setError("Desc required");
            editTextTime.requestFocus();
            return;
        }

        if (sActivity.isEmpty()) {
            editTextActivity.setError("Finish by required");
            editTextActivity.requestFocus();
            return;
        }

        if (sDescription.isEmpty()) {
            editTextDescription.setError("Finish by required");
            editTextDescription.requestFocus();
            return;
        }

    }

}