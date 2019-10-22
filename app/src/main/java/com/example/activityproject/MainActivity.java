package com.example.activityproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private TextView secondEvent;
    private EditText nameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        secondEvent = findViewById(R.id.secEvent);
        nameTxt = findViewById(R.id.nameText);
        /*
            Otra forma de llamar a un evento, con clases abstractas
        */
        secondEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Recordemos que el contexto sería ahora de la clase abstracta, debemos ajustarlo

                // Ahora vamos a usar un intent implícito, esto es, llamar a un activity de fuera
                // Si hay más de uno, nos mostrará una lista de selección
                Intent intent = new Intent(Intent.ACTION_SEND)
                        .setType("plain/text")
                        .putExtra(Intent.EXTRA_EMAIL, new String[]{"davidefn1991@gmail.com"})
                        .putExtra(Intent.EXTRA_SUBJECT, "MyApp")
                        .putExtra(Intent.EXTRA_TEXT, "Hola, este mensaje se envió desde un programa de prueba");
                if( intent.resolveActivity(getPackageManager()) != null ) {
                    startActivity(intent);
                    Log.i("msg", "Válido");
                }
            }
        });

    }

    // Una forma de llamar a un evento es desde el XML
    public void goSecAtivity(View view) {

        // Para los intent explícitos, esto es, llamar a una actividad dentro de la aplicación
        Intent secondIntent = new Intent(this, SecondActivity.class);


        // Los distintos parámetros que recoge la actividad: Clave y valor -> Su conjunto es un Bundle que se recoge en la actividad correspondiente
        secondIntent.putExtra("nombre", nameTxt.getText().toString());

        startActivity(secondIntent);
    }
}
