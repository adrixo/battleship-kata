package battleship;

import battleship.model.PLAYER_NM;
import battleship.model.Player;
import battleship.model.Ship;

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
        if (players.size() == 1) {
            players.put(PLAYER_NM.TWO, player);
            return;
        }
        players.put(PLAYER_NM.ONE, player);
    }

    public void start() {
        throw new UnsupportedOperationException();
    }

    public void endTurONEn() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        String header = " | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |";
        console.printLine(header);
        for (int i = 0; i < 10; i++) {
            String line = "" + i + "|   |   |   |   |   |   |   |   |   |   |";
            console.printLine(line);
        }
    }

    public void fire() {
        throw new UnsupportedOperationException();
    }

    public void addShip(PLAYER_NM playerNumber, Ship Ship) {
        Player player = players.get(playerNumber);
        player.addShip(Ship);
    }

}
