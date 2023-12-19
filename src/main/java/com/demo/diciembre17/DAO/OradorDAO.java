package com.demo.diciembre17.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.demo.diciembre17.conexion.Conexion;
import com.demo.diciembre17.model.Orador;

public class OradorDAO {

  public void insertarOrador(Orador orador) {
    String sql = "INSERT INTO oradores (nombre, apellido, tema) VALUES (?, ?, ?)";
    try (Connection conn = Conexion.obtenerConexion();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, orador.getNombre());
      pstmt.setString(2, orador.getApellido());
      pstmt.setString(3, orador.getTema());
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Orador> obtenerOradores() {
    List<Orador> oradores = new ArrayList<>();
    String sql = "SELECT id, nombre, apellido, tema FROM oradores";
    try (Connection conn = Conexion.obtenerConexion();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {

      while (rs.next()) {
        Orador orador = new Orador();
        orador.setId(rs.getInt("id"));
        orador.setNombre(rs.getString("nombre"));
        orador.setApellido(rs.getString("apellido"));
        orador.setTema(rs.getString("tema"));
        oradores.add(orador);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return oradores;
  }

  public Orador eliminarOrador(int id) {
    Orador orador = new Orador();
    String sql = "DELETE FROM oradores WHERE id = ?";
    try (Connection conn = Conexion.obtenerConexion();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setInt(1, id);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return orador;
  }

  public Orador actualizarOrador(Orador orador) {
    String sql = "UPDATE oradores SET nombre = ?, apellido = ?, tema = ? WHERE id = ?";
    try (Connection conn = Conexion.obtenerConexion();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setString(1, orador.getNombre());
      pstmt.setString(2, orador.getApellido());
      pstmt.setString(3, orador.getTema());
      pstmt.setInt(4, orador.getId());
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return orador;
  }

  public Orador obtenerOradorPorId(int id) {
    Orador orador = new Orador();
    String sql = "SELECT id, nombre, apellido, tema FROM oradores WHERE id = ?";
    try (Connection conn = Conexion.obtenerConexion();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setInt(1, id);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        orador.setId(rs.getInt("id"));
        orador.setNombre(rs.getString("nombre"));
        orador.setApellido(rs.getString("apellido"));
        orador.setTema(rs.getString("tema"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return orador;
  }

}
