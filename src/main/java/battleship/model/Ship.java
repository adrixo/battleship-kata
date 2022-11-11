package battleship.model;

import java.util.List;

public class Ship {
    private SHIP_TYPE shipType;
    public final Coordinate originCoordinates;
    public int lives;
    public final List<Coordinate> occupiedCoordinates;

    public Ship(SHIP_TYPE shipType, Coordinate coordinates) {
        this.shipType = shipType;
        this.originCoordinates = coordinates;
        this.occupiedCoordinates = Coordinate.generateLine(originCoordinates, shipType.getSize());
        this.lives = shipType.getSize();
    }

    public boolean occupies(Coordinate point) {
        for (Coordinate occupiedCoordinate : occupiedCoordinates) {
            if (occupiedCoordinate.x == point.x && occupiedCoordinate.y == point.y)
                return true;
        }
        return false;
    }

    public String getMark() {
        return shipType.getAbbr();
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
