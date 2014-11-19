package com.example.frpinkl.pasardatosagenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);



        final EditText nombreActivity2 = (EditText)findViewById(R.id.nombreActivity2);
        final EditText telefonoActivity2 = (EditText)findViewById(R.id.telefonoActivity2);

        Intent intento = getIntent();
        final int posicionArray = intento.getExtras().getInt("posicion");
        nombreActivity2.setText(intento.getExtras().getString("nombrePersona"));
        telefonoActivity2.setText(intento.getExtras().getString("telefonoPersona"));

        //ahora el evento del botón
        final Button botonActivity2 = (Button)findViewById(R.id.botonActivity2);
        botonActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newNome = (((EditText) findViewById(R.id.nombreActivity2)).getText().toString());
                String newTelef = ((EditText) findViewById(R.id.telefonoActivity2)).getText().toString();

                Intent intento2 = new Intent(Activity2.this, Activity1.class);
                intento2.putExtra("nuevoNombre", newNome);
                intento2.putExtra("nuevoTelef", newTelef);
                intento2.putExtra("nuevaPos", posicionArray);
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
