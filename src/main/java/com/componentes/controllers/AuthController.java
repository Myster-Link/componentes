package com.componentes.controllers;

import com.componentes.entitys.Usuarios;
import com.componentes.services.UsuariosServicio;

import jakarta.persistence.EntityManager;

public class AuthController {

    EntityManager em = null;
    private UsuariosServicio usuariosServicio;

    public AuthController() {
        this.usuariosServicio = new UsuariosServicio();

        if (em == null) {
            em = PersistenceManager.getEntityManager("BackCompPU");
        }
    }

    public boolean login(Usuarios usuarios) {
        try {
            usuariosServicio.insertar(em, usuarios);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            PersistenceManager.closeEntityManager(em);
        }
    }

    public boolean register(Usuarios usuarios) {
        try {
            usuariosServicio.insertar(em, usuarios);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            PersistenceManager.closeEntityManager(em);
        }
    }
}
