package com.example.sportsbetting.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDao {
    
    @PersistenceContext
    protected EntityManager entityManager;
}
