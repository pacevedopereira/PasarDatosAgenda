package com.example.frpinkl.pasardatosagenda;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


public class Activity1 extends Activity implements Serializable{


    ArrayList<Persona> Agenda = new ArrayList<Persona>();//para que lo coja en toda la clase
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        final Button botonAñadir = (Button)findViewById(R.id.botonAñadir);
        final Button botonVerLista = (Button)findViewById(R.id.botonVerLista);
        final EditText introNombre = (EditText)findViewById(R.id.introNombre);//revisar esto, los nombres
        final EditText introTelef = (EditText)findViewById(R.id.introTelef);//revisatr esto
        //final EditText buscarNombre = (EditText)findViewById(R.id.buscarNombre);

        //comentario para hacer el commit del examen. App lista para corregir


        botonAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //código a ejecutar cuando lo pulse

                //EditText introNombre = (EditText)findViewById(R.id.introNombre);
                //String nombreIntroducido = introNombre.getText().toString();
                //EditText introTelef = (EditText)findViewById(R.id.introTelef);
                //String telefonoIntroducido = introTelef.getText().toString();

                //asdfasdf
                if ("".equals(introNombre.getText().toString().trim())){
                    CharSequence msg = getResources().getString(R.string.toastNoNombre);
                    //mostrar toast
                    showToast(getResources().getString(R.string.toastNoNombre));
                    return;
                }
                if ("".equals(introTelef.getText().toString().trim())){
                    CharSequence msg = getResources().getString(R.string.toastNoTelef);
                    //mostrar toast
                    showToast(getResources().getString(R.string.toastNoTelef));
                    return;
                }

                if (introNombre.getText() != null && introTelef.getText() != null){
                    Agenda.add(new Persona(introNombre.getText().toString(), introTelef.getText().toString()));
                    CharSequence msg = getResources().getString(R.string.toastPersonaAñadida);
                    //mostrar toast
                    showToast(getResources().getString(R.string.toastPersonaAñadida));
                    /*for (int i=0; i<Agenda.size(); i++){
                        Log.d("Nombre: "+ i+" " + Agenda.get(i).getNombre().toString(), " Teléfono: " + Agenda.get(i).getTelefono().toString());

                    }*/
                    Log.d("Nombre: "+ (Agenda.size()-1)+" " + Agenda.get(Agenda.size()-1).getNombre().toString(), " Teléfono: " + Agenda.get(Agenda.size()-1).getTelefono().toString());

                    return;
                }



                //Intent intent1 = new Intent(Activity1.this,Activity2.class);
                //Bundle datoAgenda = new Bundle();
                //datoAgenda.putCharSequenceArray("contacto",Agenda.get().getNombre().toString());

                //intent1.putExtra("agenda",);
                //startActivity(intent);



            }
        });

        botonVerLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String nombre = editNombre.getText().toString();

                //vamos a buscar en el ArrayList
              /*  for(int i=0; i<Agenda.size(); i++){

                    String buscaNombre = Agenda.get(i).getNombre();
                    String nomb = buscarNombre.getText().toString();

                    if(nomb.equalsIgnoreCase(buscaNombre)){

                        Intent intento = new Intent(Activity1.this,Activity2.class);
                        intento.putExtra("nombrePersona", Agenda.get(i).getNombre().toString());
                        intento.putExtra("telefonoPersona", Agenda.get(i).getTelefono().toString());
                        intento.putExtra("posicion", i);

                        startActivityForResult(intento,1);//este 1 es para referenciarel intento CONTODO DENTRO


                        Log.d("Nombre: " + i + " " + Agenda.get(i).getNombre().toString(), " Teléfono: " + Agenda.get(i).getTelefono().toString());

                        break;
                    }
                }
                */



                Intent intento = new Intent(Activity1.this, Lista.class);
                intento.putExtra("agend",Agenda);
                startActivityForResult(intento,1);






            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Agenda.get(data.getExtras().getInt("nuevaPos")).setNombre(data.getExtras().getString("nuevoNombre"));
        //Agenda.get(data.getExtras().getInt("nuevaPos")).setTelefono(data.getExtras().getString("nuevoTelef"));

        //Intent intento= getIntent();

        if (requestCode==1 && resultCode==RESULT_OK){


            Agenda = (ArrayList<Persona>) data.getSerializableExtra("agend");


        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menu_activity1, menu);
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



    protected void showToast(String msg) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, msg, duration);
        toast.show();
    }
}
