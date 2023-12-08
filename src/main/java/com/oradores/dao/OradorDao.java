package com.oradores.dao;

import com.oradores.model.Orador;

import java.util.ArrayList;
import java.util.List;

public class OradorDao {

    public List<Orador> getOradores() {
        List<Orador> oradores = new ArrayList<Orador>();
        Orador orador = new Orador(1, "Victor", "Kalich", "Java");
        oradores.add(orador);
        return oradores;
    }

    public Orador createOrador(Orador orador) {
        //Hacer el insert y con el id que retorna se lo seteamos al orador que llega y lo retornamos.
        return orador;
    }

    public void update(Orador orador) {
        //Actualizar con el orador que llega.
    }

    public void delete(int id) {
        //Borrar el orador con el id que llega.
    }
}
