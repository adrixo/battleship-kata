package battleship.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private ArrayList<Ship> ships;
    public final Map<Coordinate, Boolean> hits = new HashMap<>();

    public Player(String name) {
        this.name = name;
        this.ships = new ArrayList<>();
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public String getMarkAt(Coordinate coordinate) {
        for (Ship ship : ships) {
            if (ship.occupies(coordinate)) {
                if (hasHit(coordinate))
                    return "X";
                return ship.getMark();
            }
        }
        if (hasHit(coordinate))
            return ".";
        return " ";
    }

    private boolean hasHit(Coordinate coordinate) {
        Boolean hit = hits.get(coordinate);
        if (hit == null)
            return false;
        return true;
    }

    public void hitAt(Coordinate coordinate) {
        hits.put(coordinate, true);
    }

    public boolean hasAliveShips() {
        for(Ship ship : ships) {
            if (ship.lives != 0)
                return false;
        }
        return true;
    }
}
