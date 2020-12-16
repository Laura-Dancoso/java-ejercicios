package com.company;

public class Categoria {
    private int numero;
    private String nombre;
    private double factor;

    public Categoria(){}

    public Categoria(int numero) {
        this.numero = numero;
        switch (numero){
            case 1:
                nombre = "Docente";
                factor= 350;
                break;
            case 2:
                nombre="Administrativo";
                factor= 450;
                break;
            case 3:
                nombre="Maestranza";
                factor= 500;
                break;
            default:
                nombre="";
                factor=0;
                break;
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", factor=" + factor +
                '}';
    }
}
