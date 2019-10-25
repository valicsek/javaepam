package com.example.sportsbetting.dao;

import com.example.sportsbetting.domain.OutcomeOdd;
import org.springframework.transaction.annotation.Transactional;

public interface IOutComeOddDao {

    @Transactional
    public void InsertOutcomeOdd(OutcomeOdd outcomeodd);
}
