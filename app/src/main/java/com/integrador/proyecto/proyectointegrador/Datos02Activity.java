package com.integrador.proyecto.proyectointegrador;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;


public class Datos02Activity extends AppCompatActivity {

    Button boton;
    EditText talla,peso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Full Screen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.datos02);


        talla= (EditText) findViewById(R.id.txtTalla);
        peso= (EditText) findViewById(R.id.txtPeso);
        boton= (Button) findViewById(R.id.button2);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras=getIntent().getExtras();
                String sex=extras.getString("sex");
                int ed=extras.getInt("edad");
                int tal=Integer.parseInt(talla.getText().toString());
                double pes=Double.parseDouble(peso.getText().toString());
                Intent a=new Intent(getApplicationContext(),MetasActivity.class);
                a.putExtra("sex",sex);
                a.putExtra("edad",ed);
                a.putExtra("talla",tal);
                a.putExtra("peso",pes);
                startActivity(a);
            }
        });
    }
}
