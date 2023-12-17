package com.componentes.contracts;

import java.sql.SQLException;
import java.util.List;

import jakarta.persistence.EntityManager;

public interface ICrud<E> {

    public E encontrarPK(EntityManager em, E obj) throws SQLException;

    public List<E> listar(EntityManager em) throws SQLException;

    public void insertar(EntityManager em, E obj) throws SQLException;

    public void eliminar(EntityManager em, E obj) throws SQLException;

    public void modificar(EntityManager em, E obj) throws SQLException;
}
