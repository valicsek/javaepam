package com.example.sportsbetting.dao;

import com.example.sportsbetting.domain.SportEvent;
import java.util.List;

public class SportEventDao extends GenericDao implements ISportEventDao {

    public void save(SportEvent event) {
        entityManager.persist(event);
    }

    public List<SportEvent> GetAllSportEvent() {
        List<SportEvent> list = entityManager
                .createQuery("SELECT se FROM SportEvent se", SportEvent.class)
                .getResultList();
        
        return list;
    }

}
