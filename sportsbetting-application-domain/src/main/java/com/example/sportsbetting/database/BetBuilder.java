
package com.example.sportsbetting.database;

import com.example.sportsbetting.domain.Bet;
import com.example.sportsbetting.domain.BetType;
import com.example.sportsbetting.domain.Outcome;
import com.example.sportsbetting.domain.SportEvent;
import java.util.ArrayList;
import java.util.List;

public class BetBuilder {

    private String description;
    private SportEvent event;
    private List<Outcome> winnerOutcomes;
    private BetType type;

    public BetBuilder() {
        this.winnerOutcomes=new ArrayList<Outcome>();
    }

    public BetBuilder description(String description) {
        this.description = description;
        return this;
    }

    public BetBuilder event(SportEvent sportEvent) {
        this.event = sportEvent;
        return this;
    }

    public BetBuilder winnerOutcomes(List<Outcome> outcome) {
        this.winnerOutcomes = outcome;
        return this;
    }

    public BetBuilder type(BetType type) {
        this.type = type;
        return this;
    }

    public Bet build() {
        return new Bet(description, event, winnerOutcomes, type);
    }
}
