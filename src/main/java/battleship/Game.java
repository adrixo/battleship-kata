package battleship;

import battleship.model.Coordinate;
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
        // Tipografia de los cuadernos rubio!
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

    public void print() {
        Player currentPlayer = players.get(PLAYER_NM.ONE);

        String header = " | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |";
        console.printLine(header);

        for (int y = 0; y < 10; y++) {
            String line = "" + y;
            for (int x = 0; x <= 10; x++) {
                String boardMark = currentPlayer.getMarkAt(new Coordinate(x, y));
                line += "| "+boardMark+" ";
            }
            line = line.trim();
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
