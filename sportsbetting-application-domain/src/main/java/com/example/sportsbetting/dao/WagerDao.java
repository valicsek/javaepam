package com.example.sportsbetting.dao;

import com.example.sportsbetting.domain.Wager;
import java.util.List;

public class WagerDao extends GenericDao implements IWagerDao {

    public void InsertWager(Wager wager) {
        entityManager.persist(wager);
    }

    public List<Wager> GetWager() {
        List<Wager> list = entityManager.createQuery("SELECT wager FROM Wager wager", Wager.class).getResultList();

        return list;
    }

}
