package com.company;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static RadioCentral radioCentral = new RadioCentral();
    public static void main(String[] args){

        int opcion;
        do{
            System.out.println("Ingrese:");
            System.out.println("1 - Agregar programa");
            System.out.println("2 - Mostrar programas");
            System.out.println("3 - Mostrar programas con mayor audiencia");
            System.out.println("4 - Mostrar si existe un programa");
            System.out.println("5 - Mostrar cuantos programas de cada tipo son emitidos por emisora");
            System.out.println("6 - Mostrar cuantos programas que comienzan luego de las 15hs tienen audiencia menor a X");
            System.out.println("0 - Cortar programa");
            try {
                opcion=scan.nextInt();
                switch (opcion){
                    case 0:
                        break;
                    case 1 :
                        agregarPrograma();
                        break;
                    case 2:
                        mostrarProgramas();
                        break;
                    case 3:
                        mostrarProgramasConMayorAudiencia();
                        break;
                    case 4:
                        mostrarSiExistePrograma();
                        break;
                    case 5:
                        mostrarProgramasPorTipoYEmisora();
                        break;
                    case 6:
                        mostrarCuantosProgramasTienenAudienciaMenorA();
                        break;
                    default:
                        System.out.println("Dato no valido, pruebe de nuevo");
                        break;
                }
            }catch (Exception e){
                opcion=0;
                System.out.println("Dato no válido, ingrese al sistema nuevamente");
            }

        }while(opcion!= 0);
    }
    //1 Agregar programa
    public static void agregarPrograma(){
        try{
        System.out.println("Ingrese nombre del programa:");
        String nombre = scan.next();
        LocalTime hora = null;
        System.out.println("Ingrese la hora de emisión del programa: (ejemplo: 2015)");
        String horaCompleta=scan.next();
        hora = LocalTime.of(Integer.valueOf(horaCompleta.substring(0,2)),Integer.valueOf(horaCompleta.substring(2,4)));
        System.out.println("Ingrese el tipo de programa (número entero del 0 al 3)");
        int tipo=scan.nextInt();
        System.out.println("Ingrese la radio emisora: (número entero del 0 al 9)");
        int emisora=scan.nextInt();
        System.out.println("Ingrese el nivel de audiencia: (número entero mayor a 0)");
        int audiencia = scan.nextInt();
            System.out.println(radioCentral.agregarPrograma(new Programa(nombre,hora,tipo,emisora,audiencia)) ? "Programa agregado" : "No se pudo agregar el programa");
        }catch (Exception e){
            System.out.println("Dato no válido. Intente nuevamente");
        }
    }
    //2 Mostrar programas
    public static void mostrarProgramas(){
        System.out.println("Cargando programas......");
        System.out.println((radioCentral.getProgramas().isEmpty()) ? "No hay programas aún" : radioCentral.toString());
    }
    ///3 Mostrar programas con mayor audiencia
    public static void mostrarProgramasConMayorAudiencia(){
        if(radioCentral.getProgramas().isEmpty()){
            System.out.println("No hay programas aún");
        }else {
            System.out.println("Programas con mayor audiencia:");
            List<Programa> mayorAudiencia;
            mayorAudiencia =(radioCentral.getProgramas().size()<3) ? radioCentral.mostrarProgramasMayorAudiencia(radioCentral.getProgramas().size()) : radioCentral.mostrarProgramasMayorAudiencia(3);
            for (Programa programa : mayorAudiencia) {
                System.out.println(programa.toString());
            }
        }
    }
    //4 Mostrar si existe programa
    public static void mostrarSiExistePrograma(){
        System.out.println("Ingrese nombre del programa a buscar: ");
        String nombre = scan.next();
        List<Programa> existe = radioCentral.mostrarExistePrograma(nombre);
        if(existe!=null && existe.size()!=0){
            for (Programa programa:existe){
                System.out.println(programa.toString());
            }
        }else {
            System.out.println("No existe " + nombre);
        }
    }
    //5 Mostrar cuantos programas de cada tipo son emitidos por emisora
    public static void mostrarProgramasPorTipoYEmisora(){
        if(radioCentral.getProgramas().isEmpty()){
            System.out.println("No hay programas aún");
        }else {
            Map<Integer, int[]> mapTipoEmisora = radioCentral.mostrarCantidadProgramasSegunTipoYEmisora();
            for (Integer i : mapTipoEmisora.keySet()) {
                System.out.println("Emisora: " + i + "-> Tipo 0: " + mapTipoEmisora.get(i)[0] + "// Tipo 1: " + mapTipoEmisora.get(i)[1] + "// Tipo 2: " + mapTipoEmisora.get(i)[2] + "// Tipo 3: " + mapTipoEmisora.get(i)[3]);
            }
        }
    }
    //6 Mostrar cuantos programas que comienza luego de las 15 tienen audiencia menor a :
    public static void mostrarCuantosProgramasTienenAudienciaMenorA(){
        if(radioCentral.getProgramas().isEmpty()){
            System.out.println("No hay programas aún");
        }else {
            try {
                System.out.println("Ingrese un número entero mayor a 0:");
                int audiencia = scan.nextInt();
                System.out.println("Mostrando cuantos programas que comienzan luego de las 15 tienen audiencia menor a 30");
                int programasEncontrados = radioCentral.mostrarCuantosProgramasTienenAudienciaMenorA(audiencia);
                System.out.println((programasEncontrados < 0) ? "No hay programas que coincidan con la búsqueda" : programasEncontrados);
            } catch (Exception e) {
                System.out.println("Error, intente nuevamente");
            }
        }
    }
}