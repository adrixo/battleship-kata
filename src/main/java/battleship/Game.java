package battleship;

import battleship.exceptions.OccupiedSpaceException;
import battleship.exceptions.ShipOutOfBoundException;
import battleship.model.PLAYER_NM;
import battleship.model.Player;
import battleship.model.Ship;

public class Game {
    private Console console;
    private final PlayerService playerService;

    public Game(Console console, PlayerService playerService) {
        this.console = console;
        this.playerService = playerService;
    }

    public void addPlayer(Player player) {
        playerService.addPlayer(player);
    }

    public void start() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        Player currentPlayer = playerService.currentPlayer();

        console.printPlayersBoard(currentPlayer);
    }

    public void fire() {
        throw new UnsupportedOperationException();
    }

    public void addShip(Ship Ship, PLAYER_NM player) throws OccupiedSpaceException, ShipOutOfBoundException {
        playerService.addShip(Ship, player);
    }

}
