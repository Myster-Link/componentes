package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.Comentario;
import com.componentes.contracts.Icrud;

public class ComentariosServicio implements Icrud<Comentario> {

    @Override
    public Comentario encontarPK(EntityManager em, Object obj) {
        Comentario comentarioLocalizado = em.find(Comentario.class, obj);
        if (comentarioLocalizado != null) {
            return comentarioLocalizado;
        }
        return null;
    }

    @Override
    public List<Comentario> listar(EntityManager em) {
        String jpql = "SELECT t FROM " + Comentario.class.getSimpleName() + " t";
        List<Comentario> lista = em.createQuery(jpql, Comentario.class).getResultList();
        return lista;
    }

    @Override
    public void insertar(EntityManager em, Comentario obj) {
        try {
            em.getTransaction().begin();

            em.persist(obj);

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(EntityManager em, Comentario obj) {
        em.getTransaction().begin();

        em.remove(obj);

        em.getTransaction().commit();
    }

    @Override
    public void modificar(EntityManager em, Comentario obj) {
        em.getTransaction().begin();

        em.merge(obj);

        em.getTransaction().commit();
    }

}
