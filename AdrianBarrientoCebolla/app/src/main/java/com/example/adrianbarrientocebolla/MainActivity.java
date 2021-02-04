package com.example.adrianbarrientocebolla;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adrianbarrientocebolla.api.JsonResponse;
import com.example.adrianbarrientocebolla.api.PokeApi;
import com.example.adrianbarrientocebolla.model.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.adrianbarrientocebolla.common.Constantes.ENTRYPOINT;

public class MainActivity extends AppCompatActivity {
    private Button btnHabitats;
    private Button btnTipos;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHabitats = findViewById(R.id.btnHabitat);
        btnTipos = findViewById(R.id.btnTipo);

        btnHabitats.setOnClickListener(v -> {
            intent = new Intent(MainActivity.this, HabitatActivity.class);
            startActivity(intent);
        });

        btnTipos.setOnClickListener(v -> {
            intent = new Intent(MainActivity.this, TipoActivity.class);
            startActivity(intent);
        });

    }


}