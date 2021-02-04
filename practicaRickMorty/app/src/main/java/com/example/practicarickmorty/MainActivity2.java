package com.example.practicarickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.practicarickmorty.apiManager.JsonResponse;
import com.example.practicarickmorty.apiManager.ifaceApi;
import com.example.practicarickmorty.common.Adapter;
import com.example.practicarickmorty.common.Constantes;
import com.example.practicarickmorty.common.Personaje;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.practicarickmorty.common.Constantes.ENTRYPOINT;
import static com.example.practicarickmorty.common.Constantes.PERSONAJES;

public class MainActivity2 extends AppCompatActivity {
    public static int page = 0;
    private ListView listView;
    private Adapter adapter;
    private List<Personaje> personajeList;
    private List<Personaje> personajeListFinal = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.listViewPokemonsPorId);
        getCharacters();
    }

    public void getCharacters(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENTRYPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ifaceApi api_rm = retrofit.create(ifaceApi.class);

        for(page = 0; page < 35; page++){
            Log.d("falla", PERSONAJES + page);
            api_rm.getPersonajes(PERSONAJES + page).enqueue(new Callback<JsonResponse>() {
                @Override
                public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                    if(response.raw().code() == 200 && response.body() != null){

                        personajeList = response.body().listaPersonaje;

                        for(Personaje p:personajeList){
                            personajeListFinal.add(p);
                        }


                        Log.d("lista", String.valueOf(personajeListFinal.size()));
                    }
                    adapter = new Adapter(MainActivity2.this, personajeListFinal);
                    listView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                }

                @Override
                public void onFailure(Call<JsonResponse> call, Throwable t) {
                    Log.d("falla", "nbno");
                    t.printStackTrace();
                }
            });
        }
    }
}