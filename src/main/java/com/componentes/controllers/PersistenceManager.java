package com.componentes.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceManager {

    private static volatile EntityManagerFactory entityManagerFactory;

    private PersistenceManager() {
        // Evitar instanciación desde fuera de la clase
    }

    public static EntityManager getEntityManager(String persistenceUnit) {
        if (entityManagerFactory == null) {
            synchronized (PersistenceManager.class) {
                if (entityManagerFactory == null) {
                    entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
                }
            }
        }
        return entityManagerFactory.createEntityManager();
    }

    public static void closeEntityManager(EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

    // Esta función cerrará el EntityManagerFactory solo si fue creado
    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
            entityManagerFactory = null; // Establecer a null después de cerrarlo
        }
    }

    // Método para obtener el EntityManager con el nombre de la unidad de persistencia
    public static EntityManager getEntityManager() {
        return getEntityManager("BackCompPU");
    }
}
