package com.project.holidayapiapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.project.holidayapiapp.R;
import com.project.holidayapiapp.model.ApiByMonth;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.ViewHolder> {
    ArrayList<ApiByMonth> monthList = new ArrayList<>();

    public MonthAdapter(ArrayList<ApiByMonth> monthList) {
        this.monthList = monthList;
    }

    @NonNull
    @Override
    public MonthAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.month_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonthAdapter.ViewHolder holder, int position) {
        holder.bind(monthList.get(position));
    }

    @Override
    public int getItemCount() {
        return monthList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cvMonth;
        TextView tvMonth;
        Context context = itemView.getContext();

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cvMonth = itemView.findViewById(R.id.cv_month);
            tvMonth = itemView.findViewById(R.id.tv_month);
        }

        void bind(final ApiByMonth data){
            tvMonth.setText(data.getName());
            cvMonth.setBackgroundResource(data.getImage());
 
        }
    }
}
