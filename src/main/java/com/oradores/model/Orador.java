package com.oradores.model;

public class Orador {
    private int id;
    private String nombre;
    private String apellido;
    private String tema;

    public Orador() {
    }

    public Orador(int id, String nombre, String apellido, String tema) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tema = tema;
    }

    public int getId() {
        return id;
    }

    public Orador setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Orador setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellido() {
        return apellido;
    }

    public Orador setApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public String getTema() {
        return tema;
    }

    public Orador setTema(String tema) {
        this.tema = tema;
        return this;
    }
}
