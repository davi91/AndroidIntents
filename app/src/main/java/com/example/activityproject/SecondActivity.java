package com.example.activityproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView backText;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        backText = findViewById(R.id.helloText);

        // La otra manera es implementar el click listener
        backText.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        userName = bundle.getString("nombre");
    }

    @Override
    public void onClick(View v) {

        // Ahora tenemos que diferenciar entre los objetos que han lanzado este evento
        int id = v.getId();

        // Recogemos en intent que nos invocó, y obtenemos los parámetros en un conjunto de valores


        if( id == R.id.helloText) {
            Toast.makeText(this,  "Hola " + userName, Toast.LENGTH_SHORT).show();
        }
    }
}
