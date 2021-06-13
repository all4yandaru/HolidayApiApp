package com.project.holidayapiapp.model.api;

import com.project.holidayapiapp.R;

import java.util.ArrayList;

public class ApiByMonthData {
    public static String name[] = new String[]{
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    public static int code[] = new int[]{
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
    };

    public static int image[] = new int[]{
            R.drawable.january,
            R.drawable.february,
            R.drawable.march,
            R.drawable.april,
            R.drawable.may,
            R.drawable.june,
            R.drawable.july,
            R.drawable.august,
            R.drawable.sepember,
            R.drawable.october,
            R.drawable.november,
            R.drawable.december
    };

    public static ArrayList<ApiByMonth> getListData(){
        ArrayList<ApiByMonth> list = new ArrayList<>();

        for (int i=0; i<name.length; i++){
            ApiByMonth data = new ApiByMonth();
            data.setName(name[i]);
            data.setCode(code[i]);
            data.setImage(image[i]);

            list.add(data);
        }
        return list;
    }
}
