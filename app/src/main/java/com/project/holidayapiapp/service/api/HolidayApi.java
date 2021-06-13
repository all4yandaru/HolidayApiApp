package com.project.holidayapiapp.service.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HolidayApi {
    private Retrofit retrofit;

    private static final String URL_BASE = "https://holidayapi.com/";

    public HolidayRepository getHolidayApi() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(HolidayRepository.class);
    }
}
