package com.example.sportsbetting.view;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;

import com.example.sportsbetting.domain.Bet;
import com.example.sportsbetting.domain.Currency;
import com.example.sportsbetting.domain.Outcome;
import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.SportEvent;
import com.example.sportsbetting.domain.Wager;

import com.example.sportsbetting.language.Localization;

import org.springframework.beans.factory.annotation.Autowired;

public class View implements IView {

    @Autowired
    MessageFormat formatter;

    String pattern;

    // Scanner for read input
    Scanner scanner;

    public View() {
        // Setup the default language for the project
        Localization.setLocale("en", "US");
        // Setup a basic Scanner
        scanner = new Scanner(System.in);
    }

    @Override
    public Player readPlayerData() {
        Player player = new Player();

        System.out.println(Localization.getLocaleBundle().getString("nameAsk"));
        player.setName(scanner.nextLine());

        System.out.println(Localization.getLocaleBundle().getString("moneyAsk"));
        player.setBalance(new BigDecimal(scanner.nextLine()));

        System.out.println(Localization.getLocaleBundle().getString("currencyAsk"));
        player.setCurrency(Currency.valueOf(scanner.nextLine()));

        return player;
    };
    
    @Override
    public void printWelcomeMessage(Player player) {
        pattern = Localization.getLocaleBundle().getString("welcomeMessage");
        formatter = new MessageFormat(pattern);

        System.out.println(formatter.format(new Object[]{player.getName()}));
    }

    @Override
    public void printBalance(Player player) {
        pattern = Localization.getLocaleBundle().getString("balanceMessage");
        formatter = new MessageFormat(pattern);

        System.out.println(formatter.format(new Object[]{player.getBalance(), player.getCurrency()}));
    }

    @Override
    public void printOutcomeOdds(List<SportEvent> sportEventList) {
        System.out.println(Localization.getLocaleBundle().getString("betAsk"));

        pattern = Localization.getLocaleBundle().getString("betDescription");
        formatter = new MessageFormat(pattern);
        
        int index = 0;
        for (SportEvent sportEvent : sportEventList) {
            for (Bet bet : sportEvent.getBets()) {
                for (Outcome outcome : bet.getWinnerOutcome()) {
                    for (OutcomeOdd outcomeOdd : outcome.getOutcomeOdds()) {
                        index++;
                        System.out.println(formatter.format(
                                new Object[]{index, sportEvent.getTitle(), sportEvent.getStartDate(),
                                    bet.getDescription(), outcome.getDescription(), outcomeOdd.getValue(),
                                    outcomeOdd.getValidFrom(), outcomeOdd.getValidUntil()}));
                    }
                }
            }
        }
    }

    @Override
    public OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEventList) throws Exception {
        String line = scanner.nextLine();
        if ("q".equals(line)) { throw new Exception(); }
        int index = 0;
        int choosen = Integer.parseInt(line);
        for (SportEvent sportEvent : sportEventList) {
            for (Bet bet : sportEvent.getBets()) {
                for (Outcome outcome : bet.getWinnerOutcome()) {
                    for (OutcomeOdd outcomeOdd : outcome.getOutcomeOdds()) {
                        index++;
                        if (index == choosen) {
                            return outcomeOdd;
                        }
                    }
                }
            }
        }

        return null;
    }

    @Override
    public BigDecimal readWagerAmount() {
        System.out.println(Localization.getLocaleBundle().getString("betAmountAsk"));
        Scanner scanner = new Scanner(System.in);
        return new BigDecimal(scanner.nextLine());
    }

    @Override
    public void printNotEnoughBalance(Player player) {

        pattern = Localization.getLocaleBundle().getString("notEnoughBalance");
        formatter = new MessageFormat(pattern);
        System.out.println(formatter.format(new Object[]{player.getBalance(), player.getCurrency()}));
    }

    @Override
    public void printResults(Player player, List<Wager> wagerList) {
        System.out.println(Localization.getLocaleBundle().getString("resultMessageLabel"));
        pattern = Localization.getLocaleBundle().getString("resultMesage");
        formatter = new MessageFormat(pattern);

        for (Wager wager : wagerList) {
            System.out.println(formatter.format(new Object[]{
                wager.getOdd().getOutcome().getBet().getDescription(),
                wager.getOdd().getOutcome().getDescription(),
                wager.getOdd().getOutcome().getBet().getEvent().getTitle(),
                wager.getOdd().getValue(),
                wager.getAmount(),
                wager.isWin()}));
        }

        pattern = Localization.getLocaleBundle().getString("newBalanceMessage");
        formatter = new MessageFormat(pattern);

        System.out.println(formatter.format(new Object[]{player.getBalance(), player.getCurrency()}));
    }

    @Override
    public void printWageSaved(Wager wager) {

        pattern = Localization.getLocaleBundle().getString("betSaveMessage");
        formatter = new MessageFormat(pattern);

        System.out.println(formatter.format(new Object[]{
            wager.getOdd().getOutcome().getBet().getDescription(),
            wager.getOdd().getOutcome().getDescription(),
            wager.getOdd().getOutcome().getBet().getEvent().getTitle(),
            wager.getOdd().getValue(),
            wager.getAmount()}));
    }
}
