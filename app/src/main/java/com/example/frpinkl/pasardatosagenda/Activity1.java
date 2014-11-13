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

import java.util.ArrayList;


public class Activity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        final Button botonAñadir = (Button)findViewById(R.id.botonAñadir);
        final Button botonEditar = (Button)findViewById(R.id.botonEditar);
        final EditText editNombre = (EditText)findViewById(R.id.editText3);//revisar esto, los nombres
        final EditText editTelef = (EditText)findViewById(R.id.editText2);//revisatr esto

        final ArrayList<Persona> Agenda = new ArrayList<Persona>();


        botonAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //código a ejecutar cuando lo pulse

                EditText editNombre = (EditText)findViewById(R.id.editText);
                String nombreIntroducido = editNombre.getText().toString();
                EditText editTelef = (EditText)findViewById(R.id.editText2);
                String telefonoIntroducido = editTelef.getText().toString();

                if ("".equals(editNombre.getText().toString().trim())){
                    CharSequence msg = getResources().getString(R.string.toastNoNombre);
                    //mostrar toast
                    showToast(getResources().getString(R.string.toastNoNombre));
                    return;
                }
                if ("".equals(editTelef.getText().toString().trim())){
                    CharSequence msg = getResources().getString(R.string.toastNoTelef);
                    //mostrar toast
                    showToast(getResources().getString(R.string.toastNoTelef));
                    return;
                }

                if (editNombre.getText() != null && editTelef.getText() != null){
                    Agenda.add(new Persona(editNombre.getText().toString(), editTelef.getText().toString()));
                    CharSequence msg = getResources().getString(R.string.toastPersonaAñadida);
                    //mostrar toast
                    showToast(getResources().getString(R.string.toastPersonaAñadida));
                    for (int i=0; i<Agenda.size(); i++){
                        Log.d("Nombre: "+ i+" " + Agenda.get(i).getNombre().toString(), " Teléfono: " + Agenda.get(i).getTelefono().toString());

                    }
                    return;
                }



                Intent intent1 = new Intent(Activity1.this,Activity2.class);
                Bundle datoAgenda = new Bundle();
                //datoAgenda.putCharSequenceArray("contacto",Agenda.get().getNombre().toString());

                //intent1.putExtra("agenda",);
                //startActivity(intent);



            }
        });

        botonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String nombre = editNombre.getText().toString();

                //vamos a buscar en el ArrayList
                for(int i=0; i<Agenda.size(); i++){

                    String buscaNombre = Agenda.get(i).getNombre();
                    String nomb = editNombre.getText().toString();

                    if(nomb.equalsIgnoreCase(buscaNombre)){
                        Log.d("Nombre: "+ i+" " + Agenda.get(i).getNombre().toString(), " Teléfono: " + Agenda.get(i).getTelefono().toString());

                        break;
                    }
                }
                //vamos a buscar en el ArrayList


            }
        });
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
