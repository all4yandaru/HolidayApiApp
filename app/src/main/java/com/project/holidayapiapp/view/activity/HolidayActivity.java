package com.project.holidayapiapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.holidayapiapp.R;
import com.project.holidayapiapp.adapter.ApiAdapter;
import com.project.holidayapiapp.model.api.ApiByMonth;
import com.project.holidayapiapp.model.api.HolidaysItem;
import com.project.holidayapiapp.view.viewmodel.HolidayViewModel;

import java.util.ArrayList;

public class HolidayActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "extra_data";
    private ApiByMonth apiByMonth;

    RecyclerView rvItem;
    ApiAdapter apiAdapter;
    HolidayViewModel holidayViewModel;

    TextView tvMonthName;
    ImageView ivMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday);

        apiByMonth = getIntent().getParcelableExtra(EXTRA_DATA);
        tvMonthName = findViewById(R.id.tv_month_name);
        tvMonthName.setText(apiByMonth.getName());

        ivMonth = findViewById(R.id.iv_month);
        ivMonth.setImageResource(apiByMonth.getImage());

        apiAdapter = new ApiAdapter(this);
        apiAdapter.notifyDataSetChanged();

        holidayViewModel = new ViewModelProvider(this).get(HolidayViewModel.class);
        holidayViewModel.setHoliday(apiByMonth.getCode());
        holidayViewModel.getHoliday().observe(this, getHoliday);

        rvItem = findViewById(R.id.rv_item);
        rvItem.setLayoutManager(new LinearLayoutManager(this));
        rvItem.setHasFixedSize(true);
        rvItem.setAdapter(apiAdapter);

    }

    private Observer<ArrayList<HolidaysItem>> getHoliday = new Observer<ArrayList<HolidaysItem>>() {
        @Override
        public void onChanged(ArrayList<HolidaysItem> items) {
            if (items != null) {
                apiAdapter.setData(items);
            }
        }
    };
}