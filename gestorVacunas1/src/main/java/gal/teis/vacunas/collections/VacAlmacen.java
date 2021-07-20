package gal.teis.vacunas.collections;

import gal.teis.vacunas.classes.Pais;
import gal.teis.vacunas.classes.Vacuna;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author willianaf
 */
public class VacAlmacen extends HashMap{


    //Constructor
    public VacAlmacen() {
        super();
    }




    //Metodos
public String crearCinco(){
        String cadena="";

        Vacuna v1= new Vacuna("VEiof45","Pfizer", "ARN","BioNTech,Fosun Pharma",17.0);
        Vacuna v2 = new Vacuna("VIfyf44","Moderna", " ARN","Moderna, NIAID",14.8);
        Vacuna v3 = new Vacuna("VEhlq8","Novavax", "ATC","Compañías farmacéuticas Janssen",4.4);
        Vacuna v4 = new Vacuna("VArtf46","AstraZeneca", "ATC","Universidad de Oxford",8.5);
        Vacuna v5 = new Vacuna("VEobn65","sputnik v", "rAd26 y rAd5","Sputnik",8.4);

        cadena= "Cinco modelos de vacuna\n"+
                v1.toString()+
                "Precio: "+v1.getPrecioRecomendado()+"Є\n"+
                v2.toString()+
                "Precio: "+v2.getPrecioRecomendado()+"Є\n"+
                v3.toString()+
                "Precio: "+v3.getPrecioRecomendado()+"Є\n"+
                v4.toString()+
                "Precio: "+v4.getPrecioRecomendado()+"Є\n"+
                v5.toString()+
                "Precio: "+v5.getPrecioRecomendado()+"Є\n";

        return cadena;
}



}
