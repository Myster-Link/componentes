package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.Usuarios;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import com.componentes.contracts.ICrud;
import java.sql.SQLException;

public class UsuarioService implements ICrud<Usuarios> {

    @Override
    public void create(EntityManager em, Usuarios obj) throws SQLException {
        em.getTransaction().begin();

        em.persist(obj);

        em.getTransaction().commit();
    }

    @Override
    public Usuarios read(EntityManager em, int id) throws SQLException {
        Usuarios response = em.find(Usuarios.class, id);
        if (response != null) {
            return response;
        }
        return null;
    }

    @Override
    public void update(EntityManager em, Usuarios obj) throws SQLException {
        em.getTransaction().begin();

        em.merge(obj);
        
        em.getTransaction().commit();
    }

    @Override
    public void delete(EntityManager em, int id) throws SQLException {
        em.getTransaction().begin();

        Usuarios response = em.find(Usuarios.class, id);
        if (response != null) {
            em.remove(response);
        }

        em.getTransaction().commit();
    }

    @Override
    public List<Usuarios> readAll(EntityManager em) throws SQLException {
        String jpql = "SELECT t FROM " + Usuarios.class.getSimpleName() + " t";
        List<Usuarios> lista = em.createQuery(jpql, Usuarios.class).getResultList();
        return lista;
    }

    @Override
    public List<Usuarios> readAllByUser(EntityManager em, int id) throws SQLException {
        em.getTransaction().begin();

        String jpql = "SELECT c FROM Usuarios c WHERE c.usuario_id = :id";
        List<Usuarios> lista = em.createQuery(jpql, Usuarios.class)
                .setParameter("id", id)
                .getResultList();

        em.getTransaction().commit();

        return lista;
    }

    public Usuarios readAllByCedula(EntityManager em, int cedula) throws SQLException {
        em.getTransaction().begin();

        String jpql = "SELECT u FROM " + Usuarios.class.getSimpleName() + " u WHERE u.cedula = :cedula";
        Usuarios response = em.createQuery(jpql, Usuarios.class)
                .setParameter("cedula", cedula)
                .getSingleResult();

        em.getTransaction().commit();

        return response;
    }

}
