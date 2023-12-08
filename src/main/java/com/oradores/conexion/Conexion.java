package com.oradores.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    //Objeto conectar inicializado en nulo
    Connection conectar = null;

    //Datos
    String user = "root";
    String password = "";
    String bd = "integrador_cac";
    String ip = "localhost";
    String puerto = "3306";
    String URL = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;

    //Metodo para establecer conexion
    public Connection establecerConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(URL, user, password);

            if(conectar != null){
                System.out.println("Conexion exitosa a la base de datos");
            }else{
                System.out.println("Error al conectar con la base de datos");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conectar;
    }
}
