package com.example.frpinkl.pasardatosagenda;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


public class Lista extends ListActivity implements Serializable{

    //Intent intento = getIntent();
    ArrayList <Persona> Agenda = new ArrayList<Persona>();

   // ArrayList <Persona> Agenda = (ArrayList<Persona>)intento.getSerializableExtra("agend");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        Intent intento = getIntent();
        ArrayList <Persona> Agenda = (ArrayList<Persona>)intento.getSerializableExtra("agend");

        //configurar el adaptador
        setListAdapter(new ArrayAdapter<Persona>(this, android.R.layout.simple_list_item_1,Agenda));
    }


    public void onListItemClick(ListView parent, View v, int position, long id){
        for(int i=0; i<Agenda.size(); i++) {

            String buscaNombre = Agenda.get(i).getNombre();
            String nomb = Agenda.get(position).toString();


            if(nomb.equalsIgnoreCase(buscaNombre)) {

                Intent intento = new Intent(Lista.this, Activity2.class);
                intento.putExtra("agend", Agenda);
                intento.putExtra("posicion", i);
                startActivityForResult(intento, 1);//este 1 es para referenciarel intento CONTODO DENTRO


                //Log.d("Nombre: " + i + " " + Agenda.get(i).getNombre().toString(), " Teléfono: " + Agenda.get(i).getTelefono().toString());

                break;
            }}


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
