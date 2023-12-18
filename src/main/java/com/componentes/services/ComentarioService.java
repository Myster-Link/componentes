package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.Comentario;
import com.componentes.contracts.ICrud;
import java.sql.SQLException;

public class ComentarioService implements ICrud<Comentario> {

    @Override
    public Comentario encontrarPK(EntityManager em, Comentario obj) throws SQLException {
        Comentario comentarioLocalizado = em.find(Comentario.class, obj);
        if (comentarioLocalizado != null) {
            return comentarioLocalizado;
        }
        return null;
    }

    @Override
    public List<Comentario> listar(EntityManager em) throws SQLException {
        String jpql = "SELECT t FROM " + Comentario.class.getSimpleName() + " t";
        List<Comentario> lista = em.createQuery(jpql, Comentario.class).getResultList();
        return lista;
    }

    @Override
    public void insertar(EntityManager em, Comentario obj) throws SQLException {
        em.getTransaction().begin();

        em.persist(obj);

        em.getTransaction().commit();
    }

    @Override
    public void eliminar(EntityManager em, Comentario obj) throws SQLException {
        em.getTransaction().begin();

        em.remove(obj);

        em.getTransaction().commit();
    }

    @Override
    public void modificar(EntityManager em, Comentario obj) throws SQLException {
        em.getTransaction().begin();

        em.merge(obj);

        em.getTransaction().commit();
    }

    @Override
    public List<Comentario> listarPorEmpleadoId(EntityManager em, Long empleadoId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
