package battleship;

import battleship.exceptions.OccupiedSpaceException;
import battleship.exceptions.ShipOutOfBoundException;
import battleship.mocks.InjectedMock;
import battleship.mocks.TestableConsole;
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
    InjectedMock im;
    Console console;
    PlayerService playerService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void place_ships_and_print_board() throws OccupiedSpaceException, ShipOutOfBoundException {
        console = new TestableConsole(im);
        playerService = new PlayerService();
        Game game = new Game(console, playerService);
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

        game.addShip(ship1, PLAYER_NM.ONE);
        game.addShip(ship2, PLAYER_NM.ONE);
        game.addShip(ship3, PLAYER_NM.ONE);
        game.addShip(ship4, PLAYER_NM.ONE);
        game.addShip(ship5, PLAYER_NM.ONE);
        game.addShip(ship6, PLAYER_NM.ONE);
        game.addShip(ship7, PLAYER_NM.ONE);

        game.start();
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
            verify(im).printLine(line);
        }
    }
    @Test
    void both_players_fire() throws OccupiedSpaceException, ShipOutOfBoundException {
        console = new TestableConsole(im);
        playerService = new PlayerService();
        Game game = new Game(console, playerService);
        Player player1 = new Player("Player1");
        game.addPlayer(player1);
        Player player2 = new Player("Player2");
        game.addPlayer(player2);

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
        game.addShip(ship1, PLAYER_NM.ONE);
        game.addShip(ship2, PLAYER_NM.ONE);
        game.addShip(ship3, PLAYER_NM.ONE);
        game.addShip(ship4, PLAYER_NM.ONE);
        game.addShip(ship5, PLAYER_NM.ONE);
        game.addShip(ship6, PLAYER_NM.ONE);
        game.addShip(ship7, PLAYER_NM.ONE);
        Coordinate coordinates1P2 = new Coordinate(7, 2, DIRECTION.HORIZONTAL);
        Ship ship1P2 = new Ship(SHIP_TYPE.GUNSHIP, coordinates1P2);
        Coordinate coordinates2P2 = new Coordinate(6, 4, DIRECTION.HORIZONTAL);
        Ship ship2P2 = new Ship(SHIP_TYPE.GUNSHIP, coordinates2P2);
        Coordinate coordinates3P2 = new Coordinate(1, 7, DIRECTION.HORIZONTAL);
        Ship ship3P2 = new Ship(SHIP_TYPE.GUNSHIP, coordinates3P2);
        Coordinate coordinates4P2 = new Coordinate(9, 9, DIRECTION.HORIZONTAL);
        Ship ship4P2 = new Ship(SHIP_TYPE.GUNSHIP, coordinates4P2);
        Coordinate coordinates5P2 = new Coordinate(2, 3, DIRECTION.HORIZONTAL);
        Ship ship5P2 = new Ship(SHIP_TYPE.DESTRUCTOR, coordinates5P2);
        Coordinate coordinates6P2 = new Coordinate(5, 7, DIRECTION.VERTICAL);
        Ship ship6P2 = new Ship(SHIP_TYPE.DESTRUCTOR, coordinates6P2);
        Coordinate coordinates7P2 = new Coordinate(8, 4, DIRECTION.VERTICAL);
        Ship ship7P2 = new Ship(SHIP_TYPE.CARRIER, coordinates7P2);
        game.addShip(ship1P2, PLAYER_NM.TWO);
        game.addShip(ship2P2, PLAYER_NM.TWO);
        game.addShip(ship3P2, PLAYER_NM.TWO);
        game.addShip(ship4P2, PLAYER_NM.TWO);
        game.addShip(ship5P2, PLAYER_NM.TWO);
        game.addShip(ship6P2, PLAYER_NM.TWO);
        game.addShip(ship7P2, PLAYER_NM.TWO);
        String[] resultLinesP2 = new String[]{
                " | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |",
                "0|   |   |   |   |   |   |   |   |   |   |",
                "1|   |   |   |   |   |   |   | g |   |   |",
                "2|   |   | d | d | d |   |   |   |   |   |",
                "3|   |   |   |   | . |   | g |   | c |   |",
                "4|   |   |   |   | . |   | . |   | c |   |",
                "5|   |   |   |   |   |   |   |   | c |   |",
                "6|   | g |   |   |   | d |   |   | X |   |",
                "7|   |   |   |   |   | d |   |   |   |   |",
                "8|   |   |   |   |   | d |   |   |   | g |",
                "9|   |   |   |   |   |   |   |   |   |   |"
        };

        String[] resultLinesP1 = new String[]{
                " | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |",
                "0|   |   |   |   |   |   |   |   |   |   |",
                "1|   |   |   |   |   |   |   |   |   |   |",
                "2|   |   |   |   |   |   |   | g |   |   |",
                "3|   |   | d | d | X |   |   |   |   |   |",
                "4|   |   |   |   | . |   | X |   | c |   |",
                "5|   |   |   |   |   |   |   |   | c |   |",
                "6|   |   |   |   |   |   |   |   | X |   |",
                "7|   | g |   |   |   | d |   |   | c |   |",
                "8|   |   |   |   |   | d |   |   |   |   |",
                "9|   |   |   |   |   | d |   |   |   | g |"
        };
        game.start();
        game.fire(new Coordinate(4, 4));
        game.fire(new Coordinate(4, 4));
        game.fire(new Coordinate(4, 3));
        game.fire(new Coordinate(4, 3));
        game.fire(new Coordinate(6, 4));
        game.fire(new Coordinate(6, 4));
        game.fire(new Coordinate(8, 6));
        game.print();
        game.fire(new Coordinate(8, 6));
        game.print();

        for(String line : resultLinesP1) {
            verify(im).printLine(line);
        }
        for(String line : resultLinesP2) {
            verify(im).printLine(line);
        }
    }
}