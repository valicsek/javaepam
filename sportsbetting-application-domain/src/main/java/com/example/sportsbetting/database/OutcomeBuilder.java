package com.example.sportsbetting.database;


import com.example.sportsbetting.domain.Bet;
import com.example.sportsbetting.domain.Outcome;
import com.example.sportsbetting.domain.OutcomeOdd;
import java.util.ArrayList;
import java.util.List;

public class OutcomeBuilder {

    private String description;
    private Bet bet;
    private List<OutcomeOdd> outcomeOdds;

    public OutcomeBuilder() {
        this.outcomeOdds=new ArrayList<OutcomeOdd>();
    }

    public OutcomeBuilder description(String description) {
        this.description = description;
        return this;
    }

    public OutcomeBuilder bet(Bet bet) {
        this.bet = bet;
        return this;
    }

    public OutcomeBuilder outcomeOdds(List<OutcomeOdd> outcomeOdds) {
        this.outcomeOdds = outcomeOdds;
        return this;
    }
    
    public Outcome build() {
        return new Outcome(description,bet,outcomeOdds);
    }

}
