package com.example.sportsbetting.dao;

import com.example.sportsbetting.domain.Player;
import java.math.BigDecimal;
import org.springframework.transaction.annotation.Transactional;

public interface IPlayerDao {
    
    @Transactional
    public void AddPlayer(Player player);
    
    @Transactional
    void UpdatePlayerBalance(BigDecimal newVal);
    
    public Player GetActualPlayer();
}
