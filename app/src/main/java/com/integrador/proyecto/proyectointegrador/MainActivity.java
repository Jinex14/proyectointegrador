package com.integrador.proyecto.proyectointegrador;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Full Screen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        db = new MyDatabase(MainActivity.this);
        File database = getApplicationContext().getDatabasePath(MyDatabase.DBNAME);
        //Si la base de datos no existe

        if(false == database.exists()) {
            db.getReadableDatabase();

            //Copiar db
            if (copyDatabase(this)) {
                Toast.makeText(this, "Base de datos creada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al crear la base de datos", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    int ab=db.comprobarinicio();
                    if(ab==0){
                    Intent intent = new Intent(getApplicationContext(),Datos01Activity.class);
                    startActivity(intent);
                    finish();
                    }
                    else{
                        Intent intent = new Intent(getApplicationContext(),MenuPrincipalActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
         myThread.start();
    }



    private boolean copyDatabase(Context context) {
        try {

            InputStream inputStream = context.getAssets().open(MyDatabase.DBNAME);
            String outFileName = MyDatabase.DBLOCATION + MyDatabase.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
