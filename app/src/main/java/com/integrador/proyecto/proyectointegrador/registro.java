package com.integrador.proyecto.proyectointegrador;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;

public class registro extends AppCompatActivity {

    private MyDatabase db;
    EditText txtId,txtCod,txtNom,txtCanti,txtCalo,txtCarbohi,txtProte,txtGrasa,txtGrasaSatu,txtGrasaPoli,txtGrasaMono,txtGrasaTrans,txtColeste,txtAzucar,txtFibra,txtSodio,txtPotasio,txtCalcio,txtHierro,txtVitA,txtVitC;
    Button boton,botonEdit,botonElimi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        db = new MyDatabase(registro.this);
        db = new MyDatabase(this);


        final Bundle result=getIntent().getExtras();


        boton= (Button) findViewById(R.id.btnAceptar);
        botonEdit= (Button) findViewById(R.id.btnEditar);
        botonElimi= (Button) findViewById(R.id.btnEliminar);
        txtId= (EditText) findViewById(R.id.txtId);
        txtCod= (EditText) findViewById(R.id.txtCod);
        txtCod.setEnabled(false);

        txtNom= (EditText) findViewById(R.id.txtNom);
        txtCanti= (EditText) findViewById(R.id.txtCanti);
        txtCalo= (EditText) findViewById(R.id.txtCalo);
        txtCarbohi= (EditText) findViewById(R.id.txtCarbohi);
        txtProte= (EditText) findViewById(R.id.txtProte);
        txtGrasa= (EditText) findViewById(R.id.txtGrasa);
        txtGrasaSatu= (EditText) findViewById(R.id.txtGrasaSatu);
        txtGrasaPoli= (EditText) findViewById(R.id.txtGrasaPoli);
        txtGrasaMono= (EditText) findViewById(R.id.txtGrasaMono);
        txtGrasaTrans= (EditText) findViewById(R.id.txtGrasaTrans);
        txtColeste= (EditText) findViewById(R.id.txtColeste);
        txtAzucar= (EditText) findViewById(R.id.txtAzucar);
        txtFibra= (EditText) findViewById(R.id.txtFibra);
        txtSodio= (EditText) findViewById(R.id.txtSodio);
        txtPotasio= (EditText) findViewById(R.id.txtPotasio);
        txtCalcio= (EditText) findViewById(R.id.txtCalcio);
        txtHierro= (EditText) findViewById(R.id.txtHierro);
        txtVitA= (EditText) findViewById(R.id.txtVitA);
        txtVitC= (EditText) findViewById(R.id.txtVitC);

        final MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.spinner);
        spinner.setItems("gr", "ml", "u");

        botonEdit.setEnabled(false);
        botonElimi.setEnabled(false);

        if(result!=null){
            int num=result.getInt("num");
            if(num==0) {
                txtCod.setText(result.getString("cod"));
                boton.setEnabled(true);
                botonEdit.setEnabled(false);
                botonElimi.setEnabled(false);
            }else if(num==1){
                String q[]=result.getStringArray("datos");
                txtId.setText(q[0]);
                txtCod.setText(q[1]);
                txtNom.setText(q[2]);
                if(q[3].equals("gr")) {
                    spinner.setSelectedIndex(0);
                }else if(q[3].equals("ml")){
                    spinner.setSelectedIndex(1);
                }else{
                    spinner.setSelectedIndex(2);
                }
                txtCanti.setText(q[4]);
                txtCalo.setText(q[5]);
                txtCarbohi.setText(q[6]);
                txtProte.setText(q[7]);
                txtGrasa.setText(q[8]);
                txtAzucar.setText(q[9]);
                txtFibra.setText(q[10]);
                txtGrasaSatu.setText(q[11]);
                txtGrasaPoli.setText(q[12]);
                txtGrasaMono.setText(q[13]);
                txtGrasaTrans.setText(q[14]);
                txtColeste.setText(q[15]);
                txtSodio.setText(q[16]);
                txtPotasio.setText(q[17]);
                txtVitA.setText(q[18]);
                txtVitC.setText(q[19]);
                txtCalcio.setText(q[20]);
                txtHierro.setText(q[21]);



                boton.setEnabled(false);
                botonEdit.setEnabled(true);
                botonElimi.setEnabled(true);
            }else {
                boton.setEnabled(true);
                botonEdit.setEnabled(false);
                botonElimi.setEnabled(false);
            }
        }



        botonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtCanti.getText().toString().equals("")){txtCanti.setText("0.00");}else {}
                if(txtCanti.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtCanti.getText().toString(); txtCanti.setText(e);}else {}
                if(txtCalo.getText().toString().equals("")){txtCalo.setText("0.00");}else {}
                if(txtCalo.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtCalo.getText().toString(); txtCalo.setText(e);}else {}
                if(txtCarbohi.getText().toString().equals("")){txtCarbohi.setText("0.00");}else {}
                if(txtCarbohi.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtCarbohi.getText().toString(); txtCarbohi.setText(e);}else {}
                if(txtProte.getText().toString().equals("")){txtProte.setText("0.00");}else {}
                if(txtProte.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtProte.getText().toString(); txtProte.setText(e);}else {}
                if(txtGrasa.getText().toString().equals("")){txtGrasa.setText("0.00");}else {}
                if(txtGrasa.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtGrasa.getText().toString(); txtGrasa.setText(e);}else {}
                if(txtAzucar.getText().toString().equals("")){txtAzucar.setText("0.00");}else {}
                if(txtAzucar.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtAzucar.getText().toString(); txtAzucar.setText(e);}else {}
                if(txtFibra.getText().toString().equals("")){txtFibra.setText("0.00");}else {}
                if(txtFibra.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtFibra.getText().toString(); txtFibra.setText(e);}else {}
                if(txtGrasaSatu.getText().toString().equals("")){txtGrasaSatu.setText("0.00");}else {}
                if(txtGrasaSatu.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtGrasaSatu.getText().toString(); txtGrasaSatu.setText(e);}else {}
                if(txtGrasaPoli.getText().toString().equals("")){txtGrasaPoli.setText("0.00");}else {}
                if(txtGrasaPoli.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtGrasaPoli.getText().toString(); txtGrasaPoli.setText(e);}else {}
                if(txtGrasaMono.getText().toString().equals("")){txtGrasaMono.setText("0.00");}else {}
                if(txtGrasaMono.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtGrasaMono.getText().toString(); txtGrasaMono.setText(e);}else {}
                if(txtGrasaTrans.getText().toString().equals("")){txtGrasaTrans.setText("0.00");}else {}
                if(txtGrasaTrans.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtGrasaTrans.getText().toString(); txtGrasaTrans.setText(e);}else {}
                if(txtColeste.getText().toString().equals("")){txtColeste.setText("0.00");}else {}
                if(txtColeste.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtColeste.getText().toString(); txtColeste.setText(e);}else {}
                if(txtSodio.getText().toString().equals("")){txtSodio.setText("0.00");}else {}
                if(txtSodio.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtSodio.getText().toString(); txtSodio.setText(e);}else {}
                if(txtPotasio.getText().toString().equals("")){txtPotasio.setText("0.00");}else {}
                if(txtPotasio.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtPotasio.getText().toString(); txtPotasio.setText(e);}else {}
                if(txtVitA.getText().toString().equals("")){txtVitA.setText("0.00");}else {}
                if(txtVitA.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtCanti.getText().toString(); txtVitA.setText(e);}else {}
                if(txtVitC.getText().toString().equals("")){txtVitC.setText("0.00");}else {}
                if(txtVitC.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtVitC.getText().toString(); txtVitC.setText(e);}else {}
                if(txtCalcio.getText().toString().equals("")){txtCalcio.setText("0.00");}else {}
                if(txtCalcio.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtCalcio.getText().toString(); txtCalcio.setText(e);}else {}
                if(txtHierro.getText().toString().equals("")){txtHierro.setText("0.00");}else {}
                if(txtHierro.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtHierro.getText().toString(); txtHierro.setText(e);}else {}

                Alimento as = new Alimento(Integer.parseInt(txtId.getText().toString()), txtCod.getText().toString(), txtNom.getText().toString(), spinner.getText().toString(), Double.parseDouble(txtCanti.getText().toString()), Double.parseDouble(txtCalo.getText().toString()), Double.parseDouble(txtCarbohi.getText().toString()), Double.parseDouble(txtProte.getText().toString()), Double.parseDouble(txtGrasa.getText().toString()),
                        Double.parseDouble(txtAzucar.getText().toString()), Double.parseDouble(txtFibra.getText().toString()), Double.parseDouble(txtGrasaSatu.getText().toString()), Double.parseDouble(txtGrasaPoli.getText().toString()),
                        Double.parseDouble(txtGrasaMono.getText().toString()), Double.parseDouble(txtGrasaTrans.getText().toString()), Double.parseDouble(txtColeste.getText().toString()), Double.parseDouble(txtSodio.getText().toString()),
                        Double.parseDouble(txtPotasio.getText().toString()), Double.parseDouble(txtVitA.getText().toString()), Double.parseDouble(txtVitC.getText().toString()), Double.parseDouble(txtCalcio.getText().toString()), Double.parseDouble(txtHierro.getText().toString()));

                db.editarAlimento(as);
                Toast.makeText(getApplicationContext(), "Alimento Editado", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
                startActivity(a);


            }
        });

        botonElimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.eliminarAlimento(Integer.parseInt(txtId.getText().toString()));
                Toast.makeText(getApplicationContext(), "Alimento Eliminado", Toast.LENGTH_SHORT).show();
                Intent a=new Intent(getApplicationContext(),MenuPrincipalActivity.class);
                startActivity(a);

            }
        });


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int aux=0;
                if(txtCanti.getText().toString().equals("")){txtCanti.setText("0.00");}else {}
                if(txtCanti.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtCanti.getText().toString(); txtCanti.setText(e);}else {}
                if(txtCalo.getText().toString().equals("")){txtCalo.setText("0.00");}else {}
                if(txtCalo.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtCalo.getText().toString(); txtCalo.setText(e);}else {}
                if(txtCarbohi.getText().toString().equals("")){txtCarbohi.setText("0.00");}else {}
                if(txtCarbohi.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtCarbohi.getText().toString(); txtCarbohi.setText(e);}else {}
                if(txtProte.getText().toString().equals("")){txtProte.setText("0.00");}else {}
                if(txtProte.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtProte.getText().toString(); txtProte.setText(e);}else {}
                if(txtGrasa.getText().toString().equals("")){txtGrasa.setText("0.00");}else {}
                if(txtGrasa.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtGrasa.getText().toString(); txtGrasa.setText(e);}else {}
                if(txtAzucar.getText().toString().equals("")){txtAzucar.setText("0.00");}else {}
                if(txtAzucar.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtAzucar.getText().toString(); txtAzucar.setText(e);}else {}
                if(txtFibra.getText().toString().equals("")){txtFibra.setText("0.00");}else {}
                if(txtFibra.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtFibra.getText().toString(); txtFibra.setText(e);}else {}
                if(txtGrasaSatu.getText().toString().equals("")){txtGrasaSatu.setText("0.00");}else {}
                if(txtGrasaSatu.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtGrasaSatu.getText().toString(); txtGrasaSatu.setText(e);}else {}
                if(txtGrasaPoli.getText().toString().equals("")){txtGrasaPoli.setText("0.00");}else {}
                if(txtGrasaPoli.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtGrasaPoli.getText().toString(); txtGrasaPoli.setText(e);}else {}
                if(txtGrasaMono.getText().toString().equals("")){txtGrasaMono.setText("0.00");}else {}
                if(txtGrasaMono.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtGrasaMono.getText().toString(); txtGrasaMono.setText(e);}else {}
                if(txtGrasaTrans.getText().toString().equals("")){txtGrasaTrans.setText("0.00");}else {}
                if(txtGrasaTrans.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtGrasaTrans.getText().toString(); txtGrasaTrans.setText(e);}else {}
                if(txtColeste.getText().toString().equals("")){txtColeste.setText("0.00");}else {}
                if(txtColeste.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtColeste.getText().toString(); txtColeste.setText(e);}else {}
                if(txtSodio.getText().toString().equals("")){txtSodio.setText("0.00");}else {}
                if(txtSodio.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtSodio.getText().toString(); txtSodio.setText(e);}else {}
                if(txtPotasio.getText().toString().equals("")){txtPotasio.setText("0.00");}else {}
                if(txtPotasio.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtPotasio.getText().toString(); txtPotasio.setText(e);}else {}
                if(txtVitA.getText().toString().equals("")){txtVitA.setText("0.00");}else {}
                if(txtVitA.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtCanti.getText().toString(); txtVitA.setText(e);}else {}
                if(txtVitC.getText().toString().equals("")){txtVitC.setText("0.00");}else {}
                if(txtVitC.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtVitC.getText().toString(); txtVitC.setText(e);}else {}
                if(txtCalcio.getText().toString().equals("")){txtCalcio.setText("0.00");}else {}
                if(txtCalcio.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtCalcio.getText().toString(); txtCalcio.setText(e);}else {}
                if(txtHierro.getText().toString().equals("")){txtHierro.setText("0.00");}else {}
                if(txtHierro.getText().toString().trim().substring(0,1).equals(".")){String e=0+txtHierro.getText().toString(); txtHierro.setText(e);}else {}




                Alimento as = new Alimento(aux, txtCod.getText().toString(), txtNom.getText().toString(), spinner.getText().toString(), Double.parseDouble(txtCanti.getText().toString()), Double.parseDouble(txtCalo.getText().toString()), Double.parseDouble(txtCarbohi.getText().toString()), Double.parseDouble(txtProte.getText().toString()), Double.parseDouble(txtGrasa.getText().toString()),
                        Double.parseDouble(txtAzucar.getText().toString()), Double.parseDouble(txtFibra.getText().toString()), Double.parseDouble(txtGrasaSatu.getText().toString()), Double.parseDouble(txtGrasaPoli.getText().toString()),
                        Double.parseDouble(txtGrasaMono.getText().toString()), Double.parseDouble(txtGrasaTrans.getText().toString()), Double.parseDouble(txtColeste.getText().toString()), Double.parseDouble(txtSodio.getText().toString()),
                        Double.parseDouble(txtPotasio.getText().toString()), Double.parseDouble(txtVitA.getText().toString()), Double.parseDouble(txtVitC.getText().toString()), Double.parseDouble(txtCalcio.getText().toString()), Double.parseDouble(txtHierro.getText().toString()));

                db.insertarAlimento(as);

                Toast.makeText(getApplicationContext(), "Alimento ingresado", Toast.LENGTH_SHORT).show();

                Intent af = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
                startActivity(af);


            }
        });
    }

    @Override
    public void onBackPressed()
    {
        Intent af = new Intent(getApplicationContext(), MenuPrincipalActivity.class);
        startActivity(af);
    }
}
