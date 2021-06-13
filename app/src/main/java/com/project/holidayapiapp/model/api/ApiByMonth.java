package com.project.holidayapiapp.model.api;

import android.os.Parcel;
import android.os.Parcelable;

public class ApiByMonth implements Parcelable {
    private String name;
    private int code;
    private int image;

    public ApiByMonth() {
    }

    protected ApiByMonth(Parcel in) {
        name = in.readString();
        code = in.readInt();
        image = in.readInt();
    }

    public static final Creator<ApiByMonth> CREATOR = new Creator<ApiByMonth>() {
        @Override
        public ApiByMonth createFromParcel(Parcel in) {
            return new ApiByMonth(in);
        }

        @Override
        public ApiByMonth[] newArray(int size) {
            return new ApiByMonth[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(code);
        dest.writeInt(image);
    }
}
