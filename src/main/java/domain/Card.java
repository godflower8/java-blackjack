package domain;

public class Card {
    private final String number;
    private final String symbol;
    private boolean providence;

    public Card(String number, String symbol) {
        this.number = number;
        this.symbol = symbol;
        providence = false;
    }

    public boolean isProvidence() {
        return providence;
    }

    public void setProvidence(boolean providence) {
        this.providence = providence;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number='" + number + '\'' +
                ", symbol='" + symbol + '\'' +
                ", providence=" + providence +
                '}';
    }

    public String getNumber() {
        return number;
    }
}
