package com.componentes.contracts;

import java.sql.SQLException;
import java.util.List;

import jakarta.persistence.EntityManager;

public interface ICrud<T> {

    public void create(EntityManager em, T obj) throws SQLException;

    public T read(EntityManager em, int id) throws SQLException;

    public void update(EntityManager em, int id) throws SQLException;

    public void delete(EntityManager em, int id) throws SQLException;

    public List<T> readAll(EntityManager em) throws SQLException;

    public List<T> readAllByUser(EntityManager em, int empleadoId) throws SQLException;
}
