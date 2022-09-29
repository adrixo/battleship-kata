package battleship.model;

public class Ship {
    private SHIP_TYPE shipType;
    private Coordinates coordinates;

    public Ship(SHIP_TYPE shipType, Coordinates coordinates) {
        this.shipType = shipType;
        this.coordinates = coordinates;
    }
}
