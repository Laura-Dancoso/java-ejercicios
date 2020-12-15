package com.company;

public class Categoria {
    private int numero;
    private String nombre;
    private double factor;

    public Categoria(){};

    public Categoria(int numero, String nombre, double factor) {
        this.numero = numero;
        this.nombre = nombre;
        this.factor = factor;
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
