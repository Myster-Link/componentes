package com.componentes.services;

import com.componentes.contracts.ICrud;
import com.componentes.entitys.ExperienciaLaboral;
import jakarta.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class ExperienciaService implements ICrud<ExperienciaLaboral> {

    @Override
    public ExperienciaLaboral encontrarPK(EntityManager em, ExperienciaLaboral obj) throws SQLException {
        ExperienciaLaboral empleadosLocalizado = em.find(ExperienciaLaboral.class, obj);
        if (empleadosLocalizado
                != null) {
            return empleadosLocalizado;
        }

        return null;
    }

    @Override
    public List<ExperienciaLaboral> listar(EntityManager em) throws SQLException {
        String jpql = "SELECT t FROM " + ExperienciaLaboral.class
                .getSimpleName() + " t";
        List<ExperienciaLaboral> lista = em.createQuery(jpql, ExperienciaLaboral.class
        ).getResultList();
        return lista;
    }

    @Override
    public void insertar(EntityManager em, ExperienciaLaboral obj) {
        em.getTransaction().begin();

        em.persist(obj);

        em.getTransaction().commit();
    }

    @Override
    public void eliminar(EntityManager em, ExperienciaLaboral obj) throws SQLException {
        em.getTransaction().begin();

        em.remove(obj);

        em.getTransaction().commit();
    }

    @Override
    public void modificar(EntityManager em, ExperienciaLaboral obj) throws SQLException {
        em.getTransaction().begin();

        em.merge(obj);

        em.getTransaction().commit();
    }

    @Override
    public List<ExperienciaLaboral> listarPorEmpleadoId(EntityManager em, Long empleadoId) throws SQLException {
        String jpql = "SELECT t FROM " + ExperienciaLaboral.class.getSimpleName() + " t WHERE t.empleado_id = :empleadoId";
        return em.createQuery(jpql, ExperienciaLaboral.class)
                .setParameter("empleadoId", empleadoId)
                .getResultList();
    }
}
