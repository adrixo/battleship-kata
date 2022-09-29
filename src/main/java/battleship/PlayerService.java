package battleship;

import battleship.model.PLAYER_NM;
import battleship.model.Player;
import battleship.model.Ship;

import java.util.HashMap;
import java.util.Map;

public class PlayerService {

    public final Map<PLAYER_NM, Player> players = new HashMap<>();

    public void addPlayer(Player player) {
        if (players.size() >= 2)
            throw new UnsupportedOperationException();
        if (players.size() == 1) {
            players.put(PLAYER_NM.TWO, player);
            return;
        }
        players.put(PLAYER_NM.ONE, player);
    }

    public Player currentPlayer() {
        return players.get(PLAYER_NM.ONE);
    }

    void addShip(Ship Ship) {
        Player player = currentPlayer();
        player.addShip(Ship);
    }
}
