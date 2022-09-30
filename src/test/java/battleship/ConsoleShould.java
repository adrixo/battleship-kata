package battleship;

import battleship.mocks.InjectedMock;
import battleship.mocks.TestableConsole;
import battleship.mocks.TestablePlayer;
import battleship.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.not;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsoleShould {

    @Mock
    Player currentPlayer;

    @Mock
    InjectedMock im;
    Console console;

    @BeforeEach
    void setUp() {
        console = new TestableConsole(im);
    }

    @Test
    public void
    print_player1_void_board() {
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
        when(currentPlayer.getMarkAt(isA(Coordinate.class))).thenReturn(" ");
        console.printPlayersBoard(currentPlayer);
        for (String line : voidBoard ) {
            verify(im).printLine(line);
        }
    }

    @Test public void
    print_player1_four_gunships() {
        // TODO: Console should print a more generic object instead of managing the Player
        Coordinate coordinates1 = new Coordinate(7, 2, DIRECTION.NONE);
        Coordinate coordinates2 = new Coordinate(6, 4, DIRECTION.NONE);
        Coordinate coordinates3 = new Coordinate(1, 7, DIRECTION.NONE);
        Coordinate coordinates4 = new Coordinate(9, 9, DIRECTION.NONE);
        List<Coordinate> coordinates = Arrays.asList(coordinates1,coordinates2,coordinates3,coordinates4);
        TestablePlayer player = new TestablePlayer(coordinates);
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
                "9|   |   |   |   |   |   |   |   | g | g |"
        };
        console.printPlayersBoard(player);
        for (String line : expectedBoard ) {
            verify(im).printLine(line);
        }
    }
}