package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.Vacaciones;
import com.componentes.contracts.ICrud;
import java.sql.SQLException;

public class VacacionService implements ICrud<Vacaciones> {

    @Override
    public void create(EntityManager em, Vacaciones obj) throws SQLException {
        em.getTransaction().begin();

        em.persist(obj);

        em.getTransaction().commit();
    }

    @Override
    public Vacaciones read(EntityManager em, int id) throws SQLException {
        Vacaciones response = em.find(Vacaciones.class, id);
        if (response != null) {
            return response;
        }
        return null;
    }

    @Override
    public void update(EntityManager em, int id) throws SQLException {
        em.getTransaction().begin();

        Vacaciones response = em.find(Vacaciones.class, id);
        if (response != null) {
            em.merge(response);
        }

        em.getTransaction().commit();
    }

    @Override
    public void delete(EntityManager em, int id) throws SQLException {
        em.getTransaction().begin();

        Vacaciones response = em.find(Vacaciones.class, id);
        if (response != null) {
            em.remove(response);
        }

        em.getTransaction().commit();
    }

    @Override
    public List<Vacaciones> readAll(EntityManager em) throws SQLException {
        String jpql = "SELECT t FROM " + Vacaciones.class.getSimpleName() + " t";
        List<Vacaciones> lista = em.createQuery(jpql, Vacaciones.class).getResultList();
        return lista;
    }

    @Override
    public List<Vacaciones> readAllByUser(EntityManager em, int id) throws SQLException {
        em.getTransaction().begin();

        String jpql = "SELECT c FROM Vacaciones c WHERE c.usuario_id = :id";
        List<Vacaciones> lista = em.createQuery(jpql, Vacaciones.class)
                .setParameter("id", id)
                .getResultList();

        em.getTransaction().commit();

        return lista;
    }

}
