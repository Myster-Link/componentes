package com.componentes.controllers;

import com.componentes.entitys.Usuarios;
import com.componentes.enums.Rol;
import com.componentes.services.UsuarioService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import java.time.LocalDateTime;

public class AuthController {

    private EntityManager em = null;
    private UsuarioService usuariosServicio;
    private Usuarios usuarioObtenido;

    public AuthController() {
        this.usuariosServicio = new UsuarioService();

        if (em == null) {
            em = PersistenceManager.getEntityManager("BackCompPU");
        }
    }

    public boolean login(Usuarios usuarios) {
        try {
            usuarioObtenido = usuariosServicio.encontrarPorCedula(em, usuarios.getCedula());

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
