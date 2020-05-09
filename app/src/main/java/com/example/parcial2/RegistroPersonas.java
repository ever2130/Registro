package com.example.parcial2;

public class RegistroPersonas {
    private String cedula;
    private String nombre;
    private String estrato;
    private String salario;
    private String NEducativo;

    public RegistroPersonas(String cedula, String nombre, String estrato, String salario, String NEducativo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.estrato = estrato;
        this.salario = salario;
        this.NEducativo = NEducativo;
    }

    public RegistroPersonas(String nombre, String estrato, String salario, String NEducativo) {
        this.nombre = nombre;
        this.estrato = estrato;
        this.salario = salario;
        this.NEducativo = NEducativo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getNEducativo() {
        return NEducativo;
    }

    public void setNEducativo(String NEducativo) {
        this.NEducativo = NEducativo;
    }


    }

