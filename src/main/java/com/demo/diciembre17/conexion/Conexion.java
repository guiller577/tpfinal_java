/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.diciembre17.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author santi
 */
public class Conexion {
    private static Connection con = null;

    private Conexion() {
    }

/*    public static Connection obtenerConexion() {
        if (con == null) {
            try {
                // Parámetros de conexión
                String url = "jdbc:mysql://localhost:3306/prueba18";
                String usuario = "root";
                String contraseña = "";

                // Registro del driver de MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Estableciendo la conexión
                con = DriverManager.getConnection(url, usuario, contraseña);
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
                // Manejar la excepción
            }
        }
        return con;
    } */
    
     public static Connection obtenerConexion() {
        Connection conn = null;
        try {
            // Parámetros de conexión
            String url = "jdbc:mysql://localhost:3306/prueba18?useSSL=false";
            String usuario = "root";
            String contraseña = "";

            // Registro del driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estableciendo la conexión
            conn = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            // Manejar la excepción
        }
        return conn;
    }

    public static void cerrarConexion() {
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (SQLException e) {
                e.printStackTrace();
                // Manejar la excepción
            }
        }
    }
}
