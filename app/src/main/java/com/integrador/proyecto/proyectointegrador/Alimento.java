package com.integrador.proyecto.proyectointegrador;

/**
 * Created by Jinex on 29/03/2017.
 */
public class Alimento {
    private int id;
    private String codigo,nombre,unidad;
    private double cantidad,calorias,carbohidratos,proteinas,grasas,azucar,fibra,GSaturada,GPolisaturada,GMonoinsaturada,GTrans,Colesterol,Sodio,Potasio,VA,VC,Calcio,Hierro;

    public Alimento(int id, String codigo, String nombre, String unidad, double cantidad, double calorias, double carbohidratos, double proteinas, double grasas, double azucar, double fibra, double GSaturada, double GPolisaturada, double GMonoinsaturada, double GTrans, double colesterol, double sodio, double potasio, double VA, double VC, double calcio, double hierro) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.calorias = calorias;
        this.carbohidratos = carbohidratos;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.azucar = azucar;
        this.fibra = fibra;
        this.GSaturada = GSaturada;
        this.GPolisaturada = GPolisaturada;
        this.GMonoinsaturada = GMonoinsaturada;
        this.GTrans = GTrans;
        Colesterol = colesterol;
        Sodio = sodio;
        Potasio = potasio;
        this.VA = VA;
        this.VC = VC;
        Calcio = calcio;
        Hierro = hierro;
    }

    public Alimento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public double getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getGrasas() {
        return grasas;
    }

    public void setGrasas(double grasas) {
        this.grasas = grasas;
    }

    public double getAzucar() {
        return azucar;
    }

    public void setAzucar(double azucar) {
        this.azucar = azucar;
    }

    public double getFibra() {
        return fibra;
    }

    public void setFibra(double fibra) {
        this.fibra = fibra;
    }

    public double getGSaturada() {
        return GSaturada;
    }

    public void setGSaturada(double GSaturada) {
        this.GSaturada = GSaturada;
    }

    public double getGPolisaturada() {
        return GPolisaturada;
    }

    public void setGPolisaturada(double GPolisaturada) {
        this.GPolisaturada = GPolisaturada;
    }

    public double getGMonoinsaturada() {
        return GMonoinsaturada;
    }

    public void setGMonoinsaturada(double GMonoinsaturada) {
        this.GMonoinsaturada = GMonoinsaturada;
    }

    public double getGTrans() {
        return GTrans;
    }

    public void setGTrans(double GTrans) {
        this.GTrans = GTrans;
    }

    public double getColesterol() {
        return Colesterol;
    }

    public void setColesterol(double colesterol) {
        Colesterol = colesterol;
    }

    public double getSodio() {
        return Sodio;
    }

    public void setSodio(double sodio) {
        Sodio = sodio;
    }

    public double getPotasio() {
        return Potasio;
    }

    public void setPotasio(double potasio) {
        Potasio = potasio;
    }

    public double getVA() {
        return VA;
    }

    public void setVA(double VA) {
        this.VA = VA;
    }

    public double getVC() {
        return VC;
    }

    public void setVC(double VC) {
        this.VC = VC;
    }

    public double getCalcio() {
        return Calcio;
    }

    public void setCalcio(double calcio) {
        Calcio = calcio;
    }

    public double getHierro() {
        return Hierro;
    }

    public void setHierro(double hierro) {
        Hierro = hierro;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", Codigo=" + codigo +
                ", Nombre=" + nombre +
                ", Unidad=" + unidad +
                ", Cantidad=" + cantidad +
                ", Calorias=" + calorias +
                ", Carbohidratos=" + carbohidratos +
                ", Proteinas=" + proteinas +
                ", Grasas=" + grasas +
                ", Azucar=" + azucar +
                ", Fibra=" + fibra +
                ", Grasa Saturada=" + GSaturada +
                ", Grasa Polisaturada=" + GPolisaturada +
                ", Grasa Monoinsaturada=" + GMonoinsaturada +
                ", Grasa Trans=" + GTrans +
                ", Colesterol=" + Colesterol +
                ", Sodio=" + Sodio +
                ", Potasio=" + Potasio +
                ", Vitamina A=" + VA +
                ", Vitamina C=" + VC +
                ", Calcio=" + Calcio +
                ", Hierro=" + Hierro;
    }
}
