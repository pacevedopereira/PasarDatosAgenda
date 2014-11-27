package com.example.frpinkl.pasardatosagenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class Activity2 extends Activity {

    EditText etNombreActivity2;
    EditText etTelefonoActivity2;
    Button boBotoneditar;
    ArrayList<Persona> Agenda = new ArrayList<Persona>();
    int pos;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);


        Intent intento = getIntent();
        Agenda = (ArrayList<Persona>)intento.getSerializableExtra("agend");
        pos = (Integer)intento.getSerializableExtra("positio");

//        final EditText nombreActivity2 = (EditText)findViewById(R.id.nombreActivity2);
//        final EditText telefonoActivity2 = (EditText)findViewById(R.id.telefonoActivity2);

        boBotoneditar = (Button)findViewById(R.id.botonEditar);
        etNombreActivity2 = (EditText)findViewById(R.id.nombreActivity2);
        etTelefonoActivity2 = (EditText)findViewById(R.id.telefonoActivity2);

        etNombreActivity2.setText(Agenda.get(pos).getNombre().toString());
        etTelefonoActivity2.setText(Agenda.get(pos).getTelefono().toString());













/*

        final int posicionArray = intento.getExtras().getInt("posicion");
        nombreActivity2.setText(intento.getExtras().getString("nombrePersona"));
        telefonoActivity2.setText(intento.getExtras().getString("telefonoPersona"));
*/
        //ahora el evento del botón
        //final Button botonActivity2 = (Button)findViewById(R.id.botonActivity2);

        boBotoneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newNome = ((EditText) findViewById(R.id.nombreActivity2)).getText().toString();
                String newTelef = ((EditText) findViewById(R.id.telefonoActivity2)).getText().toString();

                Persona persona = new Persona(newNome, newTelef);

                Intent intento2 = new Intent(Activity2.this, Lista.class);
                intento2.putExtra("person", persona);
                intento2.putExtra("nuevaPos", pos);
                setResult(RESULT_OK, intento2);
                finish();
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
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
