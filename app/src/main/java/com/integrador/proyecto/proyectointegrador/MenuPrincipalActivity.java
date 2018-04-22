package com.integrador.proyecto.proyectointegrador;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuPrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private MyDatabase db;
    TextView calo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Full Screen
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //Base de datos
        db = new MyDatabase(MenuPrincipalActivity.this);
        //casteo de variables
        calo= (TextView) findViewById(R.id.lblcalo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Inicio de la programación
        ArrayList<avance> avance=db.listarAvance();
        String caloDia="";
        if(avance.get(avance.size()-1).getSex().equals("M")) {
            double aux=(10*avance.get(avance.size()-1).getPeso())+(6.25*avance.get(avance.size()-1).getTalla())-(5*avance.get(avance.size()-1).getEdad())+5;
          if(avance.get(avance.size()-1).getMeta()==2){
                double aux2 = aux - 400;
                caloDia = Math.round(aux2) + "";
            }else if (avance.get(avance.size()-1).getMeta()==0){
              double aux2 = aux + 300;
              caloDia = Math.round(aux2) + "";
          }else{
              caloDia =Math.round(aux)+"";
          }
        }else {
            double aux=(10*avance.get(avance.size()-1).getPeso())+(6.25*avance.get(avance.size()-1).getTalla())-(5*avance.get(avance.size()-1).getEdad())-161;
            if(avance.get(avance.size()-1).getMeta()==2){
                double aux2 = aux - 400;
                caloDia = Math.round(aux2) + "";
            }else if (avance.get(avance.size()-1).getMeta()==0){
                double aux2 = aux + 300;
                caloDia = Math.round(aux2) + "";
            }else{
                caloDia =Math.round(aux)+"";
            }
        }
        calo.setText(caloDia);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent a=new Intent(getApplicationContext(),escanearAlimento.class);
            startActivity(a);
        } else if (id == R.id.nav_gallery) {
            int num=0;
            Intent a=new Intent(getApplicationContext(),registro.class);
            a.putExtra("num",num);
            startActivity(a);
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
