package com.componentes.contracts;

import java.util.List;

import jakarta.persistence.EntityManager;

public interface Icrud<E> {

    public E encontarPK(EntityManager em, Object obj);

    public List<E> listar(EntityManager em);

    public void insertar(EntityManager em, E obj);

    public void eliminar(EntityManager em, E obj);

    public void modificar(EntityManager em, E obj);
}
