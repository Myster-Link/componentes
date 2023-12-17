package com.componentes.controllers;

import com.componentes.entitys.Usuarios;
import com.componentes.enums.Rol;
import com.componentes.services.UsuariosServicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import java.time.LocalDateTime;

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
            Usuarios usuarioObtenido = usuariosServicio.encontrarPorCedula(em, usuarios.getCedula());

            if (usuarioObtenido.getClave().equals(usuarios.getClave())) {
                return true;
            }
        } catch (NoResultException e) {
            e.printStackTrace();
            return false;
        } finally {
            PersistenceManager.closeEntityManager(em);
        }
        return false;
    }

    public boolean register(Usuarios usuarios) {
        try {
            usuarios.setRol(Rol.USUARIO);
            usuarios.setFechaRegistro(LocalDateTime.now());
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
