package com.example.alumno.conexionweb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements  Handler.Callback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(this);

        JsonPar jsonPar = new JsonPar();
        jsonPar.parcear("{'codigo': 200,'mensaje':'Validado'}");
        ThreadConexion s1 = new ThreadConexion("http://www.lslutnfra.com/alumnos/practicas/listaPersonas.xml",handler);
        Thread t = new Thread(s1);
        ImageView img =(ImageView) findViewById(R.id.imageView);
        TextView txt = (TextView) findViewById(R.id.textView);

        t.start();


    }

    @Override
    public boolean handleMessage(Message msg) {

        Log.d("Respuesta","Llego la respuesta del hilo");
        ImageView img =(ImageView) findViewById(R.id.imageView);
        TextView txt = (TextView) findViewById(R.id.textView);
       switch (msg.arg1){
            case 0:
                Log.d("Activity ","Error");
                break;
            case 1:
                Log.d("Activity","Recibiendo bytes");
               byte[] bytes = (byte[]) msg.obj;
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                img.setImageBitmap(bitmap);
                break;
            case 2:
                List<Persona> personas = (List<Persona>) msg.obj;

                for(Persona p : personas) {
                 Log.d("Persona",p.getNombre());
                }
                txt.setText(personas.get(0).getNombre());


        }

        return false;
    }
}
