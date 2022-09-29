package battleship;

import battleship.exceptions.OccupiedSpaceException;
import battleship.exceptions.ShipOutOfBoundException;
import battleship.model.*;

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

    void addShip(Ship newShip) throws OccupiedSpaceException, ShipOutOfBoundException {
        if (newShip.isOutOfBounds())
            throw new ShipOutOfBoundException();

        Player player = currentPlayer();
        for (Ship ship : player.getShips()) {
            if (ship.occupies(newShip.originCoordinates))
                throw new OccupiedSpaceException();
        }
        player.addShip(newShip);
    }
}
