package gal.teis.vacunas.resources;

import gal.teis.vacunas.classes.Vacuna;

/**
 * Gestion algunos textos del gestor de vacunas
 * @version 0.1
 * @author willianaf
 */
public class Textos {
    
    public static String titulo(){
    String titulo =" ************************************************************\n"+
                   " **                                                        **\n"+
                   " **        Gestor de vacunas contra el COVID-19            **\n"+
                   " **                                                        **\n"+
                   " ************************************************************\n";
    
    return titulo;
    }
    
    public static String pendientes(){
    String pendientes =" ************************************************************\n"+
                       " **                                                        **\n"+
                       " **                    Vacunas pediente                    **\n"+
                       " **                                                        **\n"+
                       " ************************************************************\n";
    
    return pendientes;
    }

    public static String modVacuna(){
        String modVacuna =" ************************************************************\n"+
                          " **                                                        **\n"+
                          " **                Cual dato quieres modificar?            **\n"+
                          " **      1.-Nombre 2.-Farmaceutica 3.-P.Activo 4.-Precio   **\n"+
                          " ************************************************************\n";

        return modVacuna;
    }

    public static String textoCodigo(){
        String textoCodigo =" ****************************************************************************\n"+
                            " **                                                                        **\n"+
                            " **                           Reglas del codigo:                           **\n"+
                            " **      ºDebe iniciar con la letra V seguida de una vocal en mayúscula.   **\n"+
                            " **      ºA continuación, tres o cuatro letras minúsculas.                 **\n"+
                            " **      ºFinaliza, o con dos números del 4 al 7, o bien con el número 8.  **\n"+
                            " ****************************************************************************\n";

        return textoCodigo;
    }
     public static String asignadas(){
    String asignadas =" ************************************************************\n"+
                    " **                                                        **\n"+
                    " **             Vacunas asignadas a un pais                **\n"+
                    " **                                                        **\n"+
                    " ************************************************************\n";
    
    return asignadas;
    }
    
    public static String vacunas(String tipo){
    String vacunas =" ************************************************************\n"+
                    " **                                                        **\n"+
                    " **                   Vacunas "+tipo+"                  **\n"+
                    " **                                                        **\n"+
                    " ************************************************************\n";
    
    return vacunas;
    }
    public static String busca() {
        String busca = " ************************************************************\n"
                     + " **                                                        **\n"
                     + " **                    Buscar vacuna por:                  **\n"
                     + " **             1.-Codigo 2.-Nombre 3.-Estado              **\n"
                     + " ************************************************************\n";

        return busca;
    }
    public static String seleccion() {
        String seleccion = " ************************************************************\n"
                         + " **                                                        **\n"
                         + " **                  Seleccione vacuna                     **\n"
                         + " **          Introduzca el codigo de la vacuna:            **\n"
                         + " **                                                        **\n"
                         + " ************************************************************\n";

        return seleccion;
    }
      public static String eliminar(){
    String eliminar =" ************************************************************\n"+
                     " **                                                        **\n"+
                     " **                    Eliminar vacuna                     **\n"+
                     " **          Introduzca el codigo de la vacuna:            **\n"+
                     " **                                                        **\n"+
                     " ************************************************************\n";
    
    return eliminar;
    }
      
    public static String introducirFases() {
        String introducirFases = " ************************************************************\n"
                               + " **                                                        **\n"
                               + " **    Introducir resultado de las fases de la vacuna      **\n"
                               + " **          Introduzca el codigo de la vacuna:            **\n"
                               + " **                                                        **\n"
                               + " ************************************************************\n";

        return introducirFases;
    }
    public static String opcionesFases() {
        String opcionesFases = " ************************************************************\n"
                             + " **  Opciones:                                             **\n"
                             + " **  1.-Fase 1                                             **\n"
                             + " **  2.-Fase 2                                             **\n"
                             + " **  3.-Fase 3                                             **\n"
                             + " **                                                        **\n"
                             + " ************************************************************\n";

        return opcionesFases;
    }
     public static String msjError() {
        String msjError = "   -Codigo invalido, o vacuna ya ha sido evaluada, vuelva a intentarlo-  \n";

        return msjError;
    }
    public static String opcionPais() {
        String opcionPais = " 1.-Agregar pais. \n"
                           +" 2.-Modificar pais.\n"
                           +" 3.-Eliminar pais.\n" +
                            " 4.-Buscar y mostrar pais\n"+
                            " 5.-Mostrar todos los paises.\n"+
                            " 6.-Salir\n";

        return opcionPais;
    }
    public static String menu(){
    String menu ="                  Seleccion una opcion:                 \n"
                +" 1.- Listar todas las vacunas y mostrar todos sus datos.\n"
                + " 2.- Buscar vacuna.\n"
                + " 3.- Agregar vacuna.\n"
                + " 4.- Eliminar vacuna.\n"
                + " 5.- Introducir resultado de las fases de la vacuna.\n"
                + " 6.- Autorizar/Rechazar vacuna.\n"
                + " 7.- Ver vacunas autorizadas.\n"
                + " 8.- Ver vacunas rechazadas.\n"
                + " 9.- Ver vacunas pendientes de autorizar/rechazar.\n"
                + " 10.-Ver la ultima fase investigada de cada vacuna almacenada.\n"
                + " 11.-Asignar vacunas a país.\n"
                + " 12.-Modificar vacuna.\n"
                + " 13.-Mostrar 5 modelos de vacuna.\n"
                + " 14.-Agregar cinco paises.\n"
                + " 15.-Opciones de pais.\n"
                + " 16-EXAMEN POO.\n"
                + " 17-Salir.\n\n";
    
    
            return menu;
    }
    /*
     *  Metodo para traducir las fases completadas
     */
    public static String infoFases(byte faseCompletada, boolean f1, boolean f2, boolean f3) {
        String infoFases="";

        if(faseCompletada < 2 && faseCompletada > 0 && f1) {
            infoFases = " Fase 1 completada con exito.\n";
        }else if(faseCompletada < 3 && faseCompletada > 1 && f1 && f2){
            infoFases = " Fase 2 completada con exito.\n";
        }else if(faseCompletada < 4 && faseCompletada > 2 && f1 && f2 && f3){
            infoFases = " Fase 3 completada con exito.\n";
        }else if (!f1 || !f2 || !f3){
            infoFases = "La vacuna no ha superado la fase: "+faseCompletada+"º.\n";
        }else{
            infoFases = "Ninguna fase completada.";
        }

        return infoFases;
    }


}
