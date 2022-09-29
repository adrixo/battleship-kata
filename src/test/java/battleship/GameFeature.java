package battleship;

import battleship.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GameFeature {
    @Mock
    Console console;

    @BeforeEach
    void setUp() {
    }

    @Test
    void place_ships_and_print_board() {
        Game game = new Game(console);
        Player player1 = new Player("Player1");
        game.addPlayer(player1);

        Coordinate coordinates1 = new Coordinate(7, 2, DIRECTION.HORIZONTAL);
        Ship ship1 = new Ship(SHIP_TYPE.GUNSHIP, coordinates1);
        Coordinate coordinates2 = new Coordinate(6, 4, DIRECTION.HORIZONTAL);
        Ship ship2 = new Ship(SHIP_TYPE.GUNSHIP, coordinates2);
        Coordinate coordinates3 = new Coordinate(1, 7, DIRECTION.HORIZONTAL);
        Ship ship3 = new Ship(SHIP_TYPE.GUNSHIP, coordinates3);
        Coordinate coordinates4 = new Coordinate(9, 9, DIRECTION.HORIZONTAL);
        Ship ship4 = new Ship(SHIP_TYPE.GUNSHIP, coordinates4);
        Coordinate coordinates5 = new Coordinate(2, 3, DIRECTION.HORIZONTAL);
        Ship ship5 = new Ship(SHIP_TYPE.DESTRUCTOR, coordinates5);
        Coordinate coordinates6 = new Coordinate(5, 7, DIRECTION.VERTICAL);
        Ship ship6 = new Ship(SHIP_TYPE.DESTRUCTOR, coordinates6);
        Coordinate coordinates7 = new Coordinate(8, 4, DIRECTION.VERTICAL);
        Ship ship7 = new Ship(SHIP_TYPE.CARRIER, coordinates7);

        game.addShip(PLAYER_NM.ONE, ship1);
        game.addShip(PLAYER_NM.ONE, ship2);
        game.addShip(PLAYER_NM.ONE, ship3);
        game.addShip(PLAYER_NM.ONE, ship4);
        game.addShip(PLAYER_NM.ONE, ship5);
        game.addShip(PLAYER_NM.ONE, ship6);
        game.addShip(PLAYER_NM.ONE, ship7);

        game.print();

        String[] resultLines = new String[]{
                " | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |",
                "0|   |   |   |   |   |   |   |   |   |   |",
                "1|   |   |   |   |   |   |   |   |   |   |",
                "2|   |   |   |   |   |   |   | g |   |   |",
                "3|   |   | d | d | d |   |   |   |   |   |",
                "4|   |   |   |   |   |   | g |   | c |   |",
                "5|   |   |   |   |   |   |   |   | c |   |",
                "6|   |   |   |   |   |   |   |   | c |   |",
                "7|   | g |   |   |   | d |   |   | c |   |",
                "8|   |   |   |   |   | d |   |   |   |   |",
                "9|   |   |   |   |   | d |   |   |   | g |"
        };

        for(String line : resultLines) {
            verify(console).printLine(line);
        }
    }
}