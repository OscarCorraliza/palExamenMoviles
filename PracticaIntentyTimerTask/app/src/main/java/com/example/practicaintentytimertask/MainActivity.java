package com.example.practicaintentytimertask;

import androidx.annotation.Nullable;
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

public class MainActivity extends AppCompatActivity {
    //Declaracion de las variables.
    Activity activity = this;
    TimerTask mTimerTask = null;
    Timer mTimer = null;
    int currentTime = 0;
    boolean count = true;
    int timeSaveData = 0;
    int timeAddPerm = 0;
    static boolean saveData = false;
    static boolean addPerm = false;

    //Instanciacion de los elementos xml
    TextView txtThisTime = null;
    Button btnData = null;
    Button btnPerm = null;
    TextView txtSaveDataTime = null;
    TextView txtAddPTime = null;
    TextView txtSaveData = null;
    TextView txtAddP = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnData = (Button) findViewById(R.id.buttonData);
        btnPerm = (Button) findViewById(R.id.buttonPermissions);
        txtThisTime = (TextView) findViewById(R.id.ThisActivityTime);
        txtSaveDataTime = (TextView) findViewById(R.id.DataActivityTime);
        txtAddPTime = (TextView) findViewById(R.id.AddPTime);
        txtSaveData = (TextView) findViewById(R.id.SaveData2);
        txtAddP = (TextView) findViewById(R.id.AddP);


        //Para ir a la activitySaveData
        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDataActivity = new Intent(MainActivity.this, SaveDataActivity.class);
                intentDataActivity.putExtra("sendData", currentTime);
                startActivityForResult(intentDataActivity, 1);
            }
        });

        //Para ir a la acitivityPerm
        btnPerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPermActivity = new Intent(getApplicationContext(), AddPermissionsActivity.class);
                intentPermActivity.putExtra("sendData", currentTime);
                startActivityForResult(intentPermActivity, 2);
            }
        });

        cronometro();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if (resultCode == RESULT_OK){
                int recibido = data.getIntExtra("sendDataTimer", 0);
                timeSaveData += recibido;
                txtSaveDataTime.setText(getText(R.string.time_in_savedataactivity) + String.valueOf(timeSaveData));
                txtSaveData.setText(getText(R.string.save_data) + String.valueOf(data.getBooleanExtra("sendSaveData", false)));
            }
        } else if (requestCode == 2){
            if(resultCode == RESULT_OK){
                int recibido2 = data.getIntExtra("sendPermTimer", 0);
                timeAddPerm += recibido2;
                txtAddPTime.setText(getText(R.string.time_in_addpermissionsactivity) + String.valueOf(timeAddPerm));
                txtAddP.setText(getText(R.string.add_permissions) + String.valueOf(data.getBooleanExtra("sendAddPerm" , false)));
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        count = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        count = true;


        /*Intent getDataIntentSave = getIntent();
        int sumar = getDataIntentSave.getIntExtra("sendDataTimer", -1);
        timeSaveData += sumar;
        Log.d("timeSavesumar", String.valueOf(sumar));
        Log.d("timeSaveMain", String.valueOf(getDataIntentSave.getIntExtra("envio", 0)));
        txtSaveDataTime.setText(getText(R.string.time_in_savedataactivity) + String.valueOf(getDataIntentSave.getIntExtra("sendDataTimer", 0)));*/



    }

    public void cronometro() {
        mTimerTask = new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (count) {
                            currentTime++;
                        }
                        txtThisTime.setText(getString(R.string.time_in_this_activity) + String.valueOf(currentTime));
                    }
                });
            }
        };

        mTimer = new Timer();
        mTimer.schedule(mTimerTask, 1, 1000);
    }


}