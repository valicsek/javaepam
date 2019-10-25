package com.example.sportsbetting.database;

import com.example.sportsbetting.domain.Bet;
import com.example.sportsbetting.domain.FootballSportEvent;
import com.example.sportsbetting.domain.Result;
import com.example.sportsbetting.domain.SportEvent;
import com.example.sportsbetting.domain.TennisSportEvent;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class SporteventBuilder {

    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Set<Bet> bets;
    private Result result;

    public SporteventBuilder() {
        this.bets = new HashSet<Bet>();
    }

    public SporteventBuilder title(String title) {
        this.title = title;
        return this;
    }

    public SporteventBuilder startDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public SporteventBuilder endDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public SporteventBuilder bets(Set<Bet> bets) {
        this.bets = bets;
        return this;
    }

    public SporteventBuilder result(Result result) {
        this.result = result;
        return this;
    }

    public SportEvent build(int sportEventType) {
        if (sportEventType == 0) {
            return new TennisSportEvent(title, startDate, endDate, bets, result);
        } else {
            return new FootballSportEvent(title, startDate, endDate, bets, result);
        }
    }
}
