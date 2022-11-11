package battleship.model;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Ship> ships;
    private ArrayList<Coordinate> hits;

    public Player(String name) {
        this.name = name;
        this.ships = new ArrayList<>();
        this.hits = new ArrayList<>();
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
                for(Coordinate hit : hits) {
                    if(coordinate.x == hit.x && coordinate.y == hit.y && ship.occupies(coordinate)){
                        return "X";
                    }
                }
                return ship.getMark();
            }
        }
        for(Coordinate hit : hits) {
            if (coordinate.x == hit.x && coordinate.y == hit.y) {
                return ".";
            }
        }
        return " ";
    }

    public void hitAt(Coordinate coordinate) {
        hits.add(coordinate);
    }
}
