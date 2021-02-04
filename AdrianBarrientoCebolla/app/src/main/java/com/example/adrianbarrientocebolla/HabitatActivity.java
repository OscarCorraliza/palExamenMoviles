package com.example.adrianbarrientocebolla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

public class HabitatActivity extends AppCompatActivity {

    private List<Pokemon> resources;
    private PokemonAdapter adapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habitat);

        listView = findViewById(R.id.listView);
        getHabitats();
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(HabitatActivity.this, PokemonsActivity.class);
            intent.putExtra("id", (position+1));
            intent.putExtra("llamada", "habitat");
            startActivity(intent);
        });
    }


    public void getHabitats() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENTRYPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokeApi apiPokemon = retrofit.create(PokeApi.class);

        apiPokemon.getHabitats().enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                if (response != null && response.body() != null) {
                    resources = response.body().results;

                    adapter = new PokemonAdapter(HabitatActivity.this, resources);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {}
        });
    }

}