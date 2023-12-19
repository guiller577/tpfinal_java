/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.diciembre17.pruebaConexion;

import com.demo.diciembre17.DAO.OradorDAO;
import com.demo.diciembre17.conexion.Conexion;
import com.demo.diciembre17.model.Orador;
import java.util.*;

public class PruebaConexion {

  public static void main(String[] args) {
    OradorDAO oradorDAO = new OradorDAO();

    // Probar obtenerOradores varias veces
    for (int i = 0; i < 3; i++) { // Cambia el 3 por el número de veces que quieras probar
      System.out.println("Prueba " + (i + 1));
      List<Orador> oradores = oradorDAO.obtenerOradores();
      for (Orador orador : oradores) {
        System.out.println("Id: " + orador.getId() + ", Nombre: " + orador.getNombre() + ", Apellido: "
            + orador.getApellido() + ", Tema: " + orador.getTema());
      }
      System.out.println("---------------------------------------------------");
    }

    Orador nuevoOrador = new Orador();
    nuevoOrador.setNombre("Nombre");
    nuevoOrador.setApellido("Apellido");
    nuevoOrador.setTema("Tema");
    Orador nuevoOrador2 = new Orador();
    nuevoOrador2.setNombre("Nombre");
    nuevoOrador2.setApellido("Apellido");
    nuevoOrador2.setTema("Tema");

    oradorDAO.insertarOrador(nuevoOrador);
    System.out.println("Orador insertado");

    oradorDAO.insertarOrador(nuevoOrador2);
    System.out.println("Orador insertado");

    System.out.println("Orador insertado");
    // Cerrar la conexión
    Conexion.cerrarConexion();
    System.out.println("Conexión cerrada");
  }

}
