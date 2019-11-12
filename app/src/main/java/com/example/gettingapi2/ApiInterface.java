package com.example.gettingapi2;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("readCountry")
    Call<List<Countrymodel>> getContacts();
}
