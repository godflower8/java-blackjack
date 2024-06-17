package service;

import domain.Card;
import domain.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    @Test
    void give2Cards() {
        //given
        Player dealer = new Player();
        Player player1 = new Player("a");

        //when
        GameService gameService = new GameService();
        dealer.setMyCards(gameService.hit(), gameService.hit());
        player1.setMyCards(gameService.hit(), gameService.hit());
//        List<Card> initialCards = gameService.initialHit();

//        System.out.println(dealer.getMyCards().toString());
//        System.out.println(player1.getMyCards().toString());

        //then
        assertThat(dealer.getMyCards().size()).isEqualTo(2);
        assertThat(player1.getMyCards().size()).isEqualTo(2);
    }

    @Test
    void decidePlayerWin() {
        Player dealer = new Player();
        Player player1 = new Player("a");

        GameService gameService = new GameService();
        dealer.setMyCards(new Card("2", "Heart"));
        player1.setMyCards(new Card("A", "Clover"));

        assertThat(gameService.decideWinner(dealer, player1)).isEqualTo(player1);
    }

    @Test
    void decideWinnerWhoCloseTo21() {
        Player dealer = new Player();
        Player player1 = new Player("a");

        GameService gameService = new GameService();
        dealer.setMyCards(new Card("A", "Heart"), new Card("9", "Spade"));
        player1.setMyCards(new Card("A", "Clover"), new Card("8", "Heart"));

        assertThat(gameService.decideWinner(dealer, player1)).isEqualTo(dealer);

    }

    @Test
    void decidePlayerBurst() {
        Player dealer = new Player();
        Player player1 = new Player("a");

        GameService gameService = new GameService();
        dealer.setMyCards(new Card("A", "Heart"), new Card("9", "Spade"));
        player1.setMyCards(new Card("8", "Clover"), new Card("8", "Heart"), new Card("8", "Heart"));

        assertThat(gameService.decideWinner(dealer, player1)).isEqualTo(dealer);

    }

    @Test
    void decidePlayerBurstDealerBurst() {
        Player dealer = new Player();
        Player player1 = new Player("a");

        GameService gameService = new GameService();
        dealer.setMyCards(new Card("8", "Heart"), new Card("9", "Spade"), new Card("9", "Spade"));
        player1.setMyCards(new Card("8", "Clover"), new Card("8", "Heart"), new Card("8", "Heart"));

        assertThat(gameService.decideWinner(dealer, player1)).isEqualTo(dealer);

    }

    @Test
    void decideDraw() {
        Player dealer = new Player();
        Player player1 = new Player("a");

        GameService gameService = new GameService();
        dealer.setMyCards(new Card("8", "Heart"), new Card("8", "Spade"));
        player1.setMyCards(new Card("8", "Clover"), new Card("8", "Heart"));

        assertThat(gameService.decideWinner(dealer, player1)).isEqualTo(null);

    }

    @Test
    void decideDealerBurst() {
        Player dealer = new Player();
        Player player1 = new Player("a");

        GameService gameService = new GameService();
        dealer.setMyCards(new Card("8", "Heart"), new Card("9", "Spade"), new Card("9", "Spade"));
        player1.setMyCards(new Card("8", "Clover"), new Card("8", "Heart"));

        assertThat(gameService.decideWinner(dealer, player1)).isEqualTo(player1);

    }

}