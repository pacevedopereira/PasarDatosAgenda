package com.example.frpinkl.pasardatosagenda;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

   //ArrayList <Persona> Agenda = (ArrayList<Persona>)intento.getSerializableExtra("agend");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        Intent intento = getIntent();
        Agenda = (ArrayList<Persona>)intento.getSerializableExtra("agend");

        /**ArrayList <Persona>**/
        //configurar el adaptador
        setListAdapter(new ArrayAdapter<Persona>(this, android.R.layout.simple_list_item_1,Agenda));

        setResult(RESULT_OK, intento); //ponerlo siempre que pueda volver atrás y modificar el array porque si no al volver a listar se encuentra con dos arraylists diferentesy rompe


    }


    public void onListItemClick(ListView parent, View v, int position, long id){
     /*   for(int i=0; i<Agenda.size(); i++) {


            //String buscaNombre = Agenda.get(i).getNombre();
            String nomb = Agenda.get(position).toString();


            if(nomb.equalsIgnoreCase(buscaNombre)) {

                Intent intento = new Intent(Lista.this, Activity2.class);
                intento.putExtra("agend", Agenda);
                intento.putExtra("posicion", i);
                startActivityForResult(intento, 1);//este 1 es para referenciarel intento CONTODO DENTRO


                //Log.d("Nombre: " + i + " " + Agenda.get(i).getNombre().toString(), " Teléfono: " + Agenda.get(i).getTelefono().toString());

                break;
            }

        }*/

        Persona persona = Agenda.get(position);
        Intent intento = new Intent(Lista.this, Activity2.class);

        intento.putExtra("agend", Agenda);
        intento.putExtra("positio", position);
        startActivityForResult(intento,1);
        finish();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1 && resultCode==RESULT_OK){
            int posicion = (Integer)data.getSerializableExtra("nuevaPos");
            Persona p = (Persona) data.getSerializableExtra("person");

            Log.d("Persona",""+p.toString());
            Agenda.set(posicion,p);
            setResult(RESULT_OK);

            Intent intento = new Intent(Lista.this, Activity1.class);
            intento.putExtra("agend", Agenda);
            setResult(RESULT_OK,intento);

            finish();


        }
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
