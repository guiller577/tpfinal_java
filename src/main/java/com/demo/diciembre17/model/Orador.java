/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.diciembre17.model;

/**
 *
 * @author santi
 */
public class Orador {
  private int id;
  private String nombre;
  private String apellido;
  private String tema;

  public Orador(int id, String nombre, String apellido, String tema) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.tema = tema;
  }

  public Orador() {
  }

  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public String getTema() {
    return tema;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public void setTema(String tema) {
    this.tema = tema;
  }

  public void setId(int id) {
    this.id = id;
  }

  /*
   * @Override
   * public String toString() {
   * return "Orador{" + "nombre=" + nombre + ", apellido=" + apellido + ", tema="
   * + tema + '}';
   * }
   */
}
