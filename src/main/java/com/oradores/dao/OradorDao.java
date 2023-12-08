package com.oradores.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import com.oradores.conexion.Conexion;
import com.oradores.model.Orador;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;

public class OradorDao{

    public List<Orador> getOradores() {
        //Creo lista de oradores
         List<Orador> oradores = new ArrayList<>();
        //Creo objeto conexion
        Conexion conexion = new Conexion();
        //Query para buscar todos los objeto en la base de datos
        String query = "SELECT * FROM oradores";

        try {
            //Compruebo conexion y preparo llamada a la base de datos 
            Statement conexionDb = conexion.establecerConexion().createStatement();

            ResultSet resultSet = conexionDb.executeQuery(query);

            while (resultSet.next()) {
                //Obtengo valores de los oradores
                Integer id = resultSet.getInt("id"); 
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String tema = resultSet.getString("tema");

                //Creo objeto orador
                Orador orador = new Orador(id, nombre, apellido, tema);
                //Almaceno dicho objeto al ArrayList
                oradores.add(orador);
            }
        } catch (Exception e) {
            System.out.println("Error al traer los objetos"+e.toString());
        }
        return oradores;
        /* CODIGO ANTIGUO
        List<Orador> oradores = new ArrayList<Orador>();
        Orador orador = new Orador(1, "Victor", "Kalich", "Java");
        oradores.add(orador);
        return oradores;
        */
    }
    public Orador buscarOrador(Integer id){
        Orador orador = null;
        //Creo objeto conexion
        Conexion conexion = new Conexion();
        //Query para buscar el objeto en la base de datos
        String query = "SELECT  id, nombre, apellido, tema FROM oradores WHERE id = ?";
        
        try {
            //Compruebo conexion y preparo llamada a la base de datos 
            PreparedStatement conexionDb = conexion.establecerConexion().prepareStatement(query);
            conexionDb.setInt(1, id);
            
            try (ResultSet resultSet = conexionDb.executeQuery()) {
                // Verifico si se encontró un resultado
                if (resultSet.next()) {
                    Integer idOrador = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    String tema = resultSet.getString("tema");
    
                    orador = new Orador(idOrador, nombre, apellido, tema);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el objeto: "+e.toString());
        }
        return orador;
    }

    public void createOrador(Orador orador) {
        //Creo objeto conexion
        Conexion conexion = new Conexion();
        //Query para insertar el objeto a la base de datos
        String query = "INSERT INTO oradores(nombre, apellido, tema) VALUES(?,?,?)";
    
        try {
            //Compruebo conexion y preparo llamada a la base de datos 
            CallableStatement conexionDb = conexion.establecerConexion().prepareCall(query);
            
            //Establezco valores
            conexionDb.setString(1, orador.getNombre());
            conexionDb.setString(2, orador.getApellido());
            conexionDb.setString(3, orador.getTema());

            //Ejecuto la consulta
            conexionDb.execute();

            //Mensaje para comprobar si se ingreso el objeto (luego borrar este mensaje)
            System.out.println("Se inserto el objeto orador");
            
        } catch (Exception e) {
            System.out.println("Error al insertar el objeto: "+e.toString());
        }
    }

    public void update(Orador orador) {
        //Creo objeto conexion
        Conexion conexion = new Conexion();
        //Query para modificar el objeto de la base de datos
        String query = "UPDATE oradores SET nombre = ?, apellido = ?, tema = ? WHERE id = ?";

        try {
            CallableStatement conexionDb = conexion.establecerConexion().prepareCall(query);
            conexionDb.setString(1, orador.getNombre());
            conexionDb.setString(2, orador.getApellido());
            conexionDb.setString(3, orador.getTema());

            //Ejecuto la consulta
            conexionDb.execute();

            //Mensaje para comprobar si se modifico el objeto (luego borrar este mensaje)
            System.out.println("Se modifico el objeto orador");

        } catch (Exception e) {
           System.out.println("Error al modificar el objeto: "+e.toString());
        }
    }

    public void delete(Integer id) {
        //Creo objeto conexion
        Conexion conexion = new Conexion();
        //Query para eliminar el objeto de la base de datos
        String query = "DELETE FROM oradores WHERE id = ?";

        try {
            CallableStatement conexionDb = conexion.establecerConexion().prepareCall(query);
            conexionDb.setInt(1, id);

            //Ejecuto la consulta
            conexionDb.execute();

            //Mensaje para comprobar si se elimino el objeto (luego borrar este mensaje)
            System.out.println("Se elimino el objeto orador");

        } catch (Exception e) {
           System.out.println("Error al eliminar el objeto: "+e.toString());
        }
    }
}
