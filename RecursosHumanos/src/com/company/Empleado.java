package com.company;

public abstract class Empleado {
    private static int puntero;
    protected int legajo;
    protected String dni;
    protected String nombre;
    protected String apellido;

    public Empleado(){
        legajo = puntero++;
    }
    public Empleado(String dni, String nombre, String apellido){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        legajo = puntero++;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return  "legajo=" + legajo +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'';
    }

    protected abstract double calcularSalario();

}

