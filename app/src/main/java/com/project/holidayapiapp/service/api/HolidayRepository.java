package com.project.holidayapiapp.service.api;

import com.project.holidayapiapp.model.api.HolidayApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HolidayRepository {

    @GET("v1/holidays?pretty&key=b76340cd-bdb9-4c67-852a-850ef9139d52&country=ID&year=2022&")
    Call<HolidayApiResponse> getAllHoliday(@Query("month") int code);
}
