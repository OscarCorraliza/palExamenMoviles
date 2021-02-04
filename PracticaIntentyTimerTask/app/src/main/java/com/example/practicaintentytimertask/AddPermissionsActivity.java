
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

public class AddPermissionsActivity extends AppCompatActivity {
    //Declaracion de las variables.
    Activity activity = this;
    TimerTask mTimerTask = null;
    Timer mTimer = null;
    int currentTime = 0;
    boolean count = true;
    //boolean saveData = false;

    //Instanciacion de los elementos xml
    Button btnAddPerm = null;
    Button btnGoHome2 = null;
    TextView txtTimeInitHome = null;
    Intent sendData = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_permissions);

        btnAddPerm = (Button) findViewById(R.id.AddPermissions);
        btnGoHome2 = (Button) findViewById(R.id.GoHome2);
        txtTimeInitHome = (TextView) findViewById(R.id.InitHome2);

        Intent getDataIntent = getIntent();

         txtTimeInitHome.setText(getText(R.string.time_in_initialhomeactivity) + String.valueOf(getDataIntent.getIntExtra("sendData", -1)));

        btnGoHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendData = new Intent();
                sendData.putExtra("sendPermTimer", currentTime);
                sendData.putExtra("sendAddPerm", MainActivity.addPerm);
                setResult(RESULT_OK, sendData);
                finish();
            }
        });

        btnAddPerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.addPerm){
                    MainActivity.addPerm = false;
                    sendData.putExtra("sendAddPerm", MainActivity.addPerm);
                } else{
                    MainActivity.addPerm = true;
                    sendData.putExtra("sendAddPerm", MainActivity.addPerm);
                }

                setResult(RESULT_OK, sendData);

            }
        });
        cronometro();
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