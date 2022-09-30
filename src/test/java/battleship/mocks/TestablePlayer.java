package battleship.mocks;

import battleship.model.Coordinate;
import battleship.model.Player;

import java.util.ArrayList;
import java.util.List;

public class TestablePlayer extends Player {
    private List<Coordinate> coordinates;

    public TestablePlayer(List<Coordinate> coordinates) {
        super("mock");
        this.coordinates = coordinates;
    }

    @Override
    public String getMarkAt(Coordinate coordinate) {
        for (Coordinate c : coordinates) {
            if (coordinate.x == c.x && coordinate.y == c.y)
                return "g";
        }
        return " ";
    }
}
