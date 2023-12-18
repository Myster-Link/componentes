package com.componentes.controllers;

import com.componentes.entitys.Usuarios;
import com.componentes.enums.Rol;
import com.componentes.services.UsuarioService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import java.sql.SQLException;
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

    public Usuarios login(Usuarios usuarios) {
        try {
            usuarioObtenido = usuariosServicio.readAllByCedula(em, usuarios.getCedula());

            if (usuarioObtenido.getClave().equals(usuarios.getClave())) {
                return usuarioObtenido;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            PersistenceManager.closeEntityManager(em);
        }
        return null;
    }

    public boolean register(Usuarios usuarios) {
        try {
            usuarios.setRol(Rol.ADMINISTRADOR);
            usuarios.setFechaRegistro(LocalDateTime.now());
            usuariosServicio.create(em, usuarios);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            PersistenceManager.closeEntityManager(em);
        }
    }
}
