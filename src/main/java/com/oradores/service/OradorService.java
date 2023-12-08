package com.oradores.service;

import com.oradores.dao.OradorDao;
import com.oradores.model.Orador;

import java.util.List;

public class OradorService {

    private OradorDao oradorDao = new OradorDao();

    public List<Orador> getOradores() {
        return oradorDao.getOradores();
    }

    public Orador crearOrador(Orador orador) {
        //llama al dao y retorna el id del orador creador
        return null;
    }

    public void update(Orador orador) {
        //llamar al dao para actualizar el orador
    }

    public void delete(int id) {
        //llamar al dao y eliminar el orado con el id que llega por parametro
    }
}
