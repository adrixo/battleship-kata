package battleship.model;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Coordinate> generateLine(Coordinate originCoordinates1, int size) {
        ArrayList<Coordinate> shipCoordinates = new ArrayList<>();
        shipCoordinates.add(originCoordinates1);
        for (int steps = 0; steps < size; steps++) {
            shipCoordinates.add(originCoordinates1.getPositionAt(steps));
        }
        return shipCoordinates;
    }

    public Coordinate getPositionAt(int numberOfSteps) {
        if(direction==DIRECTION.HORIZONTAL)
            return new Coordinate(x+numberOfSteps, y, direction);
        if(direction==DIRECTION.VERTICAL)
            return new Coordinate(x, y+numberOfSteps, direction);
        return new Coordinate(x,y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        String xyComposed = x + "-" + y;
        return xyComposed.hashCode();
    }
}
