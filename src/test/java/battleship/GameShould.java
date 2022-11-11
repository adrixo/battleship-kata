package battleship;

import battleship.exceptions.OccupiedSpaceException;
import battleship.exceptions.ShipOutOfBoundException;
import battleship.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameShould {

    @Mock
    Console console;
    private Game game;
    @Mock
    PlayerService playerService;
    @Mock
    Player playerMock;

    @BeforeEach
    public void
    setup() {
        game = new Game(console, playerService);
    }

    @Test
    public void
    add_one_player() {
        Player player = new Player("player1");
        game.addPlayer(player);
        verify(playerService).addPlayer(player);
    }

    @Test
    public void
    add_g_ship() throws OccupiedSpaceException, ShipOutOfBoundException {
        Player player = new Player("Player1");
        game.addPlayer(player);
        Coordinate coordinates = new Coordinate(7, 2, DIRECTION.HORIZONTAL);
        Ship ship = new Ship(SHIP_TYPE.GUNSHIP, coordinates);
        game.addShip(ship, PLAYER_NM.ONE);
        verify(playerService).addShip(ship, PLAYER_NM.ONE);
    }

    @Test
    public void
    print_current_player()  {
        when(playerService.currentPlayer()).thenReturn(new Player("player1"));
        game.print();
        verify(console).printPlayersBoard(isA(Player.class));
    }

    @Test public void
    fire() {
        when(playerService.currentPlayer()).thenReturn(playerMock);
        game.fire(new Coordinate(0,0));
        then(playerService).should().swapPlayer();
    }
}
