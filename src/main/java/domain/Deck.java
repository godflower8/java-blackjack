package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        for (int i=1; i<=13; ++i) {
            cards.add(new Card((String.valueOf(i)), "Heart"));
            cards.add(new Card((String.valueOf(i)), "Clover"));
            cards.add(new Card((String.valueOf(i)), "Spade"));
            cards.add(new Card((String.valueOf(i)), "Diamond"));
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card provideCard() {
        //random
        Collections.shuffle(cards);
        Card provideCard = cards.stream()
                .filter(a -> !a.isProvidence())
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        provideCard.setProvidence(true);

        //System.out.println(cards.toString());

        return provideCard;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
