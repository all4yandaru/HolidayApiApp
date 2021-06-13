package com.project.holidayapiapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.holidayapiapp.R;
import com.project.holidayapiapp.model.api.HolidaysItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ViewHolder> {

    private ArrayList<HolidaysItem> holidaysItems = new ArrayList<>();
    private Context context;

    public ApiAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<HolidaysItem> items){
        holidaysItems.clear();
        holidaysItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.api_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holidaysItems.get(position));
    }

    @Override
    public int getItemCount() {
        return holidaysItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvTanggal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
        }

        void bind (final HolidaysItem data){
            tvName.setText(data.getName());
            tvTanggal.setText(dateFormatter(data.getDate()));
        }

        String dateFormatter(String date){
            String inputPattern = "yyyy-MM-dd";
            String outputPattern = "EEE, d MMM yyyy";
            SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
            SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

            Date dateTemp = null;
            String str = null;

            try {
                dateTemp = inputFormat.parse(date);
                str = outputFormat.format(dateTemp);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
