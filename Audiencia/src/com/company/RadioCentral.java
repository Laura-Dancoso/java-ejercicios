package com.company;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class RadioCentral {

    private List<Programa> programas;

    public RadioCentral(){
        programas = new ArrayList<>();
    }

    public List<Programa> getProgramas() {
        return programas;
    }

    @Override
    public String toString() {
        String prog="";
        for(Programa programa: programas){
            prog+= '\n' + programa.toString();
        }
        return "Programas{" +
                prog +'\n'+
                '}';
    }

    public boolean agregarPrograma(Programa p) {
        return programas.add(p);
    }
    public List<Programa> mostrarProgramasMayorAudiencia(int m){
        //ordena la lista según la audiencia
        Collections.sort(programas, (d1, d2) -> {
            return d2.getAudiencia() - d1.getAudiencia();
        });
        //retorna la cantidad pasada por parametro
        return programas.subList(0,m);
    }
    public List<Programa> mostrarExistePrograma(String nombrePrograma){
        return programas.stream().filter(p -> p.getNombre().toLowerCase().equals(nombrePrograma.toLowerCase())).collect(Collectors.toList());
    }
    public int[] mostrarCantidadDeProgramasSegunTipo(int emisora){
        List<Programa> filterList = programas.stream().filter(programa -> programa.getRadioEmisora()==emisora).collect(Collectors.toList());
        int [] cant= new int[4];
        for(Programa programa:filterList){
            if (programa.getTipoPrograma()>= 0 && programa.getTipoPrograma()<=3)
                cant[programa.getTipoPrograma()]++;
        }
        return cant;
    }
    //Map<numeroemisora,cantidadseguntipo>
    public Map<Integer,int[]> mostrarCantidadProgramasSegunTipoYEmisora(){
        int emisoras=10;
        Map <Integer,int[]> cant = new HashMap<>();
        for (Programa programa:programas){
            if (cant.containsKey(programa.getRadioEmisora())){
                cant.replace(programa.getRadioEmisora(), mostrarCantidadDeProgramasSegunTipo(programa.getRadioEmisora()));
            }else{
                cant.put(programa.getRadioEmisora(), mostrarCantidadDeProgramasSegunTipo(programa.getRadioEmisora()));
            }
        }
        return cant;
    }
    public int mostrarCuantosProgramasTienenAudienciaMenorA(int r){
        List<Programa> filterList = programas.stream().filter(programa -> programa.getHoraEmision().isAfter(LocalTime.of(15,0)) && programa.getAudiencia()<r).collect(Collectors.toList());
        return filterList.size();
    }
}
