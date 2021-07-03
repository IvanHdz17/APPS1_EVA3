package com.example.eva3_3_runnable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Runnable miRunnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0;  i<10; i++){
                    try {
                        Thread.sleep(1000); //DETIENE LA EJECUCION DEL HILO ACTUAL
                        Log.wtf("RUNNABLE miRunnable", "i = " + (i + 1));
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        };
        Thread thread = new Thread(miRunnable);
        thread.start();

        MiClaseRun miClaseRun = new MiClaseRun();
        Thread thread1 = new Thread(miClaseRun);
        thread1.start();
    }
}

class MiClaseRun implements  Runnable {
    @Override
    public void run() {
        for (int i = 0;  i<10; i++){
            try {
                Thread.sleep(1000); //DETIENE LA EJECUCION DEL HILO ACTUAL
                Log.wtf("RUNNABLE miRunnable", "i = " + (i + 1));
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}