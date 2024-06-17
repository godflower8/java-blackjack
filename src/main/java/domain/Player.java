package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> myCards;

    public Player() {
        // Player dealer = new Player();
        this("Dealer");
    }

    public Player(String name) {
        // Player player1 = new Player("player1");
        this.name = name;
        myCards = new ArrayList<>();
    }

    public List<Card> getMyCards() {
        return myCards;
    }

    public void setMyCards(Card... myCards) {
        this.myCards.addAll(List.of(myCards));
    }

    public int calculateScore() {
      Integer totalScore = myCards.stream()
              .map(myCard -> {
                  try {
                      return Integer.parseInt(myCard.getNumber());
                  } catch (NumberFormatException e) {
                      return CardEnum.valueOf(myCard.getNumber()).getScore();
                  }
              }).toList().stream()
              .mapToInt(Integer::intValue).sum();

        return optimizeAce(totalScore);
    }

    private int optimizeAce(Integer totalScore) {
        if (totalScore > 21) {
            List<Card> aCards = new ArrayList<>();
            aCards = myCards.stream()
                    .filter(card -> card.getNumber().equals("A"))
                    .toList();
            for(Card card : aCards) {
                if (totalScore <= 21) {
                    return totalScore;
                }
                totalScore -= 10;
            }
        }

        return totalScore;
    }

    public String getName() {
        return name;
    }
}
