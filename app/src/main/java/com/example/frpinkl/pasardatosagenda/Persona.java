package com.example.frpinkl.pasardatosagenda;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by frpinkl on 07/11/2014.
 */
public class Persona{

    private String nombre;
    private String telefono;

    public Persona(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Persona() {
    }

    public void anadirAlArray(Persona p, ArrayList<Persona> Agenda)
    {
        Agenda.add(p);
    }

    //public void imprimirArray (ArrayList<Persona> Agenda){
     //   for (int i=0; i<Agenda.size(); i++){
     //       Log.d("Nombre"+Agenda.get(i).getNombre().toString(),"Teléfono"+Agenda.get(i).getTelefono().toString());
      //      return;
     //   }
   // }

    public Persona buscarPersona(Persona p, ArrayList<Persona> Agenda)
    {
        for (int i=0; i<Agenda.size(); i++)
        {
            if (p.getNombre().equalsIgnoreCase(Agenda.get(i).getNombre()))
            {
                p = new Persona(Agenda.get(i).getNombre(), Agenda.get(i).getTelefono());
                break;
            }
        }
        return  p;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



}
