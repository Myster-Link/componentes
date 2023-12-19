package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.Asignaciones;
import com.componentes.contracts.ICrud;
import java.sql.SQLException;

public class AsignacionService implements ICrud<Asignaciones> {

    @Override
    public void create(EntityManager em, Asignaciones obj) throws SQLException {
        em.getTransaction().begin();

        em.persist(obj);

        em.getTransaction().commit();
    }

    @Override
    public Asignaciones read(EntityManager em, int id) throws SQLException {
        Asignaciones response = em.find(Asignaciones.class, id);
        if (response != null) {
            return response;
        }
        return null;
    }

    @Override
    public void update(EntityManager em, Asignaciones obj) throws SQLException {
        em.getTransaction().begin();

        em.merge(obj);

        em.getTransaction().commit();
    }

    @Override
    public void delete(EntityManager em, int id) throws SQLException {
        em.getTransaction().begin();

        Asignaciones response = em.find(Asignaciones.class, id);
        if (response != null) {
            em.remove(response);
        }

        em.getTransaction().commit();
    }

    @Override
    public List<Asignaciones> readAll(EntityManager em) throws SQLException {
        String jpql = "SELECT t FROM " + Asignaciones.class.getSimpleName() + " t";
        List<Asignaciones> lista = em.createQuery(jpql, Asignaciones.class).getResultList();
        return lista;
    }

    @Override
    public List<Asignaciones> readAllByUser(EntityManager em, int id) throws SQLException {
        em.getTransaction().begin();

        String jpql = "SELECT c FROM Asignaciones c WHERE c.usuario_id = :id";
        List<Asignaciones> lista = em.createQuery(jpql, Asignaciones.class)
                .setParameter("id", id)
                .getResultList();

        em.getTransaction().commit();

        return lista;
    }
}
