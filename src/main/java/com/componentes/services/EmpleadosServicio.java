package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.Empleados;
import com.componentes.contracs.Icrud;

public class EmpleadosServicio implements Icrud<Empleados> {

    @Override
    public Empleados encontarPK(EntityManager em, Object obj) {
        Empleados empleadosLocalizado = em.find(Empleados.class, obj);
        if (empleadosLocalizado != null) {
            return empleadosLocalizado;
        }
        return null;
    }

    @Override
    public List<Empleados> listar(EntityManager em) {
        String jpql = "SELECT t FROM " + Empleados.class.getSimpleName() + " t";
        List<Empleados> lista = em.createQuery(jpql, Empleados.class).getResultList();
        return lista;
    }

    @Override
    public void insertar(EntityManager em, Empleados obj) {
        try {
            em.getTransaction().begin();

            em.persist(obj);

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(EntityManager em, Empleados obj) {
        em.getTransaction().begin();

        em.remove(obj);

        em.getTransaction().commit();
    }

    @Override
    public void modificar(EntityManager em, Empleados obj) {
        em.getTransaction().begin();

        em.merge(obj);

        em.getTransaction().commit();
    }

}
