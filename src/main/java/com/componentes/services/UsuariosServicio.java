package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.contracs.Icrud;
import com.componentes.entitys.Usuarios;

public class UsuariosServicio implements Icrud<Usuarios> {

    public UsuariosServicio() {
    }

    @Override
    public Usuarios encontarPK(EntityManager em, Object obj) {
        Usuarios usuariosLocalizado = em.find(Usuarios.class, obj);
        if (usuariosLocalizado != null) {
            return usuariosLocalizado;
        }
        return null;
    }

    @Override
    public List<Usuarios> listar(EntityManager em) {
        String jpql = "SELECT t FROM " + Usuarios.class.getSimpleName() + " t";
        List<Usuarios> lista = em.createQuery(jpql, Usuarios.class).getResultList();
        return lista;
    }

    @Override
    public void insertar(EntityManager em, Usuarios obj) {
        try {
            em.getTransaction().begin();

            em.persist(obj);

            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(EntityManager em, Usuarios obj) {
        em.getTransaction().begin();

        em.remove(obj);

        em.getTransaction().commit();

    }

    @Override
    public void modificar(EntityManager em, Usuarios obj) {
        em.getTransaction().begin();

        em.merge(obj);

        em.getTransaction().commit();
    }

}
