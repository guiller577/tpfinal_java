package com.oradores;

import com.oradores.conexion.Conexion;

public class TestOrador{
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();
    }
}
