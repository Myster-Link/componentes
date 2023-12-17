package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.Usuarios;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import com.componentes.contracts.ICrud;
import java.sql.SQLException;

public class UsuarioService implements ICrud<Usuarios> {

    public UsuarioService() {
    }

    @Override
    public Usuarios encontrarPK(EntityManager em, Usuarios obj) throws SQLException {
        Usuarios usuariosLocalizado = em.find(Usuarios.class, obj);
        if (usuariosLocalizado != null) {
            return usuariosLocalizado;
        }
        return null;
    }

    @Override
    public List<Usuarios> listar(EntityManager em) throws SQLException {
        String jpql = "SELECT t FROM " + Usuarios.class.getSimpleName() + " t";
        List<Usuarios> lista = em.createQuery(jpql, Usuarios.class).getResultList();
        return lista;
    }

    @Override
    public void insertar(EntityManager em, Usuarios obj) throws SQLException {
        em.getTransaction().begin();

        em.persist(obj);

        em.getTransaction().commit();
    }

    @Override
    public void eliminar(EntityManager em, Usuarios obj) throws SQLException {
        em.getTransaction().begin();

        em.remove(obj);

        em.getTransaction().commit();

    }

    @Override
    public void modificar(EntityManager em, Usuarios obj) throws SQLException {
        em.getTransaction().begin();

        em.merge(obj);

        em.getTransaction().commit();
    }

    public Usuarios encontrarPorCedula(EntityManager em, int numeroCedula) {
        String jpql = "SELECT u FROM " + Usuarios.class.getSimpleName() + " u WHERE u.cedula = :numeroCedula";

        TypedQuery<Usuarios> query = em.createQuery(jpql, Usuarios.class);
        query.setParameter("numeroCedula", numeroCedula);

        return query.getSingleResult();
    }
}
