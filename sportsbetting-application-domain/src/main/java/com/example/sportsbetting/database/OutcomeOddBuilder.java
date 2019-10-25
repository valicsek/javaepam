package com.example.sportsbetting.database;

import com.example.sportsbetting.domain.Outcome;
import com.example.sportsbetting.domain.OutcomeOdd;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutcomeOddBuilder {

    private BigDecimal value;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
    private Outcome outcome;

    public OutcomeOddBuilder value(BigDecimal value) {
        this.value = value;
        return this;
    }

    public OutcomeOddBuilder validFrom(LocalDateTime date) {
        this.validFrom = date;
        return this;
    }

    public OutcomeOddBuilder validUntil(LocalDateTime date) {
        this.validUntil = date;
        return this;
    }

    public OutcomeOddBuilder outcome(Outcome outcome) {
        this.outcome = outcome;
        return this;
    }
    
    public OutcomeOdd build(){
        return new OutcomeOdd(value, validFrom, validUntil, outcome);
    }

}
