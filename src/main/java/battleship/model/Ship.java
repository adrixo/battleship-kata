package battleship.model;

public class Ship {
    private SHIP_TYPE shipType;
    public final Coordinate originCoordinates;

    public Ship(SHIP_TYPE shipType, Coordinate coordinates) {
        this.shipType = shipType;
        this.originCoordinates = coordinates;
    }

    public boolean occupies(Coordinate point) {
        if (originCoordinates.x == point.x && originCoordinates.y == point.y)
            return true;
        return false;
    }

    public String getMark() {
        return "g";
    }

    public boolean isOutOfBounds() {
        return originCoordinates.x<0 ||
                originCoordinates.x>=VAR.MAX_BOARD_SIZE-1||
                originCoordinates.y<0 ||
                originCoordinates.y>=VAR.MAX_BOARD_SIZE-1;
    }
}
