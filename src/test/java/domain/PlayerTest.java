package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void calculateTest_withOnlyNumbers() {
        //given
        Player player = new Player("player");


        //when
        player.setMyCards(new Card("2", "Diamond"));
        player.setMyCards(new Card("7", "Heart"));
        player.setMyCards(new Card("9", "Clover"));
        int score = player.calculateScore();

        //then
        Assertions.assertThat(score).isEqualTo(18);
    }

    @Test
    void calculateTest_withNumbersAndCharacters() {
        //given
        Player player = new Player("player");


        //when
        player.setMyCards(new Card("2", "Diamond"));
        player.setMyCards(new Card("9", "Heart"));
        player.setMyCards(new Card("K", "Clover"));
        int score = player.calculateScore();

        //then
        Assertions.assertThat(score).isEqualTo(21);
    }

    @Test
    void calculateTest_withNumbersAndCharacters2() {
        //given
        Player player = new Player("player");


        //when
        player.setMyCards(new Card("2", "Diamond"));
        player.setMyCards(new Card("A", "Heart"));
        player.setMyCards(new Card("K", "Clover"));
        player.setMyCards(new Card("A", "Heart"));
        int score = player.calculateScore();

        //then
        Assertions.assertThat(score).isEqualTo(14);
    }

    @Test
    void calculateTest_withNumbersAndCharacters3() {
        //given
        Player player = new Player("player");


        //when
        player.setMyCards(new Card("A", "Heart"));
        player.setMyCards(new Card("A", "Heart"));
        int score = player.calculateScore();

        //then
        Assertions.assertThat(score).isEqualTo(12);
    }

    @Test
    void calculateTest_over21() {
        //given
        Player player = new Player("player");

        //when
        player.setMyCards(new Card("K", "Heart"));
        player.setMyCards(new Card("K", "Heart"));
        player.setMyCards(new Card("K", "Heart"));
        int score = player.calculateScore();

        //then
        Assertions.assertThat(score).isEqualTo(30);
    }

}