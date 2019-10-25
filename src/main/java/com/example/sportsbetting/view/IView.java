package com.example.sportsbetting.view;

import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.SportEvent;
import com.example.sportsbetting.domain.Wager;

import java.math.BigDecimal;
import java.util.List;

public interface IView {
   Player readPlayerData();
   void printWelcomeMessage(Player player);
   void printBalance(Player player);
   void printOutcomeOdds(List<SportEvent> sportEventList);
   OutcomeOdd selectOutcomeOdd(List<SportEvent> sportEventList) throws Exception;
   BigDecimal readWagerAmount();
   void printWageSaved(Wager wager);
   void printNotEnoughBalance(Player player);
   void printResults(Player player,List<Wager> wagerList);
}
