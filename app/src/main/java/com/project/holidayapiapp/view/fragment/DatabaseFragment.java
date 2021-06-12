package com.project.holidayapiapp.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.project.holidayapiapp.R;
import com.project.holidayapiapp.adapter.TasksAdapter;
import com.project.holidayapiapp.database.TaskDAO;
import com.project.holidayapiapp.database.TaskDatabase;
import com.project.holidayapiapp.model.Task;
import com.project.holidayapiapp.view.activity.AddTask;

import java.util.ArrayList;
import java.util.List;

public class DatabaseFragment extends Fragment {

    private RecyclerView rv;
    private TasksAdapter tasksAdapter;
    private ArrayList<Task> listPenjualan = new ArrayList<>();
    private TaskDAO taskDAO;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_database, container , false);
        rv = root.findViewById(R.id.recyclerview_tasks);
        taskDAO = TaskDatabase.getInstance(root.getContext()).taskDAO();
        FloatingActionButton buttonAddTask = root.findViewById(R.id.floating_button_add);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(root.getContext()));
        loadData();
        tasksAdapter = new TasksAdapter(root.getContext(),listPenjualan);
        rv.setAdapter(tasksAdapter);
        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddTask.class);
                startActivity(intent);
            }
        });
        return root;
    }

    void loadData() {
        List<Task> data = taskDAO.getAllData();
        if (listPenjualan.size() >= 0) {
            listPenjualan.clear();
        }
        Log.d("showData", data.toString());
        listPenjualan.addAll(data);

        if (data.size() == 0) {
            showSnackbar("Tidak ada data!");
        }
    }

    private void showSnackbar(String message) {
        Snackbar.make(rv, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // code something here ....
    }
}