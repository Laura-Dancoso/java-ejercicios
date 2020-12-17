package com.company;

import javax.swing.*;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Main {
    //lo voy a hardcodear para probar luego lo hago con entrada por teclado
    public static void main(String[] args){

        RadioCentral radioCentral = new RadioCentral();

        radioCentral.agregarPrograma(new Programa("Hola", LocalTime.of(22,40),0,1,20));
        radioCentral.agregarPrograma(new Programa("Chau", LocalTime.of(15,40),1,1,30));
        radioCentral.agregarPrograma(new Programa("Hola", LocalTime.of(15,40),2,1,24));
        radioCentral.agregarPrograma(new Programa("QueHaces", LocalTime.of(16,40),0,2,23));
        radioCentral.agregarPrograma(new Programa("Radio02", LocalTime.of(20,40),1,3,50));
        System.out.println("Mostrando programas");
        System.out.println(radioCentral.toString());
        System.out.println("-------------------------------");
        //1
        System.out.println("Programas con mayor audiencia: deberia mostrar 50,30,24");
        List<Programa> mayorAudiencia= radioCentral.mostrarProgramasMayorAudiencia(3);
        for(Programa programa: mayorAudiencia){
            System.out.println(programa.toString());
        }
        System.out.println("-----------------------");
        //2
        System.out.println("Existe programa? deberia mostrar q si");
        List<Programa> existe = radioCentral.mostrarExistePrograma("Chau");
        if(existe!=null){
            for (Programa programa:existe){
                System.out.println(programa.toString());
            }
        }else {
            System.out.println("no existe");
        }
        //dsp probar uno q no exista
        System.out.println("--------------------");
        //3
        System.out.println("cuantos programas de cada tipo son emitidos por emisora");
        Map<Integer,int[]> mapTipoEmisora= radioCentral.mostrarCantidadProgramasSegunTipoYEmisora();
        for (Integer i : mapTipoEmisora.keySet()) {
            System.out.println("Emisora: " + i + "-> Tipo 0: " + mapTipoEmisora.get(i)[0] +"// Tipo 1: " + mapTipoEmisora.get(i)[1] + "// Tipo 2: " + mapTipoEmisora.get(i)[2] +"// Tipo 3: " + mapTipoEmisora.get(i)[3]);
        }
        System.out.println("--------------------");
        //4
        System.out.println("cuantos programas que comienza luego de las 15 tienen audiencia menor a 30");
        System.out.println(radioCentral.mostrarCuantosProgramasTienenAudienciaMenorA(30));


    }
}
