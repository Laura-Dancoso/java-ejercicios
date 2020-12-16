package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static RecursosHumanos rh = new RecursosHumanos();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenidos al Sistema de RRHH");
        int opcion;
        do{
            System.out.println("Ingrese: ");
            System.out.println("1-Agregar empleado");
            System.out.println("2-Eliminar empleado");
            System.out.println("3-Visualizar empleados");
            System.out.println("4-Visualizar empleado con mayor salario");
            System.out.println("5-Visualizar cantidad de empleados contratados por categoría");
            System.out.println("6-Visualizar cantidad de empleados con mayor salario a");
            System.out.println("0-Cerrar programa");
            opcion= scan.nextInt();

            switch (opcion){
                case 1:
                    agregarEmpleado();
                    break;
                case 2:
                    eliminarEmpleado();
                    break;
                case 3:
                    visualizarListaEmpleados();
                    break;
                case 4:
                    calcularMayorSalario();
                    break;
                case 5:
                    mostrarEmpleadosPorCategoria();
                    break;
                case 6:
                    mostrarCantEmpleadosConSalarioMayorA();
                    break;
                case 0:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo");
                    break;
            }

        }while(opcion!=0);

    }

    //1 Agregar empleado
    public static void agregarEmpleado(){
        System.out.println("Ingrese el tipo de empleado (1-:Efectivo,2-Contratado)");
        Empleado e=null;
        try {
            int tipoEmpleado = scan.nextInt();
            System.out.println("Ingrese nombre");
            String nombre = scan.next();
            System.out.println("Ingrese apellido");
            String apellido = scan.next();
            System.out.println("Ingrese dni");
            String dni = scan.next();
            if(tipoEmpleado==1){
                System.out.println("Ingrese el básico");
                double basico = scan.nextDouble();
                System.out.println("Ingrese antiguadedad");
                int antig = scan.nextInt();
                System.out.println("Ingrese 0 si realiza aportes o 1 si no");
                int repartoInt = scan.nextInt();
                // boolean reparto = repartoInt == 0 ? true : false; es lo mismo que:
                boolean reparto = repartoInt == 0;
                e=new Efectivo(dni,nombre,apellido,basico, antig ,reparto);
            }else if(tipoEmpleado ==2){
                System.out.println("Ingrese categoria(1-docente 2-adm 3-maestranza");
                int cat= scan.nextInt();
                System.out.println("Cantidad de horas trabajadas/a trabajar");
                double cantHoras= scan.nextDouble();
                e=new Contratado(nombre,apellido,dni,new Categoria(cat),cantHoras);
            }
            if (e!=null) rh.agregarEmpleado(e);
            visualizarListaEmpleados();
        }catch (InputMismatchException exception){
            System.out.println("Dato no válido, intente nuevamente");
        }
    }
    //2 Visualizar lista
    public static void visualizarListaEmpleados(){
        System.out.println("Cargando lista de empleados.....");
        System.out.println(rh);
    }
    //3 Eliminar lista
    public static void eliminarEmpleado(){
        System.out.println("Ingrese nro legajo del empleado a eliminar");
        try {
            int legajo = scan.nextInt();
            System.out.println((rh.eliminarEmpleado(legajo)) ? "Empleado eliminado": "error, no existe legajo");
        }catch (InputMismatchException exception){
            System.out.println("Dato no válido, intente nuevamente");
        }
    }
    //4 Calcular mayor salario
    public static void calcularMayorSalario(){
        System.out.println("El empleado con mayor salario es: " + rh.calcularMayorSalario());
    }
    //5 Empleados por caategoria
    public static void mostrarEmpleadosPorCategoria(){
        int[] vec  = rh.contarPorCategoria();
        for(int i = 0; i<vec.length;i++){
            System.out.println(" - De la categoría" + (i+1) + "hay " + vec[i] + " empleado/s");
        }
    }
    //6 Cantidad de empleados con salario mayor a x
    public static void mostrarCantEmpleadosConSalarioMayorA(){
        System.out.println("Ingrese el salario a comparar:");
        try {
            double salario = scan.nextDouble();
            System.out.println((rh.calcularCantidadSalarioMayorA(salario)>1) ? "Hay" + rh.calcularCantidadSalarioMayorA(salario) + "empleado/s con salario mayor a " + salario : "No hay empleados con un salario mayor a : " + salario);
        }catch (InputMismatchException exception){
            System.out.println("Dato no válido, intente nuevamente");
        }
        }
}
