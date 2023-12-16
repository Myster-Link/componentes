package com.componentes.controllers;

import com.componentes.entitys.Usuarios;
import com.componentes.enums.Rol;
import com.componentes.services.UsuariosServicio;

import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;

public class AuthController {

    private UsuariosServicio usuariosServicio;

    public AuthController() {
        this.usuariosServicio = new UsuariosServicio();
    }

    public boolean login() {
        EntityManager em = null;
        try {
            em = PersistenceManager.getEntityManager("BackCompPU");

            LocalDateTime fechaHora = LocalDateTime.now();

            // Lógica de autenticación, si es necesario
            Usuarios usuarios = new Usuarios();
            usuarios.setNombre("Adriana");
            usuarios.setCorreo("Adriana@gmail.com");
            usuarios.setClave("123");
            usuarios.setCedula(2021441);
            usuarios.setDireccion("barrio paw");
            usuarios.setSexo('F');
            usuarios.setRol(Rol.ADMINISTRADOR);
            usuarios.setFechaRegistro(fechaHora);
            usuariosServicio.insertar(em, usuarios);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            PersistenceManager.closeEntityManager(em);
        }
        return true;
    }
}
