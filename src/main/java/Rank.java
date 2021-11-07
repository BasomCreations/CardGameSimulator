/**
 * The different positions in which a player can finish after a round
 */
public enum Rank {
    FIRST(10),
    SECOND(8),
    THIRD(6),
    FOURTH(5),
    FIFTH(3),
    SIXTH(2),
    SEVENTH(1),
    EIGHTH(1);

    /** Number of points earned for finishing in the corresponding position */
    private int points;

    /**
     * Constructor
     * @param points - number of points earned
     */
    Rank(int points){
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}
