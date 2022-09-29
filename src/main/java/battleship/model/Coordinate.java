package battleship.model;

public class Coordinate {

    public final int x;
    public final int y;
    private DIRECTION direction;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = DIRECTION.NONE;
    }
    public Coordinate(int x, int y, DIRECTION direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}
