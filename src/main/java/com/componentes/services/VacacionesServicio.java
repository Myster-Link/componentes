package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.Vacaciones;
import com.componentes.contracs.Icrud;

public class VacacionesServicio implements Icrud<Vacaciones> {

    @Override
    public Vacaciones encontarPK(EntityManager em, Object obj) {
        Vacaciones vacacionesLocalizado = em.find(Vacaciones.class, obj);
        if (vacacionesLocalizado != null) {
            return vacacionesLocalizado;
        }
        return null;
    }

    @Override
    public List<Vacaciones> listar(EntityManager em) {
        String jpql = "SELECT t FROM " + Vacaciones.class.getSimpleName() + " t";
        List<Vacaciones> lista = em.createQuery(jpql, Vacaciones.class).getResultList();
        return lista;
    }

    @Override
    public void insertar(EntityManager em, Vacaciones obj) {
        try {
            em.getTransaction().begin();

            em.persist(obj);

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(EntityManager em, Vacaciones obj) {
        em.getTransaction().begin();

        em.remove(obj);

        em.getTransaction().commit();
    }

    @Override
    public void modificar(EntityManager em, Vacaciones obj) {
        em.getTransaction().begin();

        em.merge(obj);

        em.getTransaction().commit();
    }

}
