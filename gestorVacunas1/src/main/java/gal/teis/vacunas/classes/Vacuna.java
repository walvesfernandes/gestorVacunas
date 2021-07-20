package gal.teis.vacunas.classes;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @version 0.1, 21/05/10
 * @author willianaf
 */
public class Vacuna extends VacunaAutorizacion {
    //Atributos

    private String codigo;
    private String nombre;
    private String principioActivo;
    private String farmaceutica;
    public double precioRecomendado;

    //Constructor
    public Vacuna() {
    }

    public Vacuna(String codigo, String nombre, String principioActivo, String farmaceutica, double precioRecomendado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.principioActivo = principioActivo;
        this.farmaceutica = farmaceutica;
        this.precioRecomendado = precioRecomendado;

    }

    //Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public String getFarmaceutica() {
        return farmaceutica;
    }

    public double getPrecioRecomendado() {
        return precioRecomendado;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    public void setFarmaceutica(String farmaceutica) {
        this.farmaceutica = farmaceutica;
    }

    public void setPrecioRecomendado(double precioRecomendado) {
        this.precioRecomendado = precioRecomendado;
    }


    public void setCodigo(String codigo) {
    this.codigo= codigo;
    }

    //Metodos
    /**
     * El metodo toString(); genera dos tipos de mensaje dependiendo si la
     * vacuna ha sido rechazada o autorizada
     *
     * @return String
     */
    @Override
    public String toString() {
        String resultado = "";

        if (getFase3Superada()) {

            resultado = " ************************************************************\n"
                      + " **  Datos de la vacuna:        \n"
                      + " **     Código:             " + codigo + "\n"
                      + " **     Nombre:             " + nombre + "\n"
                      + " **     P. activo:          " + principioActivo + "\n"
                      + " **     Farmaceutica:       " + farmaceutica + "\n"
                      + " **     Precio:             " + precioRecomendado + "€\n"
                      + " **     Fecha autorización: "+ getFechaResultado()+ "\n"
                      + " ************************************************************\n";

        }else{
            resultado = " ************************************************************\n"
                      + " **  Datos de la vacuna:        \n"
                      + " **     Código:        " + codigo + "\n"
                      + " **     Nombre:        " + nombre + "\n"
                      + " **     P. activo:     " + principioActivo + "\n"
                      + " ************************************************************\n";

        }

        return resultado;

    }

    /**
     * El metodo getNumeroRandom(); genera el numero random con minimo y maximo.
     *
     * @param min minimo y max maximo
     * @return int
     */
    private static int getNumeroRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    @Override
    public boolean autorizar() {
        return false;
    }

    @Override
    public boolean rechazar() {
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.codigo);
        hash = 53 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vacuna other = (Vacuna) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

}
