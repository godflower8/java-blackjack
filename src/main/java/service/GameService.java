package service;

import domain.Card;
import domain.Deck;
import domain.Player;
import domain.Result;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    final Deck deck = new Deck();

//    public List<Card> initialHit() {
//        List<Card> list = new ArrayList<>();
//        list.add(deck.provideCard());
//        list.add(deck.provideCard());
//        return list;
//    }

    public Card hit() {
        return deck.provideCard();
    }

    public Player decideWinner(Player dealer, Player player) {
        int playerScore = player.calculateScore();
        if (playerScore > 21) {
            return dealer;
        }

        int dealerScore = dealer.calculateScore();
        if (dealerScore > 21) {
            return player;
        }

        if (playerScore > dealerScore) {
            return player;
        }
        if (dealerScore > playerScore) {
            return dealer;
        }
        return null;
    }
}
