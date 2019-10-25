package com.example.sportsbetting;

import com.example.sportsbetting.database.WagerBuilder;
import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.SportEvent;
import com.example.sportsbetting.domain.Wager;

import com.example.sportsbetting.view.IView;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import interfaces.ISportsBettingService;
import org.springframework.beans.factory.annotation.Autowired;

public class App {

    @Autowired
    private ISportsBettingService sportsBettingService;

    @Autowired
    private IView view;

    public App() { }

    public void play() {
        this.createPlayer();

        Boolean repeat = true;
        while (repeat) {
            try {
                this.doBetting();
            } catch (Exception ex) {
                repeat = false;
                // Instead of drop an error, print out ot the screen
                System.out.println(ex.getMessage());
            }
        }

        this.calculateResults();
        this.printResults();
    }

    private void createPlayer() {

        Player player = this.view.readPlayerData();

        this.sportsBettingService.savePlayer(player);

        this.view.printWelcomeMessage(player);
        this.view.printBalance(player);

    }

    private void doBetting() throws Exception {
        List<SportEvent> eventList = this.sportsBettingService.findAllSportEvents();
        this.view.printOutcomeOdds(eventList);
        OutcomeOdd odd = this.view.selectOutcomeOdd(eventList);
        // this.sportsBettingService.InsertOutcomeOdd(odd);
        BigDecimal amount = this.view.readWagerAmount();
        Player actualPlayer = this.sportsBettingService.findPlayer();
        if (actualPlayer.getBalance().compareTo(amount) != -1) {
            this.sportsBettingService.updatePlayerBalance(actualPlayer.getBalance().subtract(amount));
            Random r = new Random();
            Wager wager = new WagerBuilder()
                    .amount(amount)
                    .currency(actualPlayer.getCurrency())
                    .player(actualPlayer)
                    .odd(odd)
                    .win(r.nextBoolean())
                    .timeStampCreated(LocalDateTime.now())
                    .build();
            this.view.printWageSaved(wager);
            this.sportsBettingService.saveWage(wager);
        } else {
            this.view.printNotEnoughBalance(actualPlayer);
        }
    }

    private void calculateResults() {
        this.sportsBettingService.calculateResults();
    }

    private void printResults() {
        Player player = this.sportsBettingService.findPlayer();
        this.view.printResults(player, this.sportsBettingService.findAllWagers());
    }
}
