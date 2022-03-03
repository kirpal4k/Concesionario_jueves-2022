package com.example.concesionario_jueves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText jetusuario,jetclave;
    Button jbtingresar,jbtregistrarse,jbtcancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        jetusuario=findViewById(R.id.etusuario);
        jetclave=findViewById(R.id.etclave);
        jbtingresar=findViewById(R.id.btingresar);
        jbtregistrarse=findViewById(R.id.btregistrarse);
        jbtcancelar=findViewById(R.id.btcancelar);

    }
    public void Registrarse(View view){

        Intent intregistrarse=new Intent(this,ClienteActivity.class);
        startActivity();
    }
}