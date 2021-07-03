package com.example.eva3_6_handler_message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVwMensaje;
    Thread thread;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //AQUI PODEMOS MODIFICAR LA INTERFAZ GRAFICA
            //TRABAJO LIGERO --> UNA TAREA INTENSA VA A TRABAR LA UI
            String cade = (String)msg.obj;
            int what = msg.what;
            txtVwMensaje.append("El hilo = " + what + "imprime: " + cade + "\n");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMensaje = findViewById(R.id.txtVwMensaje);
        //txtVwMensaje.setText("Hola Mundo");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                        String cade = "i = " + i;
                        i++;
                        //SOLICITAMOS MENSAJE
                        //PONER INFO EN EL MENSAJE
                        Message message = handler.obtainMessage(1000, cade);
                        //DEVOLVERLO
                        handler.sendMessage(message);

                        Log.wtf("runnable", cade);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}