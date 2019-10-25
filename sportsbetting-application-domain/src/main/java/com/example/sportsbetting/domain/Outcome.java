package com.example.sportsbetting.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Outcome implements Serializable {

    @Id
    @GeneratedValue
    private int Id;

    @Column(name="description")
    private String description;
    
    @OneToOne()
    private Bet bet;
    
    @OneToMany()
    private List<OutcomeOdd> outcomeOdds;

    public Outcome() {
    }

    public Outcome(String description, Bet bet, List<OutcomeOdd> outcomeOdds) {
        this.setDescription(description);
        this.setBet(bet);
        this.setOutcomeOdds(outcomeOdds);
    }

    public List<OutcomeOdd> getOutcomeOdds() {
        return outcomeOdds;
    }

    public void setOutcomeOdds(List<OutcomeOdd> outcomeOdd) {
        for (OutcomeOdd oddValue : outcomeOdd) {
            oddValue.setOutcome(this);
        }
        this.outcomeOdds = outcomeOdd;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
