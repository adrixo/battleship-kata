package battleship;

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
        Ship ship = new Ship(SHIP.SHOTGUN, coordinates);

        game.addShip(PLAYER_NM.ONE, ship);

        assertThat(game.players.get(PLAYER_NM.ONE).getShips()).contains(ship);

    }
}