package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.Empleados;
import com.componentes.contracts.ICrud;
import jakarta.persistence.TypedQuery;
import java.sql.SQLException;

public class EmpleadoService implements ICrud<Empleados> {

    @Override
    public void create(EntityManager em, Empleados obj) throws SQLException {
        em.getTransaction().begin();

        em.persist(obj);

        em.getTransaction().commit();
    }

    @Override
    public Empleados read(EntityManager em, int id) throws SQLException {
        Empleados response = em.find(Empleados.class, id);
        if (response != null) {
            return response;
        }
        return null;
    }

    @Override
    public void update(EntityManager em, int id) throws SQLException {
        em.getTransaction().begin();

        Empleados response = em.find(Empleados.class, id);
        if (response != null) {
            em.merge(response);
        }

        em.getTransaction().commit();
    }

    @Override
    public void delete(EntityManager em, int id) throws SQLException {
        em.getTransaction().begin();

        Empleados response = em.find(Empleados.class, id);
        if (response != null) {
            em.remove(response);
        }

        em.getTransaction().commit();
    }

    @Override
    public List<Empleados> readAll(EntityManager em) throws SQLException {
        String jpql = "SELECT t FROM " + Empleados.class.getSimpleName() + " t";
        List<Empleados> lista = em.createQuery(jpql, Empleados.class).getResultList();
        return lista;
    }

    @Override
    public List<Empleados> readAllByUser(EntityManager em, int id) throws SQLException {
        em.getTransaction().begin();

        String jpql = "SELECT c FROM Empleados c WHERE c.usuario_id = :id";
        List<Empleados> lista = em.createQuery(jpql, Empleados.class)
                .setParameter("id", id)
                .getResultList();

        em.getTransaction().commit();

        return lista;
    }

    public Empleados readAllByCedula(EntityManager em, int cedula) throws SQLException {
        em.getTransaction().begin();

        String jpql = "SELECT c FROM Empleados c WHERE c.cedula = :cedula";
        Empleados empleado = em.createQuery(jpql, Empleados.class)
                .setParameter("cedula", cedula)
                .getSingleResult();

        em.getTransaction().commit();

        return empleado;
    }
}
