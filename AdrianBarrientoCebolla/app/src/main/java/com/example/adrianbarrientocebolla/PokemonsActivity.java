package com.example.adrianbarrientocebolla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.adrianbarrientocebolla.api.JsonResponse;
import com.example.adrianbarrientocebolla.api.PokeApi;
import com.example.adrianbarrientocebolla.common.PokemonAdapter;
import com.example.adrianbarrientocebolla.model.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.adrianbarrientocebolla.common.Constantes.ENTRYPOINT;

public class PokemonsActivity extends AppCompatActivity {
    private List<Pokemon> resources;
    private PokemonAdapter adapter;
    private ListView listView;
    private int id;
    private String llamada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemons);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        llamada = intent.getStringExtra("llamada");
        switch(llamada){
            case "habitat":
                getPokemonsByHabitat(id);
                break;
            case "tipo":
                getPokemonsByTipo(id);
                break;
        }
        listView = findViewById(R.id.listViewPokemons);
        getPokemonsByHabitat(id);
    }

    public void getPokemonsByHabitat(int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENTRYPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PokeApi apiPokemon = retrofit.create(PokeApi.class);

        apiPokemon.getPokemonsByHabitats(id).enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if (response != null && response.body() != null) {
                    resources = response.body().pokemon_species;
                    for(Pokemon p:resources){
                        System.out.println(p.getName());
                    }
                    adapter = new PokemonAdapter(PokemonsActivity.this, resources);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {}
        });
    }
    public void getPokemonsByTipo(int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENTRYPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokeApi apiPokemon = retrofit.create(PokeApi.class);

        apiPokemon.getPokemonsByTipo(id).enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if (response != null && response.body() != null) {
                    resources = response.body().pokemon_species;
                    for(Pokemon p:resources){
                        System.out.println(p.getName());
                    }
                    adapter = new PokemonAdapter(PokemonsActivity.this, resources);
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