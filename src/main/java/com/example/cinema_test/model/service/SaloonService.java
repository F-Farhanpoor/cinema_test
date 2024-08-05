package com.example.cinema_test.model.service;


import com.example.cinema_test.model.entity.Saloon;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class SaloonService implements Serializable {

    @PersistenceContext(unitName = "store")
    private EntityManager entityManager;

    @Transactional
    public Saloon save(Saloon saloon) throws Exception {
        entityManager.persist(saloon);
        return saloon;
    }

    @Transactional
    public List<Saloon> findAll() throws Exception {
        return entityManager
                .createQuery("select oo from saloonEntity oo where oo.deleted=false order by id", Saloon.class)
                .getResultList();
    }
}
