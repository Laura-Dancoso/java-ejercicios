package com.laura.AudienciaJDBC;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
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
            ProgramaDAO.insertarPrograma(new Programa(nombre,hora,tipo,emisora,audiencia));
        }catch (Exception e){
            System.out.println("Dato no válido. Intente nuevamente");
        }
    }
    //2 Mostrar programas
    public static void mostrarProgramas(){
        try{
            System.out.println("Cargando programas......");
            if(ProgramaDAO.getAllProgramas().isEmpty()){
                System.out.println("No hay programas aún");
            }else{
                for(Programa p : ProgramaDAO.getAllProgramas()){
                    System.out.println(p);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        }
    ///3 Mostrar programas con mayor audiencia
    public static void mostrarProgramasConMayorAudiencia(){
        try{
        if(ProgramaDAO.getAllProgramas().isEmpty()){
            System.out.println("No hay programas aún");
        }else {
            System.out.println("Programas con mayor audiencia:");
            List<Programa> mayorAudiencia;
            mayorAudiencia =(ProgramaDAO.getAllProgramas().size()<3) ? ProgramaDAO.mostrarProgramasMayorAudiencia(ProgramaDAO.getAllProgramas().size()) : ProgramaDAO.mostrarProgramasMayorAudiencia(3);
            for (Programa programa : mayorAudiencia) {
                System.out.println(programa.toString());
            }
        }}catch (Exception e){
            e.printStackTrace();
        }
    }
    //4 Mostrar si existe programa
    public static void mostrarSiExistePrograma(){
        try{
        System.out.println("Ingrese nombre del programa a buscar: ");
        String nombre = scan.next();
        List<Programa> existe = ProgramaDAO.mostrarExistePrograma(nombre);
        if(existe!=null && existe.size()!=0){
            for (Programa programa:existe){
                System.out.println(programa.toString());
            }
        }else {
            System.out.println("No existe " + nombre);
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //5 Mostrar cuantos programas de cada tipo son emitidos por emisora
    public static void mostrarProgramasPorTipoYEmisora(){
        try {
            if (ProgramaDAO.getAllProgramas().isEmpty()) {
                System.out.println("No hay programas aún");
            } else {
                Map<Integer, int[]> mapTipoEmisora = ProgramaDAO.mostrarCantidadProgramasSegunTipoYEmisora();
                for (Integer i : mapTipoEmisora.keySet()) {
                    System.out.println("Emisora: " + i + "-> Tipo 0: " + mapTipoEmisora.get(i)[0] + "// Tipo 1: " + mapTipoEmisora.get(i)[1] + "// Tipo 2: " + mapTipoEmisora.get(i)[2] + "// Tipo 3: " + mapTipoEmisora.get(i)[3]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //6 Mostrar cuantos programas que comienza luego de las 15 tienen audiencia menor a :
    public static void mostrarCuantosProgramasTienenAudienciaMenorA(){
        try {
            if (ProgramaDAO.getAllProgramas().isEmpty()) {
                System.out.println("No hay programas aún");
            } else {
                try {
                    System.out.println("Ingrese un número entero mayor a 0:");
                    int audiencia = scan.nextInt();
                    System.out.println("Mostrando cuantos programas que comienzan luego de las 15 tienen audiencia menor a 30");
                    int programasEncontrados = ProgramaDAO.mostrarCuantosProgramasTienenAudienciaMenorA(audiencia);
                    System.out.println((programasEncontrados < 0) ? "No hay programas que coincidan con la búsqueda" : programasEncontrados);
                } catch (Exception e) {
                    System.out.println("Error, intente nuevamente");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
