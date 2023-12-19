package com.tpfinal.orador.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection con = null;

    private Conexion() {
    }

    public static Connection obtenerConexion() {
        Connection conn = null;
        try {
            // Parámetros de conexión
            String url = "jdbc:mysql://localhost:3306/tp_final_java_cac?useSSL=false";
            String usuario = "root";
            String contraseña = "";

            // Registro del driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, usuario, contraseña);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
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
            }
        }
    }
}
