package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.Proyectos;
import com.componentes.contracts.ICrud;
import java.sql.SQLException;

public class ProyectoService implements ICrud<Proyectos> {

    @Override
    public Proyectos encontrarPK(EntityManager em, Proyectos obj) throws SQLException {
        Proyectos proyectosLocalizado = em.find(Proyectos.class, obj);
        if (proyectosLocalizado != null) {
            return proyectosLocalizado;
        }
        return null;
    }

    @Override
    public List<Proyectos> listar(EntityManager em) throws SQLException {
        String jpql = "SELECT t FROM " + Proyectos.class.getSimpleName() + " t";
        List<Proyectos> lista = em.createQuery(jpql, Proyectos.class).getResultList();
        return lista;
    }

    @Override
    public void insertar(EntityManager em, Proyectos obj) throws SQLException {
        try {
            em.getTransaction().begin();

            em.persist(obj);

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(EntityManager em, Proyectos obj) throws SQLException {
        em.getTransaction().begin();

        em.remove(obj);

        em.getTransaction().commit();
    }

    @Override
    public void modificar(EntityManager em, Proyectos obj) throws SQLException {
        em.getTransaction().begin();

        em.merge(obj);

        em.getTransaction().commit();
    }

}
