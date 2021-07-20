package gal.teis.vacunas.classes;

import java.util.Objects;

public class Pais {

    private String codigo;
    private String nombre;


    //constructor
    public Pais(){
    }
    public Pais(String codigo, String nombre){
        this.codigo=codigo;
        this.nombre=nombre;
    }
    //Getters and Setters
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

    //Metodos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pais)) return false;
        Pais pais = (Pais) o;
        return Objects.equals(codigo, pais.codigo) && Objects.equals(nombre, pais.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre);
    }

    @Override
    public String toString() {
        return  " Codigo=+" + codigo +"\n"+
                " Nombre=" + nombre +"\n";
    }
}
