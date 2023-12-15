package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.EmpleadoProyecto;
import com.componentes.contracs.Icrud;

public class EmpleadoProyectoServicio implements Icrud<EmpleadoProyecto> {

    @Override
    public EmpleadoProyecto encontarPK(EntityManager em, Object obj) {
        EmpleadoProyecto empleadoPLocalizado = em.find(EmpleadoProyecto.class, obj);
        if (empleadoPLocalizado != null) {
            return empleadoPLocalizado;
        }
        return null;
    }

    @Override
    public List<EmpleadoProyecto> listar(EntityManager em) {
        String jpql = "SELECT t FROM " + EmpleadoProyecto.class.getSimpleName() + " t";
        List<EmpleadoProyecto> lista = em.createQuery(jpql, EmpleadoProyecto.class).getResultList();
        return lista;
    }

    @Override
    public void insertar(EntityManager em, EmpleadoProyecto obj) {
        try {
            em.getTransaction().begin();

            em.persist(obj);

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(EntityManager em, EmpleadoProyecto obj) {
        em.getTransaction().begin();

        em.remove(obj);

        em.getTransaction().commit();
    }

    @Override
    public void modificar(EntityManager em, EmpleadoProyecto obj) {
        em.getTransaction().begin();

        em.merge(obj);

        em.getTransaction().commit();
    }

}
