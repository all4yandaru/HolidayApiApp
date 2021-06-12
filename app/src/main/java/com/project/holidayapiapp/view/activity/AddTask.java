package com.project.holidayapiapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.project.holidayapiapp.R;

public class AddTask extends AppCompatActivity {
    private EditText editTextDate, editTextTime, editTextActivity , editTextDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        editTextDate = findViewById(R.id.editTextDate);
        editTextTime = findViewById(R.id.editTextTime);
        editTextActivity = findViewById(R.id.editTextActivity);
        editTextDescription = findViewById(R.id.editTextDescription);
    }
}