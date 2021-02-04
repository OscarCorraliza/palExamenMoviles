package com.example.examenactivities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.examenactivities.R;
import com.example.examenactivities.aPiManager.IfaceApi;
import com.example.examenactivities.aPiManager.JsonResponse;
import com.example.examenactivities.common.Adapter;
import com.example.examenactivities.common.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.examenactivities.common.Constants.ENTRYPOINT;

public class HabitatActivity extends AppCompatActivity {
    private List<Pokemon> resources;
    private Adapter adapter;
    private ListView listView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        listView = findViewById(R.id.listViewPokemons);
        getHabitats();

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(HabitatActivity.this, PokemonsIdActivity.class);
            intent.putExtra("id", (position+1));
            intent.putExtra("llamada", "habitat");
            startActivity(intent);
        });
    }

    public void getHabitats(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENTRYPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IfaceApi ifaceApi = retrofit.create(IfaceApi.class);

        ifaceApi.getHabitats().enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if(response.raw().code() == 200 && response.body() != null){
                    resources = response.body().results;

                    adapter = new Adapter(HabitatActivity.this, resources);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

            }
        });
    }
}
