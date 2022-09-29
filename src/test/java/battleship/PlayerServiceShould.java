package battleship;

import battleship.exceptions.OccupiedSpaceException;
import battleship.exceptions.ShipOutOfBoundException;
import battleship.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static battleship.model.VAR.MAX_BOARD_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class PlayerServiceShould {

    PlayerService playerService;

    @BeforeEach
    public void
    setup() {
        playerService = new PlayerService();
    }

    @Test public void
    add_one_player() {
        Player player = new Player("player1");
        playerService.addPlayer(player);
        assertThat(playerService.players.get(PLAYER_NM.ONE)).isEqualTo(player);
    }

    @Test
    public void
    add_two_player() {
        Player player = new Player("player1");
        Player player2 = new Player("player2");
        playerService.addPlayer(player);
        playerService.addPlayer(player2);
        assertThat(playerService.players.get(PLAYER_NM.ONE)).isEqualTo(player);
        assertThat(playerService.players.get(PLAYER_NM.TWO)).isEqualTo(player2);
    }

    @Test public void
    throw_exception_when_add_3_players() {
        Player player = new Player("player1");
        Player player2 = new Player("player2");
        Player player3 = new Player("player3");
        playerService.addPlayer(player);
        playerService.addPlayer(player2);
        assertThat(playerService.players.get(PLAYER_NM.ONE)).isEqualTo(player);
        assertThat(playerService.players.get(PLAYER_NM.TWO)).isEqualTo(player2);
        assertThrows(UnsupportedOperationException.class, () -> {playerService.addPlayer(player3);});
    }

    @Test public void
    add_g_ship() throws OccupiedSpaceException, ShipOutOfBoundException {
        Player player = new Player("Player1");
        playerService.addPlayer(player);
        Coordinate coordinates = new Coordinate(7, 2, DIRECTION.HORIZONTAL);
        Ship ship = new Ship(SHIP_TYPE.GUNSHIP, coordinates);
        playerService.addShip(ship);
        assertThat(playerService.players.get(PLAYER_NM.ONE).getShips()).contains(ship);
    }
        
    @Test public void
    add_three_tipes_of_ships() throws OccupiedSpaceException, ShipOutOfBoundException {
        Player player = new Player("Player1");
        playerService.addPlayer(player);
        Coordinate coordinates1 = new Coordinate(7, 2, DIRECTION.HORIZONTAL);
        Ship ship1 = new Ship(SHIP_TYPE.GUNSHIP, coordinates1);
        Coordinate coordinates6 = new Coordinate(5, 6, DIRECTION.VERTICAL);
        Ship ship6 = new Ship(SHIP_TYPE.DESTRUCTOR, coordinates6);
        Coordinate coordinates7 = new Coordinate(5, 4, DIRECTION.VERTICAL);
        Ship ship7 = new Ship(SHIP_TYPE.CARRIER, coordinates7);
        playerService.addShip(ship1);
        playerService.addShip(ship6);
        playerService.addShip(ship7);
        assertThat(playerService.players.get(PLAYER_NM.ONE).getShips()).contains(ship1);
        assertThat(playerService.players.get(PLAYER_NM.ONE).getShips()).contains(ship6);
        assertThat(playerService.players.get(PLAYER_NM.ONE).getShips()).contains(ship7);
    }

    @Test public void
    throw_exception_when_add_ship_out_of_bounds_x() {
        playerService.addPlayer(new Player("Player1"));
        Coordinate coordinates1 = new Coordinate(MAX_BOARD_SIZE, 0, DIRECTION.HORIZONTAL);
        Ship ship1 = new Ship(SHIP_TYPE.GUNSHIP, coordinates1);
        assertThrows(ShipOutOfBoundException.class, () -> {playerService.addShip(ship1); });
    }

    @Test public void
    throw_exception_when_add_ship_out_of_bounds_y() {
        playerService.addPlayer(new Player("Player1"));
        Coordinate coordinates1 = new Coordinate(0, MAX_BOARD_SIZE, DIRECTION.HORIZONTAL);
        Ship ship1 = new Ship(SHIP_TYPE.GUNSHIP, coordinates1);
        assertThrows(ShipOutOfBoundException.class, () -> {playerService.addShip(ship1); });
    }

    @Test public void
    throw_exception_when_add_ship_extension_out_of_bounds_horizontal() {
        /* C C | C*/
        playerService.addPlayer(new Player("Player1"));
        Coordinate coordinates1 = new Coordinate(MAX_BOARD_SIZE-2, 0, DIRECTION.HORIZONTAL);
        Ship ship1 = new Ship(SHIP_TYPE.CARRIER, coordinates1);
        assertThrows(ShipOutOfBoundException.class, () -> {playerService.addShip(ship1); });
    }

    @Test public void
    throw_exception_when_add_ship_extension_out_of_bounds_vertical() {
        /*  C
         *  C
         *  -
         *  C*/
        playerService.addPlayer(new Player("Player1"));
        Coordinate coordinates1 = new Coordinate(0, MAX_BOARD_SIZE-2, DIRECTION.VERTICAL);
        Ship ship1 = new Ship(SHIP_TYPE.DESTRUCTOR, coordinates1);
        assertThrows(ShipOutOfBoundException.class, () -> {playerService.addShip(ship1); });
    }

    @Test public void
    throw_exception_when_add_ship_on_occupied_space() throws OccupiedSpaceException, ShipOutOfBoundException {
        playerService.addPlayer(new Player("Player1"));
        Coordinate coordinates1 = new Coordinate(4, 4, DIRECTION.HORIZONTAL);
        Ship ship1 = new Ship(SHIP_TYPE.GUNSHIP, coordinates1);
        Ship ship2 = new Ship(SHIP_TYPE.GUNSHIP, coordinates1);
        playerService.addShip(ship1);
        assertThrows(OccupiedSpaceException.class, () -> {playerService.addShip(ship2); });
    }

    @Test public void
    throw_exception_when_add_ship_on_occupied_space_by_horizontal_extension() throws OccupiedSpaceException, ShipOutOfBoundException {
        /*
         C C [C]
         */
        playerService.addPlayer(new Player("Player1"));
        Coordinate coordinates1 = new Coordinate(4, 4, DIRECTION.HORIZONTAL);
        Coordinate coordinates2 = new Coordinate(6, 4, DIRECTION.HORIZONTAL);
        Ship ship1 = new Ship(SHIP_TYPE.CARRIER, coordinates1);
        Ship ship2 = new Ship(SHIP_TYPE.GUNSHIP, coordinates2);
        playerService.addShip(ship1);
        assertThrows(OccupiedSpaceException.class, () -> {playerService.addShip(ship2); });
    }

    @Test public void
    throw_exception_when_add_ship_on_occupied_space_by_vertical_extension() throws OccupiedSpaceException, ShipOutOfBoundException {
        /*
         C
         C
         [C]
         */
        playerService.addPlayer(new Player("Player1"));
        Coordinate coordinates1 = new Coordinate(4, 4, DIRECTION.VERTICAL);
        Coordinate coordinates2 = new Coordinate(4, 6, DIRECTION.HORIZONTAL);
        Ship ship1 = new Ship(SHIP_TYPE.CARRIER, coordinates1);
        Ship ship2 = new Ship(SHIP_TYPE.GUNSHIP, coordinates2);
        playerService.addShip(ship1);
        assertThrows(OccupiedSpaceException.class, () -> {playerService.addShip(ship2); });
    }

    @Test public void
    throw_exception_when_add_ship_on_occupied_space_both_extension() throws OccupiedSpaceException, ShipOutOfBoundException {
        /*
              C
              C
         C C [C]
         */
        playerService.addPlayer(new Player("Player1"));
        Coordinate coordinates1 = new Coordinate(4, 4, DIRECTION.VERTICAL);
        Coordinate coordinates2 = new Coordinate(2, 6, DIRECTION.HORIZONTAL);
        Ship ship1 = new Ship(SHIP_TYPE.CARRIER, coordinates1);
        Ship ship2 = new Ship(SHIP_TYPE.CARRIER, coordinates2);
        playerService.addShip(ship1);
        assertThrows(OccupiedSpaceException.class, () -> {playerService.addShip(ship2); });
    }
}