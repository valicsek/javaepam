package com.example.sportsbetting.domain;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Entity;

@Entity
public class TennisSportEvent extends SportEvent {

    public TennisSportEvent() {
    }

    public TennisSportEvent(String title, LocalDateTime startDate, LocalDateTime endDate, Set<Bet> bets, Result result) {
        super(title, startDate, endDate, bets, result);
    }
    
}
