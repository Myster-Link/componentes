package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.Empleados;
import com.componentes.contracts.ICrud;
import java.sql.SQLException;

public class EmpleadoService implements ICrud<Empleados> {

    @Override
    public Empleados encontrarPK(EntityManager em, Empleados obj) throws SQLException {
        Empleados empleadosLocalizado = em.find(Empleados.class, obj);
        if (empleadosLocalizado
                != null) {
            return empleadosLocalizado;
        }

        return null;
    }

    @Override
    public List<Empleados> listar(EntityManager em) throws SQLException {
        String jpql = "SELECT t FROM " + Empleados.class
                .getSimpleName() + " t";
        List<Empleados> lista = em.createQuery(jpql, Empleados.class
        ).getResultList();
        return lista;
    }

    @Override
    public void insertar(EntityManager em, Empleados obj) {
        em.getTransaction().begin();

        em.persist(obj);

        em.getTransaction().commit();
    }

    @Override
    public void eliminar(EntityManager em, Empleados obj) throws SQLException {
        em.getTransaction().begin();

        em.remove(obj);

        em.getTransaction().commit();
    }

    @Override
    public void modificar(EntityManager em, Empleados obj) throws SQLException {
        em.getTransaction().begin();

        em.merge(obj);

        em.getTransaction().commit();
    }

    @Override
    public List<Empleados> listarPorEmpleadoId(EntityManager em, Long empleadoId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
