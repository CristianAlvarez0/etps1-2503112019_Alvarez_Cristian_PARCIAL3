package com.example.alvarezcristianparcial3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alvarezcristianparcial3.Helper.AdminSQLiteOpenHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    EditText txtedtNom,txtedtApe,txtedtTel,txtCor;
    Button btnInsert,btnUpdate,btnDelete;



    BottomNavigationView btnNavega;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtedtNom=findViewById(R.id.edtNombre);
        txtedtApe=findViewById(R.id.edtApellido);
        txtedtTel=findViewById(R.id.edtTelefono);
        txtCor=findViewById(R.id.edtCorreo);

        btnInsert=findViewById(R.id.btnInsertar);
        btnUpdate=findViewById(R.id.btnActualizar);
        btnDelete=findViewById(R.id.btnEliminar);



        btnNavega=findViewById(R.id.btnNav);
        btnNavega.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) navaListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navaListener= new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
           // Fragment seleccionFrag= null;

            switch (item.getItemId()) {
                case R.id.btnInsertar:
                    btnInsert.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "bodega",null,2);

                            SQLiteDatabase bd= admin.getWritableDatabase();
                            String nom=txtedtNom.getText().toString();
                            String ape=txtedtApe.getText().toString();
                            String tel=txtedtTel.getText().toString();
                            String corr=txtedtTel.getText().toString();

                            ContentValues informacion = new ContentValues();
                            informacion.put("nombre",nom);
                            informacion.put("apellido",ape);
                            informacion.put("telefono",tel);
                            informacion.put("correo",corr);

                            try {
                                bd.insert("productos", null, informacion);

                                Toast.makeText(getApplicationContext(), "Se inserto el producto", Toast.LENGTH_LONG).show();
                                bd.close();

                            } catch (Exception e){
                                //pendiente imprimir error
                                Toast.makeText(getApplicationContext(), ""+e.getCause(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });


                    return true;
                case R.id.btnActualizar:
                    // Lógica para la opción "Borrar"
                    return true;
                case R.id.btnEliminar:
                    // Lógica para la opción "Actualizar"
                    return true;
                default:
                    return false;
            }




           // getSupportFragmentManager().beginTransaction().replace(R.id.fragmentCont, seleccionFrag).commit();
            //return true;

        }

    };
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.boton_navegator,menu);
        return true ;

    }
    public boolean onOptionsItemSelected(MenuItem items){



        switch (items.getItemId()){

            case R.id.nav_editar:
                Toast.makeText(this,"Selecciono Guardar",Toast.LENGTH_SHORT).show();

                return true;
            case R.id.nav_guardar:
                Toast.makeText(this,"Selecciono la guardar",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_busqNom:

                Toast.makeText(this,"Selecciono buscar nombre",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.nav_busqApe:
                Toast.makeText(this,"Selecciono buscar apellido",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.nav_busqTel:
                Toast.makeText(this,"Selecciono buscar telefono",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.nav_busqCor:
                Toast.makeText(this,"Selecciono buscar correo",Toast.LENGTH_SHORT).show();
                return true;


        }

        return super.onOptionsItemSelected(items);
    }



}