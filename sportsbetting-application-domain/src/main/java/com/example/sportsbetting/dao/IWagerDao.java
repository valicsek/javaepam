package com.example.sportsbetting.dao;

import com.example.sportsbetting.domain.Wager;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;


public interface IWagerDao {

    @Transactional
    public void InsertWager(Wager wager);
    
    public List<Wager> GetWager();
}
