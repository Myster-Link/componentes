package com.componentes.backcompo;

import com.componentes.enums.Rol;
import com.componentes.entitys.Usuarios;
import com.componentes.services.UsuariosServicio;

import jakarta.persistence.*;
import java.time.LocalDateTime;

public class BackCompo {

    private static EntityManagerFactory entityManagerFactory = null;

    public static void main(String[] args) {
        EntityManager em = null;
        try {
            startEntityManagerFactory("BackCompPU");

            em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();

            LocalDateTime fechaHora = LocalDateTime.now();

            Usuarios usuarios = new Usuarios();
            usuarios.setNombre("Adriana");
            usuarios.setCorreo("Adriana@gmail.com");
            usuarios.setClave("123");
            usuarios.setCedula(2021441);
            usuarios.setDireccion("barrio paw");
            usuarios.setSexo('F');
            usuarios.setRol(Rol.ADMINISTRADOR);
            usuarios.setFechaRegistro(fechaHora);

            UsuariosServicio us = new UsuariosServicio();
            us.insertar(em, usuarios);

            em.getTransaction().commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
            stopEntityManagerFactory();
        }
    }

    public static void startEntityManagerFactory(String persistenceUnit) {
        if (entityManagerFactory == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void stopEntityManagerFactory() {
        if (entityManagerFactory != null) {
            if (entityManagerFactory.isOpen()) {
                try {
                    entityManagerFactory.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            entityManagerFactory = null;
        }
    }
}
