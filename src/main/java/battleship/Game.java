package battleship;

import java.util.ArrayList;

public class Game {
    private Console console;
    public final ArrayList<Player> players;

    public Game(Console console) {
        this.console = console;
        players = new ArrayList<Player>();
    }

    public void addPlayer(Player player) {
        if (players.size() >= 2)
            throw new UnsupportedOperationException();
        players.add(player);
    }

    public void start() {
        throw new UnsupportedOperationException();
    }

    public void endTurn() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }

    public void fire() {
        throw new UnsupportedOperationException();
    }

        public void addShip(String playerName, String shipType, int x, int y, String direction) {
            throw new UnsupportedOperationException();
        }
}
