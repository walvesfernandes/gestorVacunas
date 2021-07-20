package gal.teis.vacunas.collections;

import gal.teis.vacunas.classes.Pais;

import java.util.*;

public class ConjuntoPaises {


    Set<Pais> conjuntoPaises = new HashSet<Pais>();

    public Set<Pais> getAlmacen() {
        return conjuntoPaises;
    }


    public ConjuntoPaises (){
    }


    //Metodos
    public void agregar(Pais pais){
            conjuntoPaises.add(pais);

    }

    public void agregarCinco(boolean si){
        Pais p1=new Pais("34","españa");
        Pais p2=new Pais("213","alaska");
        Pais p3=new Pais("49","alemania");
        Pais p4=new Pais("61","andorra");
        Pais p5=new Pais("54","argentina");
        conjuntoPaises.add(p1);
        conjuntoPaises.add(p2);
        conjuntoPaises.add(p3);
        conjuntoPaises.add(p4);
        conjuntoPaises.add(p5);
    }

    public boolean buscarNombre(Pais paisOb, String nombre){
        boolean acierto= false;

        if(paisOb.getNombre().equals(nombre)) {
            acierto = true;
        }

        return acierto;

    }
    //Si encontra es true
    public boolean buscar(Pais pais){
        boolean bingo=false;

        for (Pais e: conjuntoPaises) {
            if(conjuntoPaises.contains(pais)){
                bingo=true;
            }
        }
        return bingo;

    }
    public String listar(){
    String cadena="";

        for (Pais e: conjuntoPaises) {
            cadena += e.toString()+"\n";
        }
        return cadena;
    }

    @Override
    public String toString() {
        return "ConjuntoPaises{" +
                "conjuntoPaises=" + conjuntoPaises +
                '}';
    }
}
