package gal.teis.vacunas.classes;

import gal.teis.vacunas.interfaces.IAutorizable;

import java.time.LocalDate;

/**
 * VacunaAutorizacion es una Class abstracta que implementa la interfaz
 * IAutorizable que contine los metodos Autorizar(); y Rechazar();
 *
 * @version 0.1, 21/05/10
 * @author willianaf
 */
public abstract class VacunaAutorizacion implements IAutorizable {

    //Atributos
    private boolean autorizada;

    private boolean rechazada;
    private boolean fase1Superada;
    private boolean fase2Superada;
    private boolean fase3Superada;
    private byte fasesCompletadas;
    private LocalDate fechaResultado = LocalDate.now();

    //GETTERS
    public LocalDate getFechaResultado() {
        return fechaResultado;
    }

    public boolean getAutorizada() {
        return autorizada;
    }

    public boolean getRechazada() {
        return rechazada;
    }

    public boolean getFase1Superada() {
        return fase1Superada;
    }

    public boolean getFase2Superada() {
        return fase2Superada;
    }

    public boolean getFase3Superada() {
        return fase3Superada;
    }

    public byte getFasesCompletadas() {
        return fasesCompletadas;
    }

    //SETTERS
    public void setFase1Superada(int fase1Superada) {

        if (fase1Superada == 1) {
            this.fase1Superada = true;

        } else if (fase1Superada == 0) {
            this.fase1Superada = false;
        }
        this.fasesCompletadas++;
    }

    public void setFase2Superada(int fase2Superada) {

        if (fase2Superada == 1 && this.fase1Superada) {
            this.fase2Superada = true;

        } else if (fase2Superada == 0) {
            this.fase2Superada = false;
        }
        this.fasesCompletadas++;
    }

    public void setFase3Superada(int fase3Superada) {

        if (fase3Superada == 1 && (this.fase2Superada && this.fase1Superada)) {
            this.fase3Superada = true;
        } else if (fase3Superada == 0) {
            this.fase3Superada = false;
        }
        this.fasesCompletadas++;
    }

    public void setFechaResultado(LocalDate fechaResultado) {
        this.fechaResultado = fechaResultado;
    }

    //METODOS
    /**
     * Devuelve un true o false si la vacuna ha superado las 3 fases con o sin
     * exito si alguna fase no se supera con exito autorizar automaticamente
     * devuelve un false que pasara a autorizada.
     *
     * @param opcion
     *
     * @return boolean
     */
    public boolean autorizar(byte opcion) {

        if(opcion < 2 && opcion > 0){
            this.autorizada = true;
        }

        return this.autorizada;
    }

    /**
     * Devuelve un true o false si la vacuna ha superado las 3 fases con o sin
     * exito si alguna fase no se supera con exito rechazar automaticamente
     * devuelve un true que pasara a rechazada.
     *
     * @param opcion
     *
     */
    public boolean rechazar(byte opcion) {

        if(opcion == 1){
            this.rechazada = true;
        }


        return this.rechazada;
    }
}
