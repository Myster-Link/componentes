package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.Asignaciones;
import com.componentes.contracs.Icrud;

public class AsignacionesServicio implements Icrud<Asignaciones> {

    @Override
    public Asignaciones encontarPK(EntityManager em, Object obj) {
        Asignaciones asignacionLocalizado = em.find(Asignaciones.class, obj);
        if (asignacionLocalizado != null) {
            return asignacionLocalizado;
        }
        return null;
    }

    @Override
    public List<Asignaciones> listar(EntityManager em) {
        String jpql = "SELECT t FROM " + Asignaciones.class.getSimpleName() + " t";
        List<Asignaciones> lista = em.createQuery(jpql, Asignaciones.class).getResultList();
        return lista;
    }

    @Override
    public void insertar(EntityManager em, Asignaciones obj) {
        try {
            em.getTransaction().begin();

            em.persist(obj);

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(EntityManager em, Asignaciones obj) {
        em.getTransaction().begin();

        em.remove(obj);

        em.getTransaction().commit();
    }

    @Override
    public void modificar(EntityManager em, Asignaciones obj) {
        em.getTransaction().begin();

        em.merge(obj);

        em.getTransaction().commit();
    }

}
