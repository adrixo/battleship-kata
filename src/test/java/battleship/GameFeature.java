package battleship;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
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
        String playerName = "Player1";
        game.addPlayer(playerName);

        game.addShip(playerName, "g", 7, 2, "vertical");
        game.addShip(playerName, "g", 6, 4, "vertical");
        game.addShip(playerName, "g", 1, 7, "vertical");
        game.addShip(playerName, "g", 9, 9, "vertical");
        game.addShip(playerName, "d", 2, 3, "horizontal");
        game.addShip(playerName, "d", 7, 5, "vertical");
        game.addShip(playerName, "d", 8, 4, "vertical");

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