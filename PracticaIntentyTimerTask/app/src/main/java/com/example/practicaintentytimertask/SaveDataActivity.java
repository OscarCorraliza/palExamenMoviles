package com.example.practicaintentytimertask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SaveDataActivity extends AppCompatActivity {
    //Declaracion de las variables.
    Activity activity = this;
    TimerTask mTimerTask = null;
    Timer mTimer = null;
    int currentTime = 0;
    boolean count = true;
    //boolean saveData = false;

    //Instanciacion de los elemntos xml
    Button btnSaveData = null;
    Button btnGoHome = null;
    TextView txtTimeInitHome = null;
    Intent sendData = new Intent();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);

        btnSaveData = (Button) findViewById(R.id.SaveData2);
        btnGoHome = (Button) findViewById(R.id.GoHome);
        txtTimeInitHome = (TextView) findViewById(R.id.InitHome);

        Intent getDataIntent = getIntent();

        txtTimeInitHome.setText(getString(R.string.time_in_inithomeactivity) + String.valueOf(getDataIntent.getIntExtra("sendData", -1)));

        cronometro();


        btnGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData.putExtra("sendDataTimer", currentTime);
                sendData.putExtra("sendSaveData", MainActivity.saveData);
                setResult(RESULT_OK, sendData);
                finish();
            }
        });

        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.saveData){
                    MainActivity.saveData = false;
                    sendData.putExtra("sendSaveData", MainActivity.saveData);
                } else{
                    MainActivity.saveData = true;
                    sendData.putExtra("sendSaveData", MainActivity.saveData);
                }

                setResult(RESULT_OK, sendData);

            }
        });
    }

    public void cronometro() {
        mTimerTask = new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                            currentTime++;
                    }
                });
            }
        };

        mTimer = new Timer();
        mTimer.schedule(mTimerTask, 1, 1000);
    }

}