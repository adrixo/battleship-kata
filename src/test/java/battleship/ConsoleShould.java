package battleship;

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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsoleShould {

    private class InjectedMock {
        public void printLine(String line) {
            throw new UnsupportedOperationException();
        }
    }
    private class TestableConsole extends Console {
        private InjectedMock im;
        public TestableConsole(InjectedMock im) {
            this.im = im;
        }
        @Override
        public void printLine(String line) {
            im.printLine(line);
        }
    }

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
        Coordinate coordinates1 = new Coordinate(7, 2, DIRECTION.HORIZONTAL);
        Coordinate coordinates2 = new Coordinate(6, 4, DIRECTION.HORIZONTAL);
        Coordinate coordinates3 = new Coordinate(1, 7, DIRECTION.HORIZONTAL);
        Coordinate coordinates4 = new Coordinate(9, 9, DIRECTION.HORIZONTAL);
        List<Coordinate> coordinates = Arrays.asList(coordinates1,coordinates2,coordinates3,coordinates4);
        when(currentPlayer.getMarkAt(any())).thenReturn(" ");
        when(currentPlayer.getMarkAt(coordinates1)).thenReturn("g");
        when(currentPlayer.getMarkAt(coordinates2)).thenReturn("g");
        when(currentPlayer.getMarkAt(coordinates3)).thenReturn("g");
        when(currentPlayer.getMarkAt(coordinates4)).thenReturn("g");
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
        console.printPlayersBoard(currentPlayer);
        for (String line : expectedBoard ) {
            verify(im).printLine(line);
        }
    }
}