package com.integrador.proyecto.proyectointegrador;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;


public class MetasActivity extends AppCompatActivity {

    private MyDatabase db;
    RadioGroup rg;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Full Screen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.metas);
        boton= (Button) findViewById(R.id.buttonlounch);
        rg= (RadioGroup) findViewById(R.id.rgMetas);
        db = new MyDatabase(MetasActivity.this);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras=getIntent().getExtras();
                String sex=extras.getString("sex");
                int ed=extras.getInt("edad");
                int tal=extras.getInt("talla");
                double peso=extras.getDouble("peso");
                int meta=0;

                if(rg.getCheckedRadioButtonId()==R.id.rbGM) meta=0;
                if(rg.getCheckedRadioButtonId()==R.id.rbMP) meta=1;
                if(rg.getCheckedRadioButtonId()==R.id.rbPG) meta=2;

                Time t=new Time(Time.getCurrentTimezone());
                t.setToNow();
                int dia=t.monthDay;
                int mes=t.month;
                int ano=t.year;
                String fecha=dia+"/"+mes+"/"+ano;

                Log.e("sex",sex);
                Log.e("ed",ed+"");
                Log.e("tal",tal+"");
                Log.e("peso",peso+"");
                Log.e("meta",meta+"");
                Log.e("fecha",fecha);

                    db.insertarAvance(sex, tal, ed, peso, meta, fecha);




                Intent a = new Intent(getApplicationContext(),MenuPrincipalActivity.class);
                startActivity(a);

            }
        });
    }
}
