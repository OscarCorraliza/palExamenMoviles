package com.example.examenactivities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
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

public class PokemonsIdActivity extends AppCompatActivity {
    private List<Pokemon> resources;
    private Adapter adapter;
    private ListView listView;
    private int id;
    private String llamada;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("holaktl" , "entra");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listporid);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        llamada = intent.getStringExtra("llamada");

        Log.d("holaktl" , String.valueOf(id));
        Log.d("holaktl" , llamada);


        switch(llamada){
            case "habitat":
                pokemonHabitatId(id);
                break;
            case "tipo":
                pokemonTipoId(id);
                break;
        }
        listView = findViewById(R.id.listViewPokemonsPorId);
        pokemonHabitatId(id);
    }

    public void pokemonHabitatId(int id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENTRYPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IfaceApi apiPokemon = retrofit.create(IfaceApi.class);

        apiPokemon.getHabitatsPorId(id).enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if(response.raw().code() == 200 && response.body() != null){
                    resources = response.body().pokemon_species;

                    adapter = new Adapter(PokemonsIdActivity.this, resources);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

            }
        });
    }

    public void pokemonTipoId(int id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENTRYPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IfaceApi apiPokemon = retrofit.create(IfaceApi.class);

        apiPokemon.getTiposPorId(id).enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if(response.raw().code() == 200 && response.body() != null){
                    resources = response.body().pokemon_species;

                    adapter = new Adapter(PokemonsIdActivity.this, resources);
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
