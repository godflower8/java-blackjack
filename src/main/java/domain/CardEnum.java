package domain;

public enum CardEnum {
    K(10),
    Q(10),
    J(10),
    A(11);

    private final int score;

    CardEnum(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
