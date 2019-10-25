package com.example.sportsbetting.domain;

import com.example.sportsbetting.database.BetBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// ORM IMPORTS
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Bet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "description")
    private String description;

    @OneToOne()
    @JoinColumn(name = "Person_FK")
    private SportEvent event;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Outcome> winnerOutcomes;

    @Enumerated(EnumType.STRING)
    private BetType type;

    public Bet() { }

    public Bet(String description, SportEvent event, List<Outcome> winnerOutcomes, BetType type) {
        this.setDescription(description);
        this.setEvent(event);
        this.setWinnerOutcome(winnerOutcomes);
        this.setBettype(type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BetType getBettype() {
        return type;
    }

    public void setBettype(BetType bettype) {
        this.type = bettype;
    }

    public List<Outcome> getWinnerOutcome() {
        return winnerOutcomes;
    }

    public void setWinnerOutcome(List<Outcome> outcome) {
        for (Outcome element : outcome) {
            element.setBet(this);
        }
        this.winnerOutcomes = outcome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SportEvent getEvent() {
        return event;
    }

    public void setEvent(SportEvent event) {
        this.event = event;
    }
}
