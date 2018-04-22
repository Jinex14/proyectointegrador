package com.integrador.proyecto.proyectointegrador;

/**
 * Created by POST on 15/05/2017.
 */
public class avance {
    private int id;
    private String sex;
    private int talla;
    private int edad;
    private double peso;
    private int meta;
    private String fecha;

    public avance(int id, String sex, int talla, int edad, double peso, int meta, String fecha) {
        this.id = id;
        this.sex = sex;
        this.talla = talla;
        this.edad = edad;
        this.peso = peso;
        this.meta = meta;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
