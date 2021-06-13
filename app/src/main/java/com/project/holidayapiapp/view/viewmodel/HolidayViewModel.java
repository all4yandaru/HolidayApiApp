package com.project.holidayapiapp.view.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.holidayapiapp.model.api.HolidayApiResponse;
import com.project.holidayapiapp.model.api.HolidaysItem;
import com.project.holidayapiapp.service.api.HolidayApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HolidayViewModel extends ViewModel {

    private HolidayApi holidayApi;
    private MutableLiveData<ArrayList<HolidaysItem>> listHoliday = new MutableLiveData<>();

    public void setHoliday(int code) {
        if (this.holidayApi == null) {
            holidayApi = new HolidayApi();
        }
        holidayApi.getHolidayApi().getAllHoliday(code).enqueue(new Callback<HolidayApiResponse>() {
            @Override
            public void onResponse(Call<HolidayApiResponse> call, Response<HolidayApiResponse> response) {
                HolidayApiResponse holidayApiResponse = response.body();
                if (holidayApiResponse != null && holidayApiResponse.getHolidays() != null) {
                    ArrayList<HolidaysItem> holidaysItems = holidayApiResponse.getHolidays();
                    listHoliday.postValue(holidaysItems);
                    Log.d("viewmodel", holidaysItems.toString());
                }
                Log.d("viewmodel", "on response failed");
            }

            @Override
            public void onFailure(Call<HolidayApiResponse> call, Throwable t) {
                Log.d("viewmodel", t.getMessage());
            }
        });
    }

    public LiveData<ArrayList<HolidaysItem>> getHoliday(){
        return listHoliday;
    }
}
