package com.example.sportsbetting.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Result implements Serializable {
    
    @Id
    @GeneratedValue
    private int Id;
    
   @ManyToOne(targetEntity = Outcome.class)
    private List<Outcome> winnerOutcomes;

    public Result() {
    }

    public int getId() {
        return Id;
    }

    public Result(List<Outcome> winnerOutcomes) {
       this.setWinnerOutcomes(winnerOutcomes);
    }

    public List<Outcome> getWinnerOutcomes() {
        return winnerOutcomes;
    }

    public void setWinnerOutcomes(List<Outcome> outcome) {
        this.winnerOutcomes = outcome;
    }
}
