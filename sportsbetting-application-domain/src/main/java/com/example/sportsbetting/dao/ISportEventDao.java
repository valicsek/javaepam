package com.example.sportsbetting.dao;

import com.example.sportsbetting.domain.SportEvent;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface ISportEventDao {

    @Transactional
    public void save(SportEvent event);

    public List<SportEvent> GetAllSportEvent();
}
