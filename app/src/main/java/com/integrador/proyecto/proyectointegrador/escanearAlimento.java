package com.integrador.proyecto.proyectointegrador;


import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;


import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;


import android.widget.Button;
import android.widget.EditText;

import android.widget.ListView;


import android.widget.Toast;


import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


import java.util.ArrayList;

public class escanearAlimento extends AppCompatActivity {

    Button button,button2;
    EditText view;
    private MyDatabase db;
    ListView listView;
    FloatingActionButton nuevaB,nuevaC;
    ListViewAdapter adaptador;
    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1 ;
    private static final int MY_PERMISSIONS_REQUEST_CAMERA= 2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escanear_alimento);

        listView= (ListView) findViewById(R.id.listView);
        view = (EditText) findViewById(R.id.view);
        db = new MyDatabase(escanearAlimento.this);
        button2= (Button) findViewById(R.id.button2);
        button= (Button) findViewById(R.id.btnBuscar);

        nuevaB= (FloatingActionButton) findViewById(R.id.floatB);


        nuevaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(getApplicationContext(),registro.class);
                startActivity(a);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Buscar();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText("");
                view.setEnabled(true);
                button.setEnabled(true);
                cargaralimento();
            }
        });




            cargaralimento();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Alimento b=(Alimento)listView.getItemAtPosition(position);
                int num=1;
                String as[]={b.getId()+"",b.getCodigo(),b.getNombre(),b.getUnidad(),b.getCantidad()+"",
                        b.getCalorias()+"",b.getCarbohidratos()+"",b.getProteinas()+"",b.getGrasas()+"",
                        b.getAzucar()+"",b.getFibra()+"",b.getGSaturada()+"",b.getGPolisaturada()+"",
                        b.getGMonoinsaturada()+"",b.getGTrans()+"",b.getColesterol()+"",b.getSodio()+"",
                        b.getPotasio()+"",b.getVA()+"",b.getVC()+"",b.getCalcio()+"",b.getHierro()+""};



                Intent a=new Intent(getApplicationContext(),registro.class);
                a.putExtra("datos",as);
                a.putExtra("num",num);
                startActivity(a);


            }
        });

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int permissionCheck2 = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);

            }
        }
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {

            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);

            }
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {

                }
                return;
            } case MY_PERMISSIONS_REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {

                }
                return;
            }
        }
    }

    public void Escaner(View view){
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setPrompt("Scan");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();
    }

    public void cargaralimento(){
        ArrayList<Alimento> item=new ArrayList<Alimento>();

        item=db.listarAlimentos();

        adaptador= new ListViewAdapter(this,item);
        listView.setAdapter(adaptador);
    }



    public void Buscar(){
        ArrayList<Alimento> item=new ArrayList<Alimento>();

        item=db.BuscarAlimentos(view.getText().toString());

        adaptador= new ListViewAdapter(this,item);
        listView.setAdapter(adaptador);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents()==null){
                Toast.makeText(this, "Se canceló el escaneo", Toast.LENGTH_LONG).show();
            }
            else {
                view.setText(result.getContents().toString());
                view.setEnabled(false);

                //Inicio del cuadro de dialogo
                Boolean aux=db.verificarCodigo(result.getContents().toString());
                if(aux==false) {
                    final String codigo=result.getContents().toString();
                    final int num=0;
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setCancelable(true);
                    builder.setTitle("Codigo no registrado");
                    builder.setMessage("El codigó " + result.getContents().toString() + " no esta registrado en la Base de Datos. ¿Desea agregar el producto?");
                    builder.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent a= new Intent(getApplicationContext(), registro.class);
                            a.putExtra("cod",codigo);
                            a.putExtra("num",num);
                            startActivity(a);

                        }
                    });
                    builder.setNegativeButton("Cancelar", null);
                    Dialog dialog = builder.create();
                    dialog.show();
                }else{
                    button.setEnabled(false);
                    ArrayList<Alimento> item=new ArrayList<Alimento>();

                    item=db.BuscarAlimentosC(result.getContents().toString());
                    adaptador= new ListViewAdapter(this,item);
                    listView.setAdapter(adaptador);
                }

                //Fin del cuadro

            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}
