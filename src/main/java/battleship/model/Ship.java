package battleship.model;

public class Ship {
    private SHIP_TYPE shipType;
    private Coordinate originCoordinates;

    public Ship(SHIP_TYPE shipType, Coordinate coordinates) {
        this.shipType = shipType;
        this.originCoordinates = coordinates;
    }

    public boolean ocupies(Coordinate point) {
        if (originCoordinates.x == point.x && originCoordinates.y == point.y)
            return true;
        return false;
    }

    public String getMark() {
        return "s";
    }
}
