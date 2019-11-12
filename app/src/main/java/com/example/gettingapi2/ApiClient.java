package com.example.gettingapi2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "{\"totalHits\":500,\"hits\":[{\"largeImageURL\":\"https://pixabay.com/get/52e6d54a4f5aa414f6da8c7dda793f7a1636dde3524c704c722c7fdd9748c05a_1280.jpg\",\"webformatHeight\":426,\"webformatWidth\":640,\"likes\":74,\"imageWidth\":7087,\"id\":4609588,\"user_id\":3764790,\"views\":6208,\"comments\":50,\"pageURL\":\"https://pixabay.com/photos/fantasy-forest-horse-girl-red-4609588/\",\"imageHeight\":4724,\"webformatURL\":\"https://pixabay.com/get/52e6d54a4f5aa414f6da8c7dda793f7a1636dde3524c704c722c7fdd9748c05a_640.jpg\",\"type\":\"photo\",\"previewHeight\":99,\"tags\":\"fantasy, forest, horse\",\"downloads\":4471,\"user\":\"enriquelopezgarre\",\"favorites\":46,\"imageSize\":4079133,\"previewWidth\":150,\"userImageURL\":\"https://cdn.pixabay.com/user/2019/10/21/13-19-18-587_250x250.jpg\",\"previewURL\":\"https://cdn.pixabay.com/photo/2019/11/07/18/28/fantasy-4609588_150.jpg\"},{\"largeImageURL\":\"https://pixabay.com/get/52e6d54a4255a514f6da8c7dda793f7a1636dde3524c704c722c7fdd9748c05a_1280.jpg\",\"webformatHeight\":430,\"webformatWidth\":640,\"likes\":72,\"imageWidth\":5321,\"id\":4609879,\"user_id\":2364555,\"views\":4830,\"comments\":22,\"pageURL\":\"https://pixabay.com/photos/camping-england-noble-4609879/\",\"imageHeight\":3576,\"webformatURL\":\"https://pixabay.com/get/52e6d54a4255a514f6da8c7dda793f7a1636dde3524c704c722c7fdd9748c05a_640.jpg\",\"type\":\"photo\",\"previewHeight\":100,\"tags\":\"camping, england, noble\",\"downloads\":3821,\"user\":\"pixel2013\",\"favorites\":54,\"imageSize\":5465338,\"previewWidth\":150,\"userImageURL\":\"https://cdn.pixabay.com/user/2019/07/15/18-51-07-612_250x250.jpg\",\"previewURL\":\"https://cdn.pixabay.com/photo/2019/11/07/20/50/camping-4609879_150.jpg\"},{\"largeImageURL\":\"https://pixabay.com/get/52e6d4434a5aa914f6da8c7dda793f7a1636dde3524c704c722c7fdd9748c05a_1280.jpg\",\"webformatHeight\":384,\"webformatWidth\":640,\"likes\":57,\"imageWidth\":5184,\"id\":4610085,\"user_id\":2364555,\"views\":2938,\"comments\":17,\"pageURL\":\"https://pixabay.com/photos/camping-cadillac-1960-vacations-4610085/\",\"imageHeight\":3112,\"webformatURL\":\"https://pixabay.com/get/52e6d4434a5aa914f6da8c7dda793f7a1636dde3524c704c722c7fdd9748c05a_640.jpg\",\"type\":\"photo\",\"previewHeight\":90,\"tags\":\"camping, cadillac, 1960\",\"downloads\":2493,\"user\":\"pixel2013\",\"favorites\":42,\"imageSize\":2873454,\"previewWidth\":150,\"userImageURL\":\"https://cdn.pixabay.com/user/2019/07/15/18-51-07-612_250x250.jpg\",\"previewURL\":\"https://cdn.pixabay.com/photo/2019/11/07/22/42/camping-4610085_150.jpg\"}],\"total\":1068305}";
    public static Retrofit retrofit = null;

    public static Retrofit getApiclient(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }

    public static class MainActivity extends AppCompatActivity {
        private RecyclerView recyclerView;
        private RecyclerView.LayoutManager layoutManager;
        private RecyclerAdapter adapter;
        private List<Countrymodel> countrymodels;
        private ApiInterface apiinterface;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            recyclerView=(RecyclerView)findViewById(R.id.recyler_view);
            layoutManager=  new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);

            apiinterface = getApiclient().create(ApiInterface.class);
            Call<List<Countrymodel>> call = apiinterface.getContacts();
            call.enqueue(new Callback<List<Countrymodel>>() {
                @Override
                public void onResponse(Call<List<Countrymodel>> call, Response<List<Countrymodel>> response) {
                    countrymodels =response.body();
                    adapter = new RecyclerAdapter(countrymodels);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<Countrymodel>> call, Throwable t) {

                }
            });
        }
    }
}
