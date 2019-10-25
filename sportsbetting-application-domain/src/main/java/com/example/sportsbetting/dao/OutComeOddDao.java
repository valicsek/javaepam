package com.example.sportsbetting.dao;

import com.example.sportsbetting.domain.OutcomeOdd;

public class OutComeOddDao extends GenericDao implements IOutComeOddDao {

    public void InsertOutcomeOdd(OutcomeOdd outcomeodd) {
        entityManager.persist(outcomeodd);
    }

}
