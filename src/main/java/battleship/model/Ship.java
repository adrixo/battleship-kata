package battleship.model;

public class Ship {
    private SHIP_TYPE shipType;
    private Coordinate coordinates;

    public Ship(SHIP_TYPE shipType, Coordinate coordinates) {
        this.shipType = shipType;
        this.coordinates = coordinates;
    }
}
