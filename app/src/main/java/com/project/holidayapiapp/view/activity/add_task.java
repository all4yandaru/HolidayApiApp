package com.project.holidayapiapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.holidayapiapp.R;

public class add_task extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        FloatingActionButton buttonAddTask = findViewById(R.id.floating_button_add);
        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(add_task.this, add_task.class);
                startActivity(intent);
            }
        });
    }
}