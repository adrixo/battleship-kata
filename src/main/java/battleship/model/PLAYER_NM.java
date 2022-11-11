package battleship.model;

public enum PLAYER_NM {
    ONE, TWO;

    public PLAYER_NM swap() {
        if (this == ONE)
            return TWO;
        return ONE;
    }
}
