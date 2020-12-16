package com.company;


import java.util.ArrayList;
import java.util.List;

public class RecursosHumanos {
    private List<Empleado> empleados;

    public RecursosHumanos(){
        empleados = new ArrayList<>();
    }

    public List<Empleado> getEmpleados(){
        return empleados;
    }

    @Override
    public String toString() {
        String res = "";
        if(empleados.isEmpty()){
            res="No hay empleados aún";
        }else {
            for (Empleado empleado : empleados) {
                res += empleado.toString();
            }
        }
        return res;
    }

    public boolean agregarEmpleado(Empleado e){
        return empleados.add(e);
    }
    public boolean eliminarEmpleado(int legajo){
        /*
        Empleado encontrado =null;
        for(Empleado e : empleados){
        if(empleado.getLegajo == legajo){
        encontrado= empleado;
        }
       if (encontrado!=null) {
       empleados.remove(encontrado);
       return true
       }else{
       return false
       }
        */


        int encontrado= -20;
        for (int i= 0; i<empleados.size();i++){
            if(empleados.get(i).getLegajo() == legajo) {
                encontrado = i;
                break;
            }
        }
        if(encontrado!=-20){
            empleados.remove(encontrado);
            return true;
        }else{
            return false;
        }
    }
    public Empleado calcularMayorSalario(){
        Empleado mayor = empleados.get(0);
        for(Empleado e : empleados){
            if(e.calcularSalario() > mayor.calcularSalario()){
                mayor= e;
            }
        }
        return mayor;
    }
    public int[] contarPorCategoria(){
        int[] contador = new int[3];
        for (Empleado e: empleados){
            //instance of : si ese empleado es una instacia de Contratado
            // /*
            //            if (e instanceof Contratado){
            //                int c = ((Contratado) e).getCategoria().getNumero();
            //                contador[c-1]++;
            //            }
            //            es lo mismo que:
            //            */
            if (e instanceof Contratado)
                contador[((Contratado) e).getCategoria().getNumero()-1]++;
        }
        return contador;
    }
    public int calcularCantidadSalarioMayorA(double salario){
        int cant= 0;
        for(Empleado e :empleados){
            if(e.calcularSalario() > salario)
                cant++;
        }
        return cant;
    }
}
