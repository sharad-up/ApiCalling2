package com.example.gettingapi2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;
    private List<Countrymodel> countrymodels;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.recyler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface=ApiClient.getApiclient().create(ApiInterface.class);
        Call<List<Countrymodel>> call =apiInterface.getContacts();
        call.enqueue(new Callback<List<Countrymodel>>() {
            @Override
            public void onResponse(Call<List<Countrymodel>> call, Response<List<Countrymodel>> response) {
                countrymodels = response.body();
                adapter= new RecyclerAdapter(countrymodels);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Countrymodel>> call, Throwable t) {

            }
        });
    }
}
