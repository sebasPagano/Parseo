package com.example.alumno.conexionweb;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 01/06/2017.
 */

public class XmlParse {
    public static List<Persona> obtenerPersonas(String xml)
    {
        List<Persona> listaPersonas = new ArrayList<>();

        XmlPullParser xmlPullParser = Xml.newPullParser();

        try {
            xmlPullParser.setInput(new StringReader(xml));
            int event = xmlPullParser.getEventType();

            while(event!= XmlPullParser.END_DOCUMENT)
            {
                if(event == XmlPullParser.START_TAG)
                {
                    if(xmlPullParser.getName().equals("Persona"))
                    {
                        Persona p = new Persona();
                        p.setNombre(xmlPullParser.getAttributeValue(null,"nombre"));
                        p.setEdad(Integer.parseInt(xmlPullParser.getAttributeValue(null,"edad")));

                        listaPersonas.add(p);
                    }
                }
                event = xmlPullParser.next();
            }

        }
        catch (Exception ex)
        {
            Log.d("Error",ex.getMessage());

        }


        return listaPersonas;
    }
}
