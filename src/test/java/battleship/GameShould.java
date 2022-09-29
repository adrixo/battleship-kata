package battleship;

import battleship.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

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
        Coordinate coordinates = new Coordinate(7, 2, DIRECTION.HORIZONTAL);
        Ship ship = new Ship(SHIP_TYPE.GUNSHIP, coordinates);

        game.addShip(PLAYER_NM.ONE, ship);

        assertThat(game.players.get(PLAYER_NM.ONE).getShips()).contains(ship);
    }

    @Test public void
    add_three_tipes_of_ships() {
        Player player = new Player("Player1");
        game.addPlayer(player);

        Coordinate coordinates1 = new Coordinate(7, 2, DIRECTION.HORIZONTAL);
        Ship ship1 = new Ship(SHIP_TYPE.GUNSHIP, coordinates1);
        Coordinate coordinates6 = new Coordinate(5, 7, DIRECTION.VERTICAL);
        Ship ship6 = new Ship(SHIP_TYPE.DESTRUCTOR, coordinates6);
        Coordinate coordinates7 = new Coordinate(8, 4, DIRECTION.VERTICAL);
        Ship ship7 = new Ship(SHIP_TYPE.CARRIER, coordinates7);

        game.addShip(PLAYER_NM.ONE, ship1);
        game.addShip(PLAYER_NM.ONE, ship6);
        game.addShip(PLAYER_NM.ONE, ship7);

        assertThat(game.players.get(PLAYER_NM.ONE).getShips()).contains(ship1);
        assertThat(game.players.get(PLAYER_NM.ONE).getShips()).contains(ship6);
        assertThat(game.players.get(PLAYER_NM.ONE).getShips()).contains(ship7);
    }

    @Test public void
    print_player1_void_board() {
        game.addPlayer(new Player("Player1"));
        game.print();

        String[] voidBoard = new String[]{
                " | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |",
                "0|   |   |   |   |   |   |   |   |   |   |",
                "1|   |   |   |   |   |   |   |   |   |   |",
                "2|   |   |   |   |   |   |   |   |   |   |",
                "3|   |   |   |   |   |   |   |   |   |   |",
                "4|   |   |   |   |   |   |   |   |   |   |",
                "5|   |   |   |   |   |   |   |   |   |   |",
                "6|   |   |   |   |   |   |   |   |   |   |",
                "7|   |   |   |   |   |   |   |   |   |   |",
                "8|   |   |   |   |   |   |   |   |   |   |",
                "9|   |   |   |   |   |   |   |   |   |   |"
        };

        for (String line : voidBoard ) {
            verify(console).printLine(line);
        }
    }

    @Test public void
    print_player1_one_gunship_on72() {
        game.addPlayer(new Player("Player1"));

        Coordinate coordinates1 = new Coordinate(7, 2, DIRECTION.HORIZONTAL);
        Ship ship1 = new Ship(SHIP_TYPE.GUNSHIP, coordinates1);
        game.addShip(PLAYER_NM.ONE, ship1);

        String[] expectedBoard = new String[]{
                " | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |",
                "0|   |   |   |   |   |   |   |   |   |   |",
                "1|   |   |   |   |   |   |   |   |   |   |",
                "2|   |   |   |   |   |   |   | g |   |   |",
                "3|   |   |   |   |   |   |   |   |   |   |",
                "4|   |   |   |   |   |   |   |   |   |   |",
                "5|   |   |   |   |   |   |   |   |   |   |",
                "6|   |   |   |   |   |   |   |   |   |   |",
                "7|   |   |   |   |   |   |   |   |   |   |",
                "8|   |   |   |   |   |   |   |   |   |   |",
                "9|   |   |   |   |   |   |   |   |   |   |"
        };

        game.print();

        for (String line : expectedBoard ) {
            verify(console).printLine(line);
        }
    }

    @Test public void
    print_player1_four_gunships() {
        game.addPlayer(new Player("Player1"));

        Coordinate coordinates1 = new Coordinate(7, 2, DIRECTION.HORIZONTAL);
        Ship ship1 = new Ship(SHIP_TYPE.GUNSHIP, coordinates1);
        Coordinate coordinates2 = new Coordinate(6, 4, DIRECTION.HORIZONTAL);
        Ship ship2 = new Ship(SHIP_TYPE.GUNSHIP, coordinates2);
        Coordinate coordinates3 = new Coordinate(1, 7, DIRECTION.HORIZONTAL);
        Ship ship3 = new Ship(SHIP_TYPE.GUNSHIP, coordinates3);
        Coordinate coordinates4 = new Coordinate(9, 9, DIRECTION.HORIZONTAL);
        Ship ship4 = new Ship(SHIP_TYPE.GUNSHIP, coordinates4);
        game.addShip(PLAYER_NM.ONE, ship1);
        game.addShip(PLAYER_NM.ONE, ship2);
        game.addShip(PLAYER_NM.ONE, ship3);
        game.addShip(PLAYER_NM.ONE, ship4);

        String[] expectedBoard = new String[]{
                " | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |",
                "0|   |   |   |   |   |   |   |   |   |   |",
                "1|   |   |   |   |   |   |   |   |   |   |",
                "2|   |   |   |   |   |   |   | g |   |   |",
                "3|   |   |   |   |   |   |   |   |   |   |",
                "4|   |   |   |   |   |   | g |   |   |   |",
                "5|   |   |   |   |   |   |   |   |   |   |",
                "6|   |   |   |   |   |   |   |   |   |   |",
                "7|   | g |   |   |   |   |   |   |   |   |",
                "8|   |   |   |   |   |   |   |   |   |   |",
                "9|   |   |   |   |   |   |   |   |   | g |"
        };

        game.print();

        for (String line : expectedBoard ) {
            verify(console).printLine(line);
        }
    }
}