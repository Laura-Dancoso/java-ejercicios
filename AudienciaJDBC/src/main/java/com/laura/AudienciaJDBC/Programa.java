package com.laura.AudienciaJDBC;

import java.time.LocalTime;

public class Programa {

    private int id;
    private String nombre;
    private LocalTime horaEmision;
    private int tipoPrograma;
    private int radioEmisora;
    private int audiencia;

    public Programa(){}
    public Programa(String nombre, LocalTime horaEmision, int tipoPrograma, int radioEmisora, int audiencia) {
        this.nombre = nombre;
        this.horaEmision = horaEmision;
        this.tipoPrograma = tipoPrograma;
        this.radioEmisora = radioEmisora;
        this.audiencia = audiencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHoraEmision() {
        return horaEmision;
    }

    public void setHoraEmision(LocalTime horaEmision) {
        this.horaEmision = horaEmision;
    }

    public int getTipoPrograma() {
        return tipoPrograma;
    }

    public void setTipoPrograma(int tipoPrograma) {
        this.tipoPrograma = tipoPrograma;
    }

    public int getRadioEmisora() {
        return radioEmisora;
    }

    public void setRadioEmisora(int radioEmisora) {
        this.radioEmisora = radioEmisora;
    }

    public int getAudiencia() {
        return audiencia;
    }

    public void setAudiencia(int audiencia) {
        this.audiencia = audiencia;
    }

    @Override
    public String toString() {
        return "Programa{" +
                "nombre='" + nombre + '\'' +
                ", horaEmision=" + horaEmision +
                ", tipoPrograma=" + tipoPrograma +
                ", radioEmisora=" + radioEmisora +
                ", audiencia=" + audiencia +
                '}';
    }
}
