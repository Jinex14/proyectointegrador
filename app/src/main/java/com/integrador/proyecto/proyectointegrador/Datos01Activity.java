package com.integrador.proyecto.proyectointegrador;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;


public class Datos01Activity extends AppCompatActivity {

    Button boton;
    RadioGroup rg;
    EditText edad;
    String sex;
    int ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Full Screen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.datos01);

        rg= (RadioGroup) findViewById(R.id.rgDatos01);
        boton= (Button) findViewById(R.id.button);
        edad= (EditText) findViewById(R.id.txtEdad);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rg.getCheckedRadioButtonId()==R.id.rbMasculino) sex="M";
                if(rg.getCheckedRadioButtonId()==R.id.rbFemenino) sex="F";
                ed=Integer.parseInt(edad.getText().toString());

                Intent a =new Intent(getApplicationContext(),Datos02Activity.class);
                a.putExtra("sex",sex);
                a.putExtra("edad",ed);
                startActivity(a);
            }
        });
    }
}
