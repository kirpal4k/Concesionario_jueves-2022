package com.example.concesionario_jueves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ClienteActivity extends AppCompatActivity {

    EditText jetidentificacion,jetnombre,jetusuario,jetclave1,jetclave2;
    TextView jtvactico;
    Button jbtguardar, jbtconsultar,jbtanular,jbtcancelar,jbtregresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);


        getSupportActionBar().hide();

        jetidentificacion=findViewById(R.id.etidentificacion);
        jetnombre=findViewById(R.id.etnombre);
        jetusuario=findViewById(R.id.etusuario);
        jetclave1=findViewById(R.id.etclave1);
        jetclave2=findViewById(R.id.etclave2);
        jtvactico=findViewById(R.id.tvactivo);
        jbtguardar=findViewById(R.id.btguardar);
        jbtconsultar=findViewById(R.id.btconsultar);
        jbtanular=findViewById(R.id.btanular);
        jbtcancelar=findViewById(R.id.btcancelar);
        jbtregresar=findViewById(R.id.btregresar);
    }

    public void Guardar(View view){

        String identificacion,nombre,usuario,clave1,clave2;
        identificacion=jetidentificacion.getText().toString();
        nombre=jetnombre.getText().toString();
        usuario=jetusuario.getText().toString();
        clave1=jetclave1.getText().toString();
        clave2=jetclave2.getText().toString();

        if (identificacion.isEmpty() || nombre.isEmpty() || usuario.isEmpty() || clave1.isEmpty() || clave2.isEmpty()){
            Toast.makeText(this, "Todos los datos son requeridos", Toast.LENGTH_SHORT).show();
            jetidentificacion.requestFocus();

        }
        else{
            if (clave1.equals(clave2)){
                Toast.makeText(this, "Las claves no coinciden", Toast.LENGTH_SHORT).show();
                jetclave1.requestFocus();

            }

            else {
                Conexion_concesionario admin=new Conexion_concesionario(this,"concesionario.bd",null,1);
                SQLiteDatabase db=admin.getReadableDatabase();
                ContentValues dato=new ContentValues();
                dato.put("Identificacion",identificacion);
                dato.put("nombre",nombre);
                dato.put("usuario",usuario);
                dato.put("clave",clave2);

                db.close();
            }

        }

    }
}