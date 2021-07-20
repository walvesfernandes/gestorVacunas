package gal.teis.vacunas;

import gal.teis.vacunas.classes.Pais;
import gal.teis.vacunas.classes.Vacuna;
import gal.teis.vacunas.collections.AsignaVacuna;
import gal.teis.vacunas.collections.ConjuntoPaises;
import gal.teis.vacunas.collections.VacAlmacen;
import gal.teis.vacunas.resources.Textos;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * El Gestor de vacunas es una aplicacion que ha sido desarrollada con el lenguaje de programación JAVA, con intuito de
 * gestionar las posibles vacunas contra el COVID-19.
 *
 * @author willianaf
 * @version 0.2, 21/05/10
 */
public class Aplicacion {
    /**
     * La Aplicacion contiene 1 menu con 11 opciones autodescriptivas y podrás
     * acceder a cada opcion introduciendo el numero que siempre estará a la
     * izquierda en la pantalla. Ejemplo: 1.- 2.-
     *
     * @param args the command line arguments
     * @throws InterruptedException la exception es utilizada para "pausar" el
     *                              programa por segundos, para que el usuario pueda leer el mensaje en
     *                              pantalla.
     */
    public static void main(String[] args) throws InterruptedException {

        //Objetos
        Scanner cadena = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Vacuna vac = null;
        ConjuntoPaises conjuntoP = new ConjuntoPaises();
        VacAlmacen pendientes = new VacAlmacen();
        VacAlmacen vacAutorizadas = new VacAlmacen();
        VacAlmacen vacRechazadas = new VacAlmacen();
        VacAlmacen rechazadas3superadas = new VacAlmacen();
        AsignaVacuna asignaVac = null;
        Set<AsignaVacuna> listaVacunasAsignadas = new HashSet<AsignaVacuna>();
        String nombre;
        String scCodigo;
        String pais;
        int nOpciones;
        int opcion = 0;
        long cantidad;
        double precio;
        boolean salir = false;
        boolean ex;
        boolean mensaje = false;
        boolean control;
        boolean controle;


        //Cabecera
        System.out.println(Textos.titulo());
        do {
            int op = 0;
            do {
                ex = true;
                //Menu
                System.out.println(Textos.menu());
                try {
                    op = sc.nextInt();
                } catch (InputMismatchException e) {
                    //Exception en caso que el usuario introduzca una letra
                    //Se podría poner las opciones como String asi la app aceptaría cualquier valor sin dar errores
                    System.out.println(" -Has introducido una opcion invalida, vuelva a intentarlo");
                    Thread.sleep(2 * 1000);
                    ex = false;
                    sc.next();
                }
            } while (!ex);

            switch (op) {
                case 1:
                    //Verifico si existe vacunas dentro de alguna coleccion, si la hay enseña por pantalla
                    if (pendientes.isEmpty() && vacAutorizadas.isEmpty() && vacRechazadas.isEmpty()) {
                        System.out.println("Ninguna vacuna registrada\n\n");
                        Thread.sleep(2 * 1000);
                    } else {

                        if (pendientes.isEmpty()) {
                            System.out.println(vacAutorizadas.values());
                            System.out.println(vacRechazadas.values());
                            Thread.sleep(2 * 1000);
                        } else if (vacAutorizadas.isEmpty()) {
                            System.out.println(pendientes.values());
                            System.out.println(vacRechazadas.values());
                            Thread.sleep(2 * 1000);
                        } else if (vacRechazadas.isEmpty()) {
                            System.out.println(vacAutorizadas.values());
                            System.out.println(pendientes.values());
                            Thread.sleep(2 * 1000);
                        }

                    }
                    break;
                case 2:
                    //Buscar vacuna, si el codigo coincide con alguna key de la coleccion se enseña por pantalla el toString del objeto
                    //con todo su informacion dependiendo si esta autorizada o no

                    do {
                        ex = true;
                        //Menu
                        System.out.println(Textos.busca());
                        try {
                            opcion = sc.nextInt();
                        } catch (InputMismatchException e) {

                            System.out.println(" -Has introducido un dato invalido, vuelva a intentarlo");
                            Thread.sleep(2 * 1000);
                            ex = false;
                            sc.next();
                        }
                    } while (!ex);

                    //metodo para buscar las vacunas
                    buscarVacuna(opcion, vac, pendientes, vacAutorizadas, vacRechazadas);

                    break;
                case 3:

                    //Para crear una vacuna con todos sus valores y se envia a la coleccion "pendientes"

                    vac = new Vacuna();
                    do {
                        System.out.println(Textos.textoCodigo());
                        System.out.println("Introduzca el codigo de la vacuna: ");
                        nombre = cadena.nextLine();

                        if (nombre.isEmpty()) {
                            System.out.println(" -Dato invalido.\n");
                        } else {
                            if (verificarCodigo(nombre)) {
                                vac.setCodigo(nombre);
                            } else {
                                System.out.println("Codigo invalido, vuelva a intentarlo.");
                            }
                        }
                    } while (!verificarCodigo(nombre));

                    //controlo para que el usario no meta la misma vacuna
                    if (pendientes.containsKey(vac.getCodigo()) || vacAutorizadas.containsKey(vac.getCodigo()) || vacRechazadas.containsKey(vac.getCodigo())) {
                        System.out.println(" -Codigo repetido, vacuna ya existente. ");
                        Thread.sleep(2 * 1000);
                    } else {
                        //Si esta a vacio vuelve a pedir datos
                        do {
                            System.out.println("Introduzca el nombre de la vacuna: ");
                            nombre = cadena.nextLine();
                            if (nombre.isEmpty()) {
                                System.out.println(" -Dato invalido, vuelva a intentar.\n");
                            } else {
                                vac.setNombre(nombre);
                            }
                        } while (nombre.isEmpty());

                        //Si esta a vacio vuelve a pedir datos
                        do {
                            System.out.println("Introduzca el principio activo: ");
                            nombre = cadena.nextLine();
                            if (nombre.isEmpty()) {
                                System.out.println(" -Dato invalido, vuelva a intentar.\n");
                            } else {
                                vac.setPrincipioActivo(nombre);
                            }
                        } while (nombre.isEmpty());

                        //Si esta a vacio vuelve a pedir datos
                        do {
                            System.out.println("Introduzca la farmaceutica: ");
                            nombre = cadena.nextLine();
                            if (nombre.isEmpty()) {
                                System.out.println(" -Dato invalido, vuelva a intentar.\n");
                            } else {
                                vac.setFarmaceutica(nombre);
                            }
                        } while (nombre.isEmpty());


                        do {
                            control = true;
                            System.out.println("Introduzca el precio recomendado separado por coma ',' en caso que haya decimales.");
                            try {

                                precio = sc.nextDouble();
                                vac.setPrecioRecomendado(precio);
                                pendientes.put(vac.getCodigo(), vac);

                            } catch (InputMismatchException e) {
                                System.out.println("Has introducido un dato mal, vuelva a intentar");
                                Thread.sleep(2 * 1000);
                                control = false;
                                sc.next();
                            }
                        } while (!control);
                    }
                    break;
                case 4:
                    //Busca la key dentro de la coleccion y exclui el objeto de acuerdo con la key
                    System.out.println(Textos.eliminar());
                    scCodigo = cadena.nextLine();

                    if (pendientes.containsKey(scCodigo)) {
                        pendientes.remove(scCodigo);
                        System.out.println(" -Vacuna excluida con exito");
                        Thread.sleep(2 * 1000);
                    } else if (vacAutorizadas.containsKey(scCodigo)) {
                        vacAutorizadas.remove(scCodigo);
                        System.out.println(" -Vacuna excluida con exito");
                        Thread.sleep(2 * 1000);
                    } else if (vacRechazadas.containsKey(scCodigo)) {
                        vacRechazadas.remove(scCodigo);
                        System.out.println(" -Vacuna excluida con exito");
                        Thread.sleep(2 * 1000);
                    } else if (rechazadas3superadas.containsKey(scCodigo)) {
                        rechazadas3superadas.remove(scCodigo);
                        System.out.println(" -Vacuna excluida con exito");
                        Thread.sleep(2 * 1000);
                    } else {
                        System.out.println("Ninguna vacuna registrada con este codigo\n\n");
                        Thread.sleep(2 * 1000);
                    }

                    break;
                case 5:
                    //Opcion para introducir las fases superadas de una determinada vacuna
                    //Primero seleccionamos cual fase debe ser superada o no
                    System.out.println(Textos.introducirFases());
                    scCodigo = cadena.nextLine();

                    if (pendientes.containsKey(scCodigo)) {
                        //Hago un casting para usar los metodos del objeto
                        vac = (Vacuna) pendientes.get(scCodigo);

                        do {
                            ex = true;

                            System.out.println(Textos.opcionesFases());
                            try {
                                nOpciones = sc.nextInt();
                                enviarFasesSup(nOpciones, vac);

                            } catch (InputMismatchException e) {
                                //Exception en caso que el usuario introduzca una letra
                                //Se podría poner las opciones como String asi la app aceptaría cualquier valor sin dar errores
                                System.out.println(" -Has introducido una opcion invalida, vuelva a intentarlo");
                                Thread.sleep(2 * 1000);
                                ex = false;
                                sc.next();
                            }
                        } while (!ex);
                    } else {
                        //En caso de que esté poniendo un codigo invalido o no tenga ninguna vacuna registrada todavia
                        System.out.println("  -Codigo incorrecto, o la vacuna ya ha sido evaluada-   ");
                        Thread.sleep(2 * 1000);
                    }
                    break;

                case 6:
                    //Opcion para autorizar o rechazar una vacuna
                    //controlo que el usuario no pueda autorizar o rechazar con valores como -1 y que no falle
                    // la ejecucion si el usuario mete una letra
                    System.out.println(Textos.seleccion());
                    scCodigo = cadena.nextLine();

                    if (pendientes.containsKey(scCodigo)) {
                        vac = (Vacuna) pendientes.get(scCodigo);
                        do {
                            ex = true;

                            System.out.println(" 1.-Autorizar \n 0.-Rechazar");

                            try {
                                nOpciones = sc.nextInt();

                                //para un doble control para que salte el mensaje al usuario caso intente meter un -1
                                if (nOpciones < 2 && nOpciones > -1) {

                                    if (nOpciones == 1 && !vacRechazadas.containsKey(scCodigo) && vac.getFasesCompletadas() == 3) {
                                        //Si autoriza se envia el objeto a la coleccion de Autorizadas
                                        //y se cambia el codigo por un codigo de vacuna autorizada

                                        vac.autorizar(vac.getFasesCompletadas());

                                        vacAutorizadas.put(vac.getCodigo(), vac);
                                        System.out.println(" -Fecha que ha sido autorizada: " + vac.getFechaResultado());
                                        //Al autorizar elimina de pendientes
                                        if (pendientes.containsKey(scCodigo)) {
                                            pendientes.remove(scCodigo);
                                        }

                                    } else if (nOpciones == 0) {
                                        vac.rechazar(vac.getFasesCompletadas());
                                        vacRechazadas.put(scCodigo, vac);
                                        if (vacRechazadas.containsKey(scCodigo) && vac.getFase1Superada() && vac.getFase2Superada() && vac.getFase3Superada()) {
                                            rechazadas3superadas.put(scCodigo, vac);
                                        }
                                        pendientes.remove(pendientes.containsKey(scCodigo));
                                        System.out.println(" -Fecha que ha sido rechazada: " + vac.getFechaResultado());
                                        Thread.sleep(2 * 1000);
                                        //Al rechazada elimina de pendientes
                                        if (pendientes.containsKey(scCodigo)) {
                                            pendientes.remove(scCodigo);
                                        }
                                    } else {
                                        System.out.println(" La vacuna aun completo todas las fases, fase actual: " + vac.getFasesCompletadas() + ".\n");
                                        Thread.sleep(2 * 1000);
                                    }

                                } else {
                                    System.out.println(" Opcion invalida, vuelva a intentar.");
                                    Thread.sleep(2 * 1000);

                                }

                            } catch (InputMismatchException e) {
                                //Exception en caso que el usuario introduzca una letra
                                //Se podría poner las opciones como String asi la app aceptaría cualquier valor sin dar errores
                                System.out.println(" -Has introducido una opcion invalida, vuelva a intentarlo");
                                Thread.sleep(2 * 1000);
                                ex = false;
                                sc.next();
                            }
                        } while (!ex);
                    } else {
                        System.out.println(" -Codigo invalido, o vacuna ya ha sido evaluada. ");
                        Thread.sleep(2 * 1000);
                    }
                    break;
                case 7:
                    //Mostra todas las vacunas autorizadas
                    System.out.println(Textos.vacunas("autorizadas"));
                    if (vacAutorizadas.isEmpty()) {
                        System.out.println("Ninguna vacuna registrada, o autorizada\n\n");
                        Thread.sleep(2 * 1000);
                    } else {
                        System.out.println(vacAutorizadas.values() + "\n");
                        Thread.sleep(2 * 1000);
                    }
                    break;
                case 8:
                    System.out.println(Textos.vacunas("rechazadas "));

                    if (vacRechazadas.isEmpty()) {
                        System.out.println("Ninguna vacuna registrada, o rechazada\n\n");
                        Thread.sleep(2 * 1000);
                    } else {
                        System.out.println(vacRechazadas.values() + "\n" +
                                " -Fecha que ha sido rechazada: " + vac.getFechaResultado() + "\n");
                        Thread.sleep(2 * 1000);
                    }

                    break;
                case 9:
                    System.out.println(Textos.pendientes());

                    if (pendientes.isEmpty()) {
                        System.out.println("Ninguna vacuna registrada, o pendiente\n\n");
                    } else {
                        System.out.println(pendientes.values() + "\n");
                    }
                    Thread.sleep(2 * 1000);

                    break;
                case 10:
                    //Muestro las vacunas con la ultima fase superada
                    for (Object aux : pendientes.keySet()) {
                        vac = (Vacuna) pendientes.get(aux);
                        System.out.println(" Codigo: " + vac.getCodigo() + "\n" +
                                " Nombre: " + vac.getNombre() + "\n" +
                                " Fases completadas : " + vac.getFasesCompletadas() + "\n" +
                                " Estado de la ultima fase: " + Textos.infoFases(vac.getFasesCompletadas(), vac.getFase1Superada(), vac.getFase2Superada(), vac.getFase3Superada()) + "\n" + "\n");
                    }
                    Thread.sleep(3 * 1000);
                    break;
                case 11:

                    System.out.println("Introduzca el codigo de la vacuna:");
                    scCodigo = cadena.nextLine();

                    //verifico se la vacuna ya esta autorizada
                    if (vacAutorizadas.containsKey(scCodigo)) {

                        vac = (Vacuna) vacAutorizadas.get(scCodigo);
                        System.out.println(" Introduzca el pais: ");
                        pais = cadena.nextLine();

                        for (Pais aux : conjuntoP.getAlmacen()) {

                            if (aux.getNombre().equalsIgnoreCase(pais)) {

                                do {
                                    control = true;

                                    System.out.println(" Introduzca cuantas vacunas deseas asignar a ese pais: \n");
                                    try {
                                        boolean contr = false;

                                        for (AsignaVacuna e : listaVacunasAsignadas) {
                                            //Si ya existe la vacuna asigna a un pais
                                            if (e.getNombrePais().equalsIgnoreCase(pais) && e.getLaVacuna().getCodigo().equals(scCodigo)) {
                                                System.out.println(" Este pais ya tiene esa vacuna asignada, introduzca el nuevo valor");
                                                listaVacunasAsignadas.remove(e);
                                                asignaVac = new AsignaVacuna(vac, aux);
                                                cantidad = sc.nextLong();
                                                asignaVac.asignar(cantidad);
                                                listaVacunasAsignadas.add(asignaVac);
                                                System.out.println(" Vacunas incrementadas con exito.\n");
                                                Thread.sleep(3 * 100);
                                                contr = true;
                                            } else {
                                                //Control para crear una AsignaVac en caso de que un pais no tenga la vacuna repetida(crear un nuevo objeto)
                                                contr = false;
                                            }
                                        }

                                        if (!contr) {
                                            //agregar
                                            asignaVac = new AsignaVacuna(vac, aux);
                                            cantidad = sc.nextLong();
                                            asignaVac.asignar(cantidad);
                                            listaVacunasAsignadas.add(asignaVac);

                                            System.out.println(asignaVac.toString());
                                            Thread.sleep(2 * 1000);
                                            mensaje = true;
                                        }


                                    } catch (InputMismatchException e) {
                                        System.out.println("Has introducido un dato mal, vuelva a intentar");
                                        Thread.sleep(2 * 1000);
                                        control = false;
                                        sc.next();
                                    }
                                } while (!control);

                            } else {
                                mensaje = true;
                            }
                        }
                        if (!mensaje) {
                            System.out.println(" Ningun pais encontrado con ese nombre.\n");
                            Thread.sleep(2 * 1000);
                        }


                    } else {
                        System.out.println("   -Codigo invalido, o vacuna no ha sido autorizada, vuelva a intentarlo-  \n");
                        Thread.sleep(2 * 1000);
                    }
                    break;
                case 12:
                    //Opcion modificar los datos de una vacuna
                    do {
                        control = true;
                        System.out.println(Textos.modVacuna());
                        try {
                            opcion = sc.nextInt();
                            //metodo para modificar las informaciones de una vacuna
                            modVacuna(opcion, vac, pendientes, vacAutorizadas, vacRechazadas);
                        } catch (InputMismatchException e) {
                            System.out.println("Has introducido un dato mal, vuelva a intentar");
                            Thread.sleep(3 * 1000);
                            control = false;
                            sc.next();
                        }
                    } while (!control);

                    break;
                case 13:
                    //crear cinco vacunas para mostrar como modelo
                    System.out.println(pendientes.crearCinco());
                    Thread.sleep(3 * 1000);
                    break;
                case 14:

                    do {
                        control = true;

                        System.out.println("Quieres agregar cinco paises: \n 1.-si 0.-no");
                        try {
                            opcion = sc.nextInt();
                            if (opcion == 1) {
                                conjuntoP.agregarCinco(true);
                                System.out.println(conjuntoP.listar());
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Has introducido un dato mal, vuelva a intentar");
                            Thread.sleep(3 * 1000);
                            control = false;
                            sc.next();
                        }
                    } while (!control);

                    break;

                case 15:
                    do {
                        do {
                            ex = true;
                            controle = false;
                            System.out.println(Textos.opcionPais());

                            try {
                                opcion = sc.nextInt();
                            } catch (InputMismatchException e) {
                                //Exception en caso que el usuario introduzca una letra
                                //Se podría poner las opciones como String asi la app aceptaría cualquier valor sin dar errores
                                System.out.println(" -Has introducido una opcion invalida, vuelva a intentarlo");
                                Thread.sleep(3 * 1000);
                                ex = false;
                                sc.next();
                            }
                        } while (!ex);

                        switch (opcion) {
                            case 1:
                                System.out.println(" Codigo del pais (prefijo telefonico): ");
                                pais = cadena.nextLine();

                                //creo un pais generico
                                Pais generico = new Pais();
                                generico.setCodigo(pais);

                                System.out.println(" Nombre del pais: ");
                                pais = cadena.nextLine().toLowerCase();
                                generico.setNombre(pais);

                                conjuntoP.agregar(generico);
                                System.out.println(" Pais introducido con exito.\n");
                                Thread.sleep(3 * 100);
                                break;
                            case 2:
                                System.out.println(" Cual es el nombre del pais que quieres modificar?");
                                pais = cadena.nextLine();

                                for (Pais aux : conjuntoP.getAlmacen()) {
                                    if (aux.getNombre().equalsIgnoreCase(pais)) {
                                        System.out.println(" Introduzca el nuevo nombre: ");
                                        pais = cadena.nextLine();
                                        aux.setNombre(pais);
                                        System.out.println(" Nombre cambiado con exito.\n");
                                        Thread.sleep(3 * 100);
                                        mensaje = true;
                                    } else {
                                        mensaje = false;
                                    }
                                }
                                //Si mensaje es false no entra en el if
                                if (!mensaje) {
                                    System.out.println(" Ningun pais encontrado.\n");
                                    Thread.sleep(3 * 1000);
                                }


                                break;
                            case 3:

                                System.out.println("Cual es el nombre del pais que quieres Eliminar?");
                                pais = cadena.nextLine();

                                try {
                                    mensaje = false;

                                    for (Iterator<Pais> iterator = conjuntoP.getAlmacen().iterator(); iterator.hasNext(); ) {
                                        Pais aux = iterator.next();
                                        if (aux.getNombre().equalsIgnoreCase(pais)) {
                                            conjuntoP.getAlmacen().remove(aux);
                                            System.out.println(" Pais excluido con exito.\n");
                                            //caso el pais exista mensaje se pasa a true
                                            mensaje = true;
                                        } else {
                                            mensaje = false;
                                        }
                                    }
                                    //Si mensaje es false no entra en el if
                                    if (!mensaje) {
                                        System.out.println(" Ningun pais encontrado.\n");
                                        Thread.sleep(3 * 1000);
                                    }
                                } catch (ConcurrentModificationException e) {
                                    //capturo la exception para no finalizar el programa
                                }

                                break;
                            case 4:

                                System.out.println("Cual es el nombre del pais que quieres buscar?");
                                pais = cadena.nextLine();

                                try {
                                    mensaje = false;

                                    for (Iterator<Pais> iterator = conjuntoP.getAlmacen().iterator(); iterator.hasNext(); ) {
                                        Pais aux = iterator.next();
                                        if (aux.getNombre().equalsIgnoreCase(pais)) {
                                            System.out.println(aux.toString());
                                            mensaje = true;
                                        } else {
                                            mensaje = false;
                                        }
                                    }
                                    //Si mensaje es false no entra en el if
                                    if (!mensaje) {
                                        System.out.println(" Ningun pais encontrado.\n");
                                        Thread.sleep(3 * 1000);
                                    }
                                } catch (ConcurrentModificationException e) {
                                    //capturo la exception para no finalizar el programa
                                }

                                break;
                            case 5:
                                if (conjuntoP.getAlmacen().isEmpty()) {
                                    System.out.println(" No hay ningun pais registrado.\n");
                                    Thread.sleep(3 * 1000);
                                } else {
                                    System.out.println(conjuntoP.listar());
                                    Thread.sleep(3 * 1000);
                                }
                                break;
                            case 6:
                                controle = true;
                                break;
                        }
                    } while (!controle);

                    break;
                case 16:

                    //EXAMEN 2 POO

                    do {
                        ex = true;
                        System.out.println(" EXAMEN POO \n");
                        System.out.println(" 1.- EXAMEN1 -Ver vacunas rechazadas con las 3 fases superadas. \n" +
                                " 2.- EXAMEN2 -Ver las vacunas segun las fases superadas. \n" +
                                " 3.- EXAMEN3 -Mostrar vacunas asignadas a un pais. \n" +
                                " 4.-Salir.");
                        try {
                            opcion = sc.nextInt();

                            switch (opcion) {
                                case 1:
                                    //creo una coleccion para mostrar solamente las vacunas que fueron rechazadas pero a la vez superaron las 3 fases
                                    if (rechazadas3superadas.isEmpty()) {
                                        System.out.println(" Aun no existe vacunas rechazadas con las 3 fases superadas. \n");
                                        Thread.sleep(2 * 1000);
                                    } else {
                                        System.out.println(rechazadas3superadas.values() + "\n" +
                                                " -Fecha que ha sido rechazada: " + vac.getFase1Superada() + vac.getFase2Superada() + vac.getFase3Superada() + "\n");
                                        Thread.sleep(2 * 1000);
                                    }
                                    break;
                                case 2:
                                    //Ver las vacunas que han superado una determinada fase
                                    boolean noExiste = false;

                                    do {
                                        ex = true;
                                        System.out.println(" 1.- Ver vacunas que aprobaron la fase 1. \n" +
                                                " 2.- Ver vacunas que aprobaron la fase 2. \n" +
                                                " 3.- Ver vacunas que aprobaron la fase 3. \n" +
                                                " 4.-Volver.");
                                        try {
                                            opcion = sc.nextInt();
                                        } catch (InputMismatchException e) {
                                            //Exception en caso que el usuario introduzca una letra
                                            //Se podría poner las opciones como String asi la app aceptaría cualquier valor sin dar errores
                                            System.out.println(" -Has introducido una opcion invalida, vuelva a intentarlo");
                                            Thread.sleep(2 * 1000);
                                            ex = false;
                                            sc.next();
                                        }
                                    } while (!ex);

                                    //Switch para ver las vacunas que han superado una determinada fase
                                    switch (opcion) {

                                        // Como tengo 3 colecciones de vacuna tengo que recorrer a las 3, por eso los 3 for
                                        case 1:
                                            //recojo la coleccion si fase esta superada y la cantidad es equivalente o a la fase o superior
                                            for (Object aux : pendientes.keySet()) {
                                                vac = (Vacuna) pendientes.get(aux);
                                                if (vac.getFase1Superada() && vac.getFasesCompletadas() > 0) {
                                                    System.out.println(" Codigo: " + vac.getCodigo() + "\n" +
                                                            " Nombre: " + vac.getNombre() + "\n" +
                                                            " 1º Fase completada. \n" +
                                                            " Estado de la ultima fase: " + Textos.infoFases(vac.getFasesCompletadas(), vac.getFase1Superada(), vac.getFase2Superada(), vac.getFase3Superada()) + "\n" + "\n");
                                                    noExiste = true;
                                                } else {
                                                    noExiste = false;
                                                }
                                            }
                                            for (Object aux : vacAutorizadas.keySet()) {
                                                vac = (Vacuna) vacAutorizadas.get(aux);
                                                if (vac.getFase1Superada() && vac.getFasesCompletadas() > 0) {
                                                    System.out.println(" Codigo: " + vac.getCodigo() + "\n" +
                                                            " Nombre: " + vac.getNombre() + "\n" +
                                                            " 1º Fase completada. \n" +
                                                            " Estado de la ultima fase: " + Textos.infoFases(vac.getFasesCompletadas(), vac.getFase1Superada(), vac.getFase2Superada(), vac.getFase3Superada()) + "\n" + "\n");
                                                    noExiste = true;
                                                } else {
                                                    noExiste = false;
                                                }
                                            }
                                            for (Object aux : vacRechazadas.keySet()) {
                                                vac = (Vacuna) vacRechazadas.get(aux);
                                                if (vac.getFase1Superada() && vac.getFasesCompletadas() > 0) {
                                                    System.out.println(" Codigo: " + vac.getCodigo() + "\n" +
                                                            " Nombre: " + vac.getNombre() + "\n" +
                                                            " 1º Fase completada. \n" +
                                                            " Estado de la ultima fase: " + Textos.infoFases(vac.getFasesCompletadas(), vac.getFase1Superada(), vac.getFase2Superada(), vac.getFase3Superada()) + "\n" + "\n");
                                                    noExiste = true;
                                                } else {
                                                    noExiste = false;
                                                }
                                            }
                                            //Caso no encuentre mostra un mensaje
                                            if (!noExiste) {
                                                System.out.println(" Ninguna vacuna con esa fase superada fue encontrada.");
                                                Thread.sleep(3 * 1000);
                                            }
                                            Thread.sleep(3 * 1000);
                                            break;
                                        case 2:
                                            for (Object aux : pendientes.keySet()) {
                                                vac = (Vacuna) pendientes.get(aux);
                                                if (vac.getFase2Superada() && vac.getFasesCompletadas() > 1) {
                                                    System.out.println(" Codigo: " + vac.getCodigo() + "\n" +
                                                            " Nombre: " + vac.getNombre() + "\n" +
                                                            " 2º Fase completada. \n" +
                                                            " Estado de la ultima fase: " + Textos.infoFases(vac.getFasesCompletadas(), vac.getFase1Superada(), vac.getFase2Superada(), vac.getFase3Superada()) + "\n" + "\n");
                                                    noExiste = true;
                                                } else {
                                                    noExiste = false;
                                                }
                                            }
                                            for (Object aux : vacAutorizadas.keySet()) {
                                                vac = (Vacuna) vacAutorizadas.get(aux);
                                                if (vac.getFase2Superada() && vac.getFasesCompletadas() > 1) {
                                                    System.out.println(" Codigo: " + vac.getCodigo() + "\n" +
                                                            " Nombre: " + vac.getNombre() + "\n" +
                                                            " 2º Fase completada. \n" +
                                                            " Estado de la ultima fase: " + Textos.infoFases(vac.getFasesCompletadas(), vac.getFase1Superada(), vac.getFase2Superada(), vac.getFase3Superada()) + "\n" + "\n");
                                                    noExiste = true;
                                                } else {
                                                    noExiste = false;
                                                }
                                            }
                                            for (Object aux : vacRechazadas.keySet()) {
                                                vac = (Vacuna) vacRechazadas.get(aux);
                                                if (vac.getFase2Superada() && vac.getFasesCompletadas() > 1) {
                                                    System.out.println(" Codigo: " + vac.getCodigo() + "\n" +
                                                            " Nombre: " + vac.getNombre() + "\n" +
                                                            " 2º Fase completada. \n" +
                                                            " Estado de la ultima fase: " + Textos.infoFases(vac.getFasesCompletadas(), vac.getFase1Superada(), vac.getFase2Superada(), vac.getFase3Superada()) + "\n" + "\n");
                                                    noExiste = true;
                                                } else {
                                                    noExiste = false;
                                                }
                                            }
                                            if (!noExiste) {
                                                System.out.println(" Ninguna vacuna con esa fase superada fue encontrada.");
                                            }
                                            Thread.sleep(3 * 1000);
                                            break;
                                        case 3:

                                            for (Object aux : pendientes.keySet()) {
                                                vac = (Vacuna) pendientes.get(aux);
                                                if (vac.getFase3Superada() && vac.getFasesCompletadas() > 2) {
                                                    System.out.println(" Codigo: " + vac.getCodigo() + "\n" +
                                                            " Nombre: " + vac.getNombre() + "\n" +
                                                            " 3º Fase completada. \n" +
                                                            " Estado de la ultima fase: " + Textos.infoFases(vac.getFasesCompletadas(), vac.getFase1Superada(), vac.getFase2Superada(), vac.getFase3Superada()) + "\n" + "\n");
                                                    noExiste = true;
                                                } else {
                                                    noExiste = false;
                                                }
                                            }

                                            for (Object aux : vacAutorizadas.keySet()) {
                                                vac = (Vacuna) vacAutorizadas.get(aux);
                                                if (vac.getFase3Superada() && vac.getFasesCompletadas() > 2) {
                                                    System.out.println(" Codigo: " + vac.getCodigo() + "\n" +
                                                            " Nombre: " + vac.getNombre() + "\n" +
                                                            " 3º Fase completada. \n" +
                                                            " Estado de la ultima fase: " + Textos.infoFases(vac.getFasesCompletadas(), vac.getFase1Superada(), vac.getFase2Superada(), vac.getFase3Superada()) + "\n" + "\n");
                                                    noExiste = true;
                                                } else {
                                                    noExiste = false;
                                                }
                                            }
                                            for (Object aux : vacRechazadas.keySet()) {
                                                vac = (Vacuna) vacRechazadas.get(aux);
                                                if (vac.getFase3Superada() && vac.getFasesCompletadas() > 2) {
                                                    System.out.println(" Codigo: " + vac.getCodigo() + "\n" +
                                                            " Nombre: " + vac.getNombre() + "\n" +
                                                            " 3º Fase completada. \n" +
                                                            " Estado de la ultima fase: " + Textos.infoFases(vac.getFasesCompletadas(), vac.getFase1Superada(), vac.getFase2Superada(), vac.getFase3Superada()) + "\n" + "\n");
                                                    noExiste = true;
                                                } else {
                                                    noExiste = false;
                                                }
                                            }

                                            if (!noExiste) {
                                                System.out.println(" Ninguna vacuna con esa fase superada fue encontrada.");
                                            }
                                            Thread.sleep(3 * 1000);
                                            break;
                                        case 4:
                                            ex = false;
                                            break;
                                    }

                                    break;
                                case 3:
                                    //Opcion para buscar paises que tiene vacunas asignadas
                                    boolean noPais = false;

                                    System.out.println(Textos.asignadas());

                                    System.out.println(" Introduzca el pais: ");
                                    pais = cadena.nextLine();

                                    for (AsignaVacuna aux : listaVacunasAsignadas) {
                                        //Si contiene el pais enseña los datos
                                        if (aux.getNombrePais().equals(pais)) {
                                            System.out.println(aux.toString());
                                            noPais = true;
                                        } else {
                                            noPais = false;
                                        }
                                    }
                                    // caso no exista el pais o aun no tenga vacunas asignada
                                    if (!noPais) {
                                        System.out.println(" Ese pais no existe, o aun no tiene vacunas asignadas.");
                                    }
                                    Thread.sleep(3 * 1000);
                                    break;
                            }

                        } catch (InputMismatchException e) {
                            //Exception en caso que el usuario introduzca una letra
                            //Se podría poner las opciones como String asi la app aceptaría cualquier valor sin dar errores
                            System.out.println(" -Has introducido una opcion invalida, vuelva a intentarlo");
                            Thread.sleep(3 * 1000);
                            ex = false;
                            sc.next();
                        }
                    } while (!ex);


                    break;
                case 17:
                    salir = true;
                    break;
            }
        } while (!salir);
    }

    /*
     * Metodo que busca las vacunas por codigo, nombre y estado (Autorizada o Rechazada)
     * @param int opcion, object vacuna, object vacAlmacen
     */
    public static void buscarVacuna(int opcion, Vacuna vac, VacAlmacen pendientes, VacAlmacen vacAutorizadas, VacAlmacen vacRechazadas) throws InterruptedException {
        Scanner scnner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        String scCodigo = "";
        boolean ex;

        switch (opcion) {
            case 1:
                System.out.println("Introduzca el codigo: ");
                scCodigo = scnner.nextLine();

                if (verificarCodigo(scCodigo)) {
                    if (pendientes.containsKey(scCodigo)) {
                        System.out.println("-Resultado encontrado: \n" + pendientes.get(scCodigo).toString());
                        Thread.sleep(3 * 1000);
                    } else if (vacAutorizadas.containsKey(scCodigo)) {
                        System.out.println("-Resultado encontrado: \n" + vacAutorizadas.get(scCodigo).toString());
                        Thread.sleep(3 * 1000);
                    } else if (vacRechazadas.containsKey(scCodigo)) {
                        System.out.println("-Resultado encontrado: \n" + vacRechazadas.get(scCodigo).toString());
                        Thread.sleep(3 * 1000);
                    } else {
                        System.out.println("-Vacuna no encontrada.\n");
                        Thread.sleep(3 * 1000);
                    }
                } else {
                    System.out.println(" Codigo invalido, vuelva a intentar.\n");
                    Thread.sleep(3 * 1000);
                }
                break;
            case 2:
                System.out.println("Introduzca el nombre: ");
                scCodigo = scnner.nextLine();

                Iterator<Vacuna> it = pendientes.values().iterator();

                if (pendientes.isEmpty()) {
                    System.out.println("No fue encontrada ninguna vacuna con ese nombre. ");
                    Thread.sleep(3 * 1000);
                } else {
                    while (it.hasNext()) {

                        if (vac.getNombre().equals(scCodigo)) {
                            String cad = it.next().toString();
                            System.out.println(cad);
                            Thread.sleep(3 * 1000);
                        }
                    }
                }
                break;
            case 3:
                do {
                    ex = true;
                    //Menu
                    System.out.println("Introduzca el estado\n 1.-Autorizada 2.-rechazada");
                    try {
                        opcion = sc.nextInt();

                        if (opcion == 1) {
                            //Si la colecion esta vacia envia un mensaje avisando al usuario
                            if (vacAutorizadas.isEmpty()) {
                                System.out.println("No hay ninguna vacuna autorizada todavia.");
                            } else {
                                System.out.println(vacAutorizadas.values());
                                Thread.sleep(3 * 1000);
                            }

                        } else if (opcion == 2) {
                            if (vacRechazadas.isEmpty()) {
                                System.out.println("No hay ninguna vacuna rechazada todavia.");
                            } else {
                                System.out.println(vacRechazadas.values());
                                Thread.sleep(3 * 1000);
                            }
                        }

                    } catch (InputMismatchException e) {

                        System.out.println(" -Has introducido una dato invalida, vuelva a intentarlo");
                        Thread.sleep(3 * 1000);
                        ex = false;
                        sc.next();
                    }
                } while (!ex);
                break;
        }
    }

    /*
     *Metodo para enviar las fases de una vacuna
     * @param int opcion del switch y object vacuna
     */
    public static void enviarFasesSup(int nOpciones, Vacuna vac) throws InterruptedException {
        Scanner scnner = new Scanner(System.in);
        boolean ex;
        int control;

        //Con ese switch mostrará de acuerdo con fase que ha seleccionado el usuario y preguntará si ha superado la fase o no
        switch (nOpciones) {

            case 1:
                if (vac.getFasesCompletadas() == 0) {
                    do {
                        ex = true;
                        System.out.println(" La vacuna ha superado la 1º fase?\n");
                        System.out.println(" 1.-Si \n 0.-No\n");
                        try {
                            control = scnner.nextInt();
                            if (control == 1) {
                                vac.setFase1Superada(1);
                            } else if (control == 0) {
                                vac.setFase1Superada(0);
                            }

                        } catch (InputMismatchException e) {
                            //Exception en caso que el usuario introduzca una letra
                            //Se podría poner las opciones como String asi la app aceptaría cualquier valor sin dar errores
                            System.out.println(" -Has introducido una opcion invalida, vuelva a intentarlo");
                            Thread.sleep(3 * 1000);
                            ex = false;
                            scnner.next();
                        }
                    } while (!ex);
                } else {
                    System.out.printf(" Esa fase ya ha sido analizada.");
                    Thread.sleep(3 * 1000);
                }
                break;
            case 2:
                if (vac.getFasesCompletadas() == 1 && vac.getFase1Superada()) {
                    do {
                        ex = true;
                        System.out.println(" La vacuna ha superado la 2º fase?\n");
                        System.out.println(" 1.-Si \n 0.-No\n");
                        try {
                            control = scnner.nextInt();
                            if (control == 1 && vac.getFasesCompletadas() == 1) {
                                vac.setFase2Superada(1);
                            } else if (control == 0) {
                                vac.setFase2Superada(0);
                            } else {
                                System.out.println("La vacuna no ha superado la fase anterior.");
                            }

                        } catch (InputMismatchException e) {
                            //Exception en caso que el usuario introduzca una letra
                            //Se podría poner las opciones como String asi la app aceptaría cualquier valor sin dar errores
                            System.out.println(" -Has introducido una opcion invalida, vuelva a intentarlo");
                            Thread.sleep(3 * 1000);
                            ex = false;
                            scnner.next();
                        }
                    } while (!ex);
                } else {
                    System.out.printf(" Esa fase ya ha sido analizada, o la vacuna no ha superado la fase anterior. \n" +
                            " Fase actual: " + vac.getFasesCompletadas());
                    Thread.sleep(3 * 1000);
                }
                break;

            case 3:
                if (vac.getFasesCompletadas() == 2 && vac.getFase2Superada()) {
                    do {
                        ex = true;
                        System.out.println(" La vacuna ha superado la 3º fase?\n");
                        System.out.println(" 1.-Si \n 0.-No\n");
                        try {
                            control = scnner.nextInt();

                            if (control == 1 && vac.getFasesCompletadas() == 2) {
                                vac.setFase3Superada(1);
                            } else if (control == 0) {
                                vac.setFase3Superada(0);
                            } else {
                                System.out.printf(" Esa fase ya ha sido analizada, o la vacuna no ha superado la fase anterior. \n" +
                                        " Fase actual: " + vac.getFasesCompletadas());
                                Thread.sleep(3 * 1000);
                            }

                        } catch (InputMismatchException e) {
                            //Exception en caso que el usuario introduzca una letra
                            //Se podría poner las opciones como String asi la app aceptaría cualquier valor sin dar errores
                            System.out.println(" -Has introducido una opcion invalida, vuelva a intentarlo");
                            Thread.sleep(3 * 1000);
                            ex = false;
                            scnner.next();
                        }
                    } while (!ex);
                } else {
                    System.out.printf(" Esa fase ya ha sido analizada, o la vacuna no ha superado la fase anterior. \n" +
                            " Fase actual: " + vac.getFasesCompletadas());
                    Thread.sleep(3 * 1000);
                }
                break;

            default:
                //Caso no cumpla con los valores correcto se enviará un mensaje de error
                System.out.println(" -Has introducido un dato incorrecto.");
                Thread.sleep(3 * 1000);
                break;
        }
    }

    /*
     * Metodo que busca las vacunas por codigo, nombre y estado (Autorizada o Rechazada)
     * @param String codigo de la vacuna, int opcion, object vacuna, object vacAlmacen
     */
    public static void modVacuna(int opcion, Vacuna vac, VacAlmacen pendientes, VacAlmacen vacAutorizadas, VacAlmacen vacRechazadas) throws InterruptedException {
        Scanner cadena = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        String scCodigo;
        double precio;
        boolean control;

        System.out.println("Introduzca el codigo de la vacuna: ");
        scCodigo = cadena.nextLine();

        if (pendientes.containsKey(scCodigo) || vacAutorizadas.containsKey(scCodigo) || vacRechazadas.containsKey(scCodigo)) {
            switch (opcion) {
                case 1:

                    System.out.println("Introduzca el nuevo nombre: ");
                    nombre = cadena.nextLine();

                    vac.setNombre(nombre);
                    System.out.println("Nombre cambiado con exito...");
                    Thread.sleep(3 * 1000);

                    break;
                case 3:
                    System.out.println("Introduzca el nuevo Principio activo: ");
                    nombre = cadena.nextLine();

                    vac.setPrincipioActivo(nombre);
                    System.out.println("Principio activo cambiado con exito...");
                    Thread.sleep(3 * 1000);

                    break;
                case 4:
                    System.out.println("Introduzca la nueva Farmaceutica: ");
                    nombre = cadena.nextLine();


                    vac.setFarmaceutica(nombre);
                    System.out.println("Farmaceutica cambiada con exito...");
                    Thread.sleep(3 * 1000);

                    break;
                case 5:
                    do {
                        control = true;
                        System.out.println("Introduzca el nuevo precio recomendado separado por coma ',' ");
                        try {
                            precio = sc.nextDouble();

                            vac.setPrecioRecomendado(precio);
                            System.out.println("Precio cambiado con exito...");
                            Thread.sleep(3 * 1000);

                        } catch (InputMismatchException e) {
                            System.out.println("Has introducido un dato mal, vuelva a intentar");
                            Thread.sleep(3 * 1000);
                            control = false;
                            sc.next();
                        }
                    } while (!control);
                    break;
            }
        } else {
            System.out.println(" Vacuna no encontrada. ");
            Thread.sleep(3 * 1000);
        }
    }

    /*
     * Metodo que verifica si el codigo de la vacuna es valido
     * @param String codigo de la vacuna
     */
    public static boolean verificarCodigo(String codigo) {
        boolean correcto;

        Pattern pat = Pattern.compile("^[V][AEIOU][a-zA-Z]{3,4}([4-7]{2}|8)$");

        Matcher mat = pat.matcher(codigo);

        if (mat.find()) {
            correcto = true;
        } else {
            correcto = false;
        }


        return correcto;

    }
}

