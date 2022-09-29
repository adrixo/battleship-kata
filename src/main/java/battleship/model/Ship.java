package battleship.model;

import java.util.List;

public class Ship {
    private SHIP_TYPE shipType;
    public final Coordinate originCoordinates;
    private final List<Coordinate> occupiedCoordinates;

    public Ship(SHIP_TYPE shipType, Coordinate coordinates) {
        this.shipType = shipType;
        this.originCoordinates = coordinates;
        this.occupiedCoordinates = Coordinate.generateShipOfOccupiedCoordinates(originCoordinates, shipType.getSize());
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
        if ( originCoordinates.x<0 || originCoordinates.y<0)
            return true;
        for (Coordinate occupiedCordinate : occupiedCoordinates){
            if(occupiedCordinate.x >= VAR.MAX_BOARD_SIZE || occupiedCordinate.y >= VAR.MAX_BOARD_SIZE)
                return true;
        }
        return false;
    }

}
