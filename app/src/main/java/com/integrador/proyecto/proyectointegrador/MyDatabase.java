package com.integrador.proyecto.proyectointegrador;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


/**
 * Created by Jinex on 28/03/2017.
 */
public class MyDatabase extends SQLiteOpenHelper {

    public static final String DBNAME = "integrador.db";
    public static final String DBLOCATION = "/data/data/com.integrador.proyecto.proyectointegrador/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public MyDatabase(Context context) {
        super(context, DBNAME, null, 1);
        this.mContext = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if(mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if(mDatabase!=null) {
            mDatabase.close();
        }
    }

    public void insertarAvance(String sex, int talla, int edad,double peso,int meta,String fecha){
        openDatabase();
        String sql="insert into avance(_id,sexo,talla,edad,peso,meta,fechaini) values(null,'"+sex+"',"+talla+","+edad+","+peso+","+meta+",'"+fecha+"');";
        // Log.d("sentencia", sql);
        try {
            //     mDatabase.rawQuery("insert into avance(_id,sexo,talla,edad,peso,meta,fechaini) values(null,+sex+","+talla+","+edad+","+peso+","+meta+","+fecha+");";, null);
            mDatabase.execSQL(sql);

        }catch (Exception e){
            Log.e("error data",e+"");
        }
        closeDatabase();
    }

    public ArrayList<avance> listarAvance() throws SQLException{
        avance a=null;
        ArrayList<avance> item= new ArrayList<avance>();
        openDatabase();
        Cursor cursor=null;
        cursor = mDatabase.rawQuery("SELECT * FROM AVANCE", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            a=new avance(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getInt(3),cursor.getDouble(4),cursor.getInt(5),cursor.getString(6));
            item.add(a);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return item;
    }

    public int comprobarinicio() throws SQLException{
        int ab=0;
        openDatabase();
        Cursor cursor=null;
        cursor = mDatabase.rawQuery("SELECT * FROM avance", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
           ab++;
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        Log.e("VALOR DE AB","ab vale: "+ab);
        return ab;
    }


    public ArrayList<Alimento> listarAlimentos() throws SQLException{
        Alimento a=null;
        ArrayList<Alimento> item= new ArrayList<Alimento>();
        openDatabase();
        Cursor cursor=null;
        cursor = mDatabase.rawQuery("SELECT * FROM ALIMENTOS", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            a=new Alimento(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getDouble(4),cursor.getDouble(5),cursor.getDouble(6),cursor.getDouble(7),cursor.getDouble(8),cursor.getDouble(9),cursor.getDouble(10),cursor.getDouble(11),cursor.getDouble(12),cursor.getDouble(13),cursor.getDouble(14),cursor.getDouble(15),cursor.getDouble(16),cursor.getDouble(17),cursor.getDouble(18),cursor.getDouble(19),cursor.getDouble(20),cursor.getDouble(21));
            item.add(a);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return item;
    }

    public ArrayList<Alimento>BuscarAlimentos(String ab) throws SQLException{
        Alimento a=null;
        ArrayList<Alimento> item= new ArrayList<Alimento>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM ALIMENTOS where nombre like '%"+ab+"%';", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            a=new Alimento(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getDouble(4),cursor.getDouble(5),cursor.getDouble(6),cursor.getDouble(7),cursor.getDouble(8),cursor.getDouble(9),cursor.getDouble(10),cursor.getDouble(11),cursor.getDouble(12),cursor.getDouble(13),cursor.getDouble(14),cursor.getDouble(15),cursor.getDouble(16),cursor.getDouble(17),cursor.getDouble(18),cursor.getDouble(19),cursor.getDouble(20),cursor.getDouble(21));
            item.add(a);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return item;
    }

    public void insertarAlimento(Alimento a){
        openDatabase();
        String sql="insert into Alimentos(_id, codigo,nombre,unidad,cantidad,calorias,carbohidratos,proteinas,grasas,Azucar,fibra,GrasaSaturada,GrasaPolisaturada,GrasaMonoinsaturada,GrasaTrans,Colesterol,Sodio,Potasio,VitaminaA,VitaminaC,Calcio,Hierro) "
                + "VALUES(null,'" + a.getCodigo() + "','" + a.getNombre() + "','" + a.getUnidad() + "'," + a.getCantidad() + "," + a.getCalorias() + "," + a.getCarbohidratos() + "," + a.getProteinas() + "," + a.getGrasas() + "," + a.getAzucar() + "," + a.getFibra() + "," + a.getGSaturada() + "," + a.getGPolisaturada() + "," + a.getGMonoinsaturada() + "," + a.getGTrans() + "," + a.getColesterol() + "," + a.getSodio() + "," + a.getPotasio() + "," + a.getVA() + "," + a.getVC() + "," + a.getCalcio() + "," + a.getHierro() + ");";
        Log.d("sentencia", sql);
        try {
            //       mDatabase.rawQuery("insert into Alimentos(_id, codigo,nombre,unidad,cantidad,calorias,carbohidratos,proteinas,grasas,Azucar,fibra,GrasaSaturada,GrasaPolisaturada,GrasaMonoinsaturada,GrasaTrans,Colesterol,Sodio,Potasio,VitaminaA,VitaminaC,Calcio,Hierro) "
            //              + "VALUES(null,'" + a.getCodigo() + "','" + a.getNombre() + "','" + a.getUnidad() + "'," + a.getCantidad() + "," + a.getCalorias() + "," + a.getCarbohidratos() + "," + a.getProteinas() + "," + a.getGrasas() + "," + a.getAzucar() + "," + a.getFibra() + "," + a.getGSaturada() + "," + a.getGPolisaturada() + "," + a.getGMonoinsaturada() + "," + a.getGTrans() + "," + a.getColesterol() + "," + a.getSodio() + "," + a.getPotasio() + "," + a.getVA() + "," + a.getVC() + "," + a.getCalcio() + "," + a.getHierro() + ");", null);
            mDatabase.execSQL(sql);

        }catch (Exception e){
        }
        closeDatabase();
    }

    public Boolean verificarCodigo(String a){
        Boolean resultado=false;
        ArrayList<Alimento> item= new ArrayList<Alimento>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM ALIMENTOS where codigo='"+a+"';", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            resultado=true;
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return resultado;
    }

    public ArrayList<Alimento>BuscarAlimentosC(String ab) throws SQLException{
        Alimento a=null;
        ArrayList<Alimento> item= new ArrayList<Alimento>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM ALIMENTOS where codigo='"+ab+"';", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            a=new Alimento(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getDouble(4),cursor.getDouble(5),cursor.getDouble(6),cursor.getDouble(7),cursor.getDouble(8),cursor.getDouble(9),cursor.getDouble(10),cursor.getDouble(11),cursor.getDouble(12),cursor.getDouble(13),cursor.getDouble(14),cursor.getDouble(15),cursor.getDouble(16),cursor.getDouble(17),cursor.getDouble(18),cursor.getDouble(19),cursor.getDouble(20),cursor.getDouble(21));
            item.add(a);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return item;
    }

    public void editarAlimento(Alimento a){
        openDatabase();
        String sql="UPDATE Alimentos SET _id=_id, codigo='" + a.getCodigo() + "', nombre ='" + a.getNombre() + "', unidad ='" + a.getUnidad() + "', cantidad =" + a.getCantidad() + ", calorias =" + a.getCalorias() + ", carbohidratos =" + a.getCarbohidratos() + ", proteinas =" + a.getProteinas() + ", grasas =" + a.getGrasas() + ", Azucar =" + a.getAzucar() + ", fibra =" + a.getFibra() + ", GrasaSaturada =" + a.getGSaturada() + ", GrasaPolisaturada =" + a.getGPolisaturada() + ", GrasaMonoinsaturada =" + a.getGMonoinsaturada() + ", GrasaTrans =" + a.getGTrans() + ", Colesterol =" + a.getColesterol() + ", Sodio =" + a.getSodio() + ", Potasio =" + a.getPotasio() + ", VitaminaA =" + a.getVA() + ", VitaminaC =" + a.getVC() + ", Calcio =" + a.getCalcio() + ", Hierro =" + a.getHierro() + " where _id="+a.getId()+";";
        Log.d("sentencia", sql);
        try {
            mDatabase.execSQL(sql);

        }catch (Exception e){

        }
        closeDatabase();
    }

    public void eliminarAlimento(int a){
        openDatabase();
        String sql="delete from Alimentos where _id="+a+";";
        Log.d("sentencia", sql);
        try {
            mDatabase.execSQL(sql);

        }catch (Exception e){

        }
        closeDatabase();
    }
}

