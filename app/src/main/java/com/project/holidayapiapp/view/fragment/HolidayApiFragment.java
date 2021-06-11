package com.project.holidayapiapp.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.holidayapiapp.R;
import com.project.holidayapiapp.adapter.MonthAdapter;
import com.project.holidayapiapp.model.ApiByMonth;
import com.project.holidayapiapp.model.ApiByMonthData;

import java.util.ArrayList;

public class HolidayApiFragment extends Fragment {

    ArrayList<ApiByMonth> apiByMonthArrayList = new ArrayList<>();
    RecyclerView rvMonth;
    MonthAdapter monthAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_holiday_api, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // code something here .....
        rvMonth = view.findViewById(R.id.rv_month);
        apiByMonthArrayList = ApiByMonthData.getListData();

        monthAdapter = new MonthAdapter(apiByMonthArrayList);

        rvMonth.setHasFixedSize(true);
        rvMonth.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvMonth.setAdapter(monthAdapter);
    }
}