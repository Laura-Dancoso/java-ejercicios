package com.company;

public class Efectivo extends Empleado{

    private double basico;
    private int antiguedad;
    private boolean reparto;

    public Efectivo(double basico, int antiguedad, boolean reparto) {
        super();
    }

    public Efectivo(String dni, String nombre, String apellido, double basico, int antiguedad, boolean reparto) {
        super(dni, nombre, apellido);
        this.basico = basico;
        this.antiguedad = antiguedad;
        this.reparto = reparto;
    }

    public double getBasico() {
        return basico;
    }

    public void setBasico(double basico) {
        this.basico = basico;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public boolean isReparto() {
        return reparto;
    }

    public void setReparto(boolean reparto) {
        this.reparto = reparto;
    }

    @Override
    public String toString() {
        return "Efectivo{" +super.toString()+
                "basico=" + basico +
                ", antiguedad=" + antiguedad +
                ", reparto=" + reparto +
                '}';
    }

    @Override
    public double calcularSalario() {
        double salario = (0.05 * antiguedad) * basico + basico;
        return  (reparto) ? salario * 0.8  : salario;
    }
}

