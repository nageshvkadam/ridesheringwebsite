package com.nagesh.repository;

import com.nagesh.entity.Ride;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RideDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ridePU");

    public void saveRide(Ride ride) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ride);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
