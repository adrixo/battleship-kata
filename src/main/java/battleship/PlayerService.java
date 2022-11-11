package battleship;

import battleship.exceptions.OccupiedSpaceException;
import battleship.exceptions.ShipOutOfBoundException;
import battleship.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerService {

    public final Map<PLAYER_NM, Player> players = new HashMap<>();
    PLAYER_NM current;

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
        current = PLAYER_NM.ONE;
    }

    public Player currentPlayer() {
        if (current == null)
            throw new UnsupportedOperationException();
        return players.get(current);
    }

    void addShip(Ship newShip, PLAYER_NM playerNm) throws OccupiedSpaceException, ShipOutOfBoundException {
        verifyOutOfBounds(newShip);
        Player player = players.get(playerNm);
        verifyNotColision(player.getShips(), newShip);
        player.addShip(newShip);
    }

    private static void verifyNotColision(ArrayList<Ship> ships, Ship newShip) throws OccupiedSpaceException {
        for (Ship ship : ships) {
            for (Coordinate occupiedCoordinates : ship.occupiedCoordinates)
                if (newShip.occupies(occupiedCoordinates))
                    throw new OccupiedSpaceException();
        }
    }

    private static void verifyOutOfBounds(Ship newShip) throws ShipOutOfBoundException {
        if (newShip.isOutOfBounds())
            throw new ShipOutOfBoundException();
    }

    public Object currentPlayerFire(Coordinate coordinate) {
        throw new UnsupportedOperationException();
    }

    public void swapPlayer() {
        current = current.swap();
    }
}
