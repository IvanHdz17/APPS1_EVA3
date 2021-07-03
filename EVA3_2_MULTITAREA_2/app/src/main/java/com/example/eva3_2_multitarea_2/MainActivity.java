package com.example.eva3_2_multitarea_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Thread =  Clase // Runnables = Interfaz
        //Thread --> Clase para crear hilos (java)
        //Crear propia clase que herede de Thread
        //Crear clase anonima
        //Sobreescribir el metodo run(){}

        Thread miHilo = new Thread(){
            //AQUI VAN LAS TAREAS EN SEGUNDO PLANO
            @Override
            public void run() {
                super.run();
                for (int i = 0;  i<10; i++){
                    try {
                        Thread.sleep(1000); //DETIENE LA EJECUCION DEL HILO ACTUAL
                        Log.wtf("HILO PRINCIPAL", "i = " + (i + 1));
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        };
        miHilo.start(); //Iniciamos el hilo de ejecucion
        MiHilote miHilote = new MiHilote();
        //miHilote.run(); //LLAMADA A FUNCION DENTRO DEL HILO PRINCIPAL
        miHilote.start();
    }
}

class MiHilote extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0;  i<10; i++){
            try {
                Thread.sleep(1000); //DETIENE LA EJECUCION DEL HILO ACTUAL
                Log.wtf("HILO MiHilote", "x = " + (i + 1));
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}