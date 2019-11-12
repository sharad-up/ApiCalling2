package com.example.gettingapi2;

import com.google.gson.annotations.SerializedName;

public class Countrymodel {
    private String name;
    private String code;

    @SerializedName("id")
    public String getName() {
        return  name;
    }

    @SerializedName("user_id")
    public String getCode() {
        return code;
    }
}
