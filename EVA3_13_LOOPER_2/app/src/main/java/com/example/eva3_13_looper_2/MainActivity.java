package com.example.eva3_13_looper_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVwMostrar;
    Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            txtVwMostrar.append((String)msg.obj + "\n");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMostrar = findViewById(R.id.txtVwMostrar);
        Background background = new Background();
        background.ejecutarTarea(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<10; i++){
                    try {
                        Thread.sleep(1000);
                        Message message = handler.obtainMessage(100,"i= " + i);
                        handler.sendMessage(message);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                Message message = handler.obtainMessage(100,"FIN DEL HILO A");
                handler.sendMessage(message);
            }
        }).ejecutarTarea(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Message message = handler.obtainMessage(100,"FIN DEL HILO B");
                handler.sendMessage(message);
            }
        });
    }
}

class Background extends HandlerThread{
    Handler handler;

    public Background(){
        super("Background");
        start();
        handler = new Handler(getLooper());
    }

    public Background ejecutarTarea(Runnable tarea){
        handler.post(tarea);
        return this;
    }
}