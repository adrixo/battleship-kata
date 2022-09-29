package battleship;

public class Ship {
    private SHIP shipType;
    private Coordinates coordinates;

    public Ship(SHIP shipType, Coordinates coordinates) {
        this.shipType = shipType;
        this.coordinates = coordinates;
    }
}
