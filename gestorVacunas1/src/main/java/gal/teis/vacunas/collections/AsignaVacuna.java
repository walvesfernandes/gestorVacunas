package gal.teis.vacunas.collections;

import gal.teis.vacunas.classes.Pais;
import gal.teis.vacunas.classes.Vacuna;
import gal.teis.vacunas.interfaces.IGestionVacunasPais;

import java.util.Objects;

/**
 *
 * @author a20willianaf
 */
public class AsignaVacuna implements IGestionVacunasPais {

    private Vacuna laVacuna; //vacuna
    private Pais pais;
    private long asignadas; //numero de vacunas de un tipo asignadas
    
    //Constructor
    public AsignaVacuna(Vacuna laVacuna, Pais pais) {
        this.laVacuna = laVacuna;
        this.pais=pais;
    }
    //Getters
    public Vacuna getLaVacuna() {

        return laVacuna;
    }

    public String getNombrePais() {

        return pais.getNombre();
    }

    public long getAsignadas() {
        return asignadas;
    }

    
    //Metodos
    public void asignar(long numAsignadas){
        this.asignadas=numAsignadas;
    };
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.laVacuna.getCodigo());
        hash = 71 * hash + Objects.hashCode(this.pais.getNombre());
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
        final AsignaVacuna other = (AsignaVacuna) obj;
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        if (!Objects.equals(this.laVacuna.getCodigo(), other.laVacuna.getCodigo())) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
    return "Tipo de vacuna: "+this.laVacuna+"\n"
            +"Nombre del pais de asignación: "+this.pais.getNombre()+"\n"
            +"Cantidad asignada: "+this.getAsignadas();
        
    }
    
 
}
