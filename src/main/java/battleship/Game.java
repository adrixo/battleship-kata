package battleship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private Console console;
    public final Map<PLAYER_NM, Player> players;

    public Game(Console console) {
        this.console = console;
        players = new HashMap<>();
    }

    public void addPlayer(Player player) {
        if (players.size() >= 2)
            throw new UnsupportedOperationException();
        if (players.size() == 1)
            players.put(PLAYER_NM.TWO, player);
        players.put(PLAYER_NM.ONE, player);
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

    public void addShip(PLAYER_NM playerNumber, Ship Ship) {
        Player player = players.get(playerNumber);
        player.addShip(Ship);
    }

}
