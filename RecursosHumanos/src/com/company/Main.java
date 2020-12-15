package com.company;

public class Main {

    public static void main(String[] args) {
        RecursosHumanos rh = new RecursosHumanos();
        rh.agregarEmpleado(new Contratado("1122222","pepe","argento",new Categoria(1,"Uno",2.3),2.3));
        rh.agregarEmpleado(new Efectivo("40808","moni","argento",2.3,4,true));
        rh.agregarEmpleado(new Efectivo("38808","ga","argento",29.3,4,true));
        rh.agregarEmpleado(new Efectivo("35808","gon","argento",266.3,14,false));
        System.out.println("RH");
        System.out.println(rh);
        rh.eliminarEmpleado(1);
        System.out.println("RH-1");
        System.out.println(rh);
        System.out.println("mayor salario:");
        System.out.println(rh.calcularMayorSalario());
        System.out.println("contar x cat:");
        System.out.println(rh.contarPorCategoria());
        System.out.println("cantidad con salario mayor a x:");
        System.out.println(rh.calcularCantidadSalarioMayorA(12.3));
    }
}
