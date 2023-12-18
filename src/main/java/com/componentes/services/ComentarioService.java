package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.Comentario;
import com.componentes.contracts.ICrud;
import java.sql.SQLException;

public class ComentarioService implements ICrud<Comentario> {

    @Override
    public void create(EntityManager em, Comentario obj) throws SQLException {
        em.getTransaction().begin();

        em.persist(obj);

        em.getTransaction().commit();
    }

    @Override
    public Comentario read(EntityManager em, int id) throws SQLException {
        Comentario response = em.find(Comentario.class, id);
        if (response != null) {
            return response;
        }
        return null;
    }

    @Override
    public void update(EntityManager em, int id) throws SQLException {
        em.getTransaction().begin();

        Comentario response = em.find(Comentario.class, id);
        if (response != null) {
            em.merge(response);
        }

        em.getTransaction().commit();
    }

    @Override
    public void delete(EntityManager em, int id) throws SQLException {
        em.getTransaction().begin();

        Comentario response = em.find(Comentario.class, id);
        if (response != null) {
            em.remove(response);
        }

        em.getTransaction().commit();
    }

    @Override
    public List<Comentario> readAll(EntityManager em) throws SQLException {
        String jpql = "SELECT t FROM " + Comentario.class.getSimpleName() + " t";
        List<Comentario> lista = em.createQuery(jpql, Comentario.class).getResultList();
        return lista;
    }

    @Override
    public List<Comentario> readAllByUser(EntityManager em, int id) throws SQLException {
        em.getTransaction().begin();

        String jpql = "SELECT c FROM Comentario c WHERE c.usuario_id = :id";
        List<Comentario> lista = em.createQuery(jpql, Comentario.class)
                .setParameter("id", id)
                .getResultList();

        em.getTransaction().commit();

        return lista;
    }
}
