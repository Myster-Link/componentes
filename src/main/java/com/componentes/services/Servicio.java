package com.componentes.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Servicio {

    public EntityManager em = null;
    public EntityManagerFactory entityManagerFactory = null;

    public EntityManager getEntityManager() {

        return entityManagerFactory.createEntityManager();
    }

    public void startEntityManagerFactory(String persistenceUnit) throws Exception {
        if (entityManagerFactory == null) {
            try {
                entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void stopEntityManagerFactory() throws Exception {

        if (entityManagerFactory != null) {
            if (entityManagerFactory.isOpen()) {
                try {
                    entityManagerFactory.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            entityManagerFactory = null;
        }
    }
}
