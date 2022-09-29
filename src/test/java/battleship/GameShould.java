package battleship;

import battleship.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GameShould {

    @Mock
    Console console;
    private Game game;

    @BeforeEach public void
    setup() {
        game = new Game(console);
    }

    @Test public void
    add_one_player() {
        Player player = new Player("player1");
        game.addPlayer(player);
        assertThat(game.players.get(PLAYER_NM.ONE)).isEqualTo(player);
    }

    @Test public void
    add_two_player() {
        Player player = new Player("player1");
        Player player2 = new Player("player2");
        game.addPlayer(player);
        game.addPlayer(player2);
        assertThat(game.players.get(PLAYER_NM.ONE)).isEqualTo(player);
        assertThat(game.players.get(PLAYER_NM.TWO)).isEqualTo(player2);
    }

    @Test public void
    throw_exception_when_add_3_players() {
        Player player = new Player("player1");
        Player player2 = new Player("player2");
        Player player3 = new Player("player3");
        game.addPlayer(player);
        game.addPlayer(player2);
        assertThat(game.players.get(PLAYER_NM.ONE)).isEqualTo(player);
        assertThat(game.players.get(PLAYER_NM.TWO)).isEqualTo(player2);

        assertThrows(
                UnsupportedOperationException.class,
                () -> {
                    game.addPlayer(player3);
                }
        );
    }

    @Test public void
    add_g_ship() {
        Player player = new Player("Player1");
        game.addPlayer(player);
        Coordinates coordinates = new Coordinates(7, 2, DIRECTION.HORIZONTAL);
        Ship ship = new Ship(SHIP_TYPE.SHOTGUN, coordinates);

        game.addShip(PLAYER_NM.ONE, ship);

        assertThat(game.players.get(PLAYER_NM.ONE).getShips()).contains(ship);
    }

    @Test public void
    add_three_tipes_of_ships() {
        Player player = new Player("Player1");
        game.addPlayer(player);

        Coordinates coordinates1 = new Coordinates(7, 2, DIRECTION.HORIZONTAL);
        Ship ship1 = new Ship(SHIP_TYPE.SHOTGUN, coordinates1);
        Coordinates coordinates6 = new Coordinates(5, 7, DIRECTION.VERTICAL);
        Ship ship6 = new Ship(SHIP_TYPE.DESTRUCTOR, coordinates6);
        Coordinates coordinates7 = new Coordinates(8, 4, DIRECTION.VERTICAL);
        Ship ship7 = new Ship(SHIP_TYPE.CARRIER, coordinates7);

        game.addShip(PLAYER_NM.ONE, ship1);
        game.addShip(PLAYER_NM.ONE, ship6);
        game.addShip(PLAYER_NM.ONE, ship7);

        assertThat(game.players.get(PLAYER_NM.ONE).getShips()).contains(ship1);
        assertThat(game.players.get(PLAYER_NM.ONE).getShips()).contains(ship6);
        assertThat(game.players.get(PLAYER_NM.ONE).getShips()).contains(ship7);
    }
}