package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.db.DbHelper;


public class MainActivity extends AppCompatActivity {
    Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCrear = findViewById(R.id.BtnCrear);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                if(db != null){
                    Toast.makeText(MainActivity.this,"BASE DE DATOS CREADA",Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(MainActivity.this,"ERROR AL CREAR LA BASE DE DATOS ",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
  public void siguiente(View view){
      Intent siguente = new Intent(this, SegundaActivity.class);
      startActivity(siguente);
  }

  public void Agenda(View view){
        Intent Agenda = new Intent(this, agendaActivity.class);
  }
   public boolean onCreateOptionsMenu(Menu menu){
       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.menu_principal,menu);
       return true;
   }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void nuevoRegistro(){
        Intent intent = new Intent(this, NuevaActivity.class);
        startActivity(intent);
    }


}