package com.componentes.services;

import java.util.List;

import jakarta.persistence.EntityManager;

import com.componentes.entitys.EmpleadoProyecto;
import com.componentes.contracts.ICrud;
import java.sql.SQLException;

public class EmpleadoProyectoService implements ICrud<EmpleadoProyecto> {

    @Override
    public EmpleadoProyecto encontrarPK(EntityManager em, EmpleadoProyecto obj) throws SQLException {
        EmpleadoProyecto empleadoPLocalizado = em.find(EmpleadoProyecto.class, obj);
        if (empleadoPLocalizado != null) {
            return empleadoPLocalizado;
        }
        return null;
    }

    @Override
    public List<EmpleadoProyecto> listar(EntityManager em) throws SQLException {
        String jpql = "SELECT t FROM " + EmpleadoProyecto.class.getSimpleName() + " t";
        List<EmpleadoProyecto> lista = em.createQuery(jpql, EmpleadoProyecto.class).getResultList();
        return lista;
    }

    @Override
    public void insertar(EntityManager em, EmpleadoProyecto obj) throws SQLException {
        em.getTransaction().begin();

        em.persist(obj);

        em.getTransaction().commit();
    }

    @Override
    public void eliminar(EntityManager em, EmpleadoProyecto obj) throws SQLException {
        em.getTransaction().begin();

        em.remove(obj);

        em.getTransaction().commit();
    }

    @Override
    public void modificar(EntityManager em, EmpleadoProyecto obj) throws SQLException {
        em.getTransaction().begin();

        em.merge(obj);

        em.getTransaction().commit();
    }

    @Override
    public List<EmpleadoProyecto> listarPorEmpleadoId(EntityManager em, Long empleadoId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
