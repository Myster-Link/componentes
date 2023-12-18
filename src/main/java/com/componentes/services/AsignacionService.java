package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.Asignaciones;
import com.componentes.contracts.ICrud;
import java.sql.SQLException;

public class AsignacionService implements ICrud<Asignaciones> {

    @Override
    public Asignaciones encontrarPK(EntityManager em, Asignaciones obj) throws SQLException {
        Asignaciones asignacionLocalizado = em.find(Asignaciones.class, obj);
        if (asignacionLocalizado != null) {
            return asignacionLocalizado;
        }
        return null;
    }

    @Override
    public List<Asignaciones> listar(EntityManager em) throws SQLException {
        String jpql = "SELECT t FROM " + Asignaciones.class.getSimpleName() + " t";
        List<Asignaciones> lista = em.createQuery(jpql, Asignaciones.class).getResultList();
        return lista;
    }

    @Override
    public void insertar(EntityManager em, Asignaciones obj) throws SQLException {

        em.getTransaction().begin();

        em.persist(obj);

        em.getTransaction().commit();
    }

    @Override
    public void eliminar(EntityManager em, Asignaciones obj) throws SQLException {
        em.getTransaction().begin();

        em.remove(obj);

        em.getTransaction().commit();
    }

    @Override
    public void modificar(EntityManager em, Asignaciones obj) throws SQLException {
        em.getTransaction().begin();

        em.merge(obj);

        em.getTransaction().commit();
    }

    @Override
    public List<Asignaciones> listarPorEmpleadoId(EntityManager em, Long empleadoId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
