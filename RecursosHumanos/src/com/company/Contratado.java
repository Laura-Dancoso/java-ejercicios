package com.company;

public class Contratado extends Empleado{

    private Categoria categoria;
    private double horasTrabajadas;

    public Contratado() {
        super();
    }

    public Contratado(String dni, String nombre, String apellido, Categoria categoria, double horasTrabajadas) {
        //super() llama al constructor de la clase padre!! (por eso le asigno esos parámetros)
        super(dni, nombre, apellido);
        this.categoria = categoria;
        this.horasTrabajadas = horasTrabajadas;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public String toString() {
        return "Contratado{" + super.toString() +
                "categoria=" + categoria +
                ", horasTrabajadas=" + horasTrabajadas +
                '}';
    }

    @Override
    public double calcularSalario() {
        return categoria.getFactor() * horasTrabajadas;
    }
}

