package battleship;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Ship> ships;

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
}
