package com.example.examenactivities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.examenactivities.R;

public class MainActivity extends AppCompatActivity {
    private Button btnHabitat;
    private Button btnTipo;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHabitat = (Button) findViewById(R.id.botonHabitat);
        btnTipo = (Button) findViewById(R.id.botonTipo);

        btnHabitat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, HabitatActivity.class);
                startActivity(intent);
            }
        });

        btnTipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, TipoActivity.class);
                startActivity(intent);
            }
        });
    }
}