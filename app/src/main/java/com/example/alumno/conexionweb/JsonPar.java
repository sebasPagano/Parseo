package com.example.alumno.conexionweb;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by alumno on 01/06/2017.
 */

public class JsonPar {

    public void parcear(String str){
        try{
           JSONObject jsonObject = new JSONObject(str);
//            JSONArray frutas = jsonObject.getJSONArray("frutas");

         //   for(int i = 0; i<frutas.length();i++)
           // {
                //JSONObject fruta = frutas.getJSONObject(i);
                String mensaje = jsonObject.getString("mensaje");
                Integer cod = jsonObject.getInt("codigo");
            Log.d("Mensaje"+mensaje,cod.toString());
            //}

        }
        catch (Exception e)
        {

        }

    }
}
