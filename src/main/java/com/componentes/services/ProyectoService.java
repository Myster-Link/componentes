package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.Proyectos;
import com.componentes.contracts.ICrud;
import java.sql.SQLException;

public class ProyectoService implements ICrud<Proyectos> {

    @Override
    public void create(EntityManager em, Proyectos obj) throws SQLException {
        em.getTransaction().begin();

        em.persist(obj);

        em.getTransaction().commit();
    }

    @Override
    public Proyectos read(EntityManager em, int id) throws SQLException {
        return em.find(Proyectos.class, id);
    }

    @Override
    public void update(EntityManager em, Proyectos obj) throws SQLException {
        em.getTransaction().begin();

        em.merge(obj);

        em.getTransaction().commit();
    }

    @Override
    public void delete(EntityManager em, int id) throws SQLException {
        em.getTransaction().begin();

        Proyectos response = em.find(Proyectos.class, id);
        if (response != null) {
            em.remove(response);
        }

        em.getTransaction().commit();
    }

    @Override
    public List<Proyectos> readAll(EntityManager em) throws SQLException {
        String jpql = "SELECT t FROM " + Proyectos.class.getSimpleName() + " t";
        List<Proyectos> lista = em.createQuery(jpql, Proyectos.class).getResultList();
        return lista;
    }

    @Override
    public List<Proyectos> readAllByUser(EntityManager em, int id) throws SQLException {
        em.getTransaction().begin();

        String jpql = "SELECT c FROM Proyectos c WHERE c.usuario_id = :id";
        List<Proyectos> lista = em.createQuery(jpql, Proyectos.class)
                .setParameter("id", id)
                .getResultList();

        em.getTransaction().commit();

        return lista;
    }
}
