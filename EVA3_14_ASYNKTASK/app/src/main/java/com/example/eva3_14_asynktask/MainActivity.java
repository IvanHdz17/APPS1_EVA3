package com.example.eva3_14_asynktask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtVwMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMostrar = findViewById(R.id.txtVwMostrar);
        MiClaseAsincrona miCA = new MiClaseAsincrona();
        miCA.execute(10,500);
        //15 --> BANNER_ASYNKTASK
        //16 --> LOAD_IMAGE_ASYNKTASK
    }

    class MiClaseAsincrona extends AsyncTask<Integer,String,Void>{
        @Override
        protected void onPreExecute() { //SI SE PUEDE INTERACTUAR CON LA UI
            super.onPreExecute();
            txtVwMostrar.append("INICIANDO LA TAREA ASINCRONA \n");
        }

        @Override //NO SE PUEDE INTERACTUAR CON LA UI
        protected Void doInBackground(Integer... integers) { //Equivalente al metodo run() en un Thread
           int limite = integers[0], time = integers[1];
            for (int i = 0; i<limite; i++){
                try {
                    Thread.sleep(time);
                    publishProgress("i = " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) { //SI SE PUEDE INTERACTUAR CON LA UI
            super.onProgressUpdate(values);
            txtVwMostrar.append(values[0] + "\n");
        }

        @Override
        protected void onPostExecute(Void aVoid) { //SI SE PUEDE INTERACTUAR CON LA UI
            super.onPostExecute(aVoid);
            txtVwMostrar.append("FIN DE LA TAREA ASINCRONA \n");
        }

    }
}