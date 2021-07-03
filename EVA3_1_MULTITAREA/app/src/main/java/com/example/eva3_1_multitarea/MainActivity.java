package com.example.eva3_1_multitarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //LINUX --> PROCESO --> TIENE UN HILO DE EJECUCION PRINCIPAL
        for (int i = 0;  i<10; i++){
            try {
                Thread.sleep(1000); //DETIENE LA EJECUCION DEL HILO ACTUAL
                Log.wtf("HILO PRINCIPAL", "i = " + (i + 1));
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}