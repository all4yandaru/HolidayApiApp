package com.project.holidayapiapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.project.holidayapiapp.R;
import com.project.holidayapiapp.model.Task;
import com.project.holidayapiapp.view.activity.HomeActivity;
import com.project.holidayapiapp.view.activity.UpdateTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {

    private Context mCtx;
    private List<Task> taskList;
    private ArrayList<Task> arrayList;

    public TasksAdapter(Context mCtx, List<Task> taskList) {
        this.mCtx = mCtx;
        this.taskList = taskList;
        this.arrayList = new ArrayList<Task>();
        this.arrayList.addAll(taskList);
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.task_layout, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        Task t = taskList.get(position);
        holder.textViewDate.setText(t.getDate());
        holder.textViewTime.setText(t.getTime());
        holder.textViewActivity.setText(t.getActivity());
        holder.textViewDescription.setText(t.getDescription());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewDate, textViewTime, textViewActivity, textViewDescription;

        public TasksViewHolder(View itemView) {
            super(itemView);

            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            textViewActivity = itemView.findViewById(R.id.textViewActivity);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Task task = taskList.get(getBindingAdapterPosition());

            Intent intent = new Intent(mCtx, UpdateTask.class);
            intent.putExtra("task", task);

            mCtx.startActivity(intent);
        }
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        taskList.clear();
        if (charText.length() == 0) {
            taskList.addAll(arrayList);
        } else {
            for (Task wp : arrayList) {
                if (wp.getActivity().toLowerCase(Locale.getDefault()).contains(charText)) {
                    taskList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}