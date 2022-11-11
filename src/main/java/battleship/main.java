package battleship;

import battleship.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        Console console = new Console();
        PlayerService playerService = new PlayerService();
        Game game = new Game(console, playerService);
        Player player1 = new Player("Ana");
        game.addPlayer(player1);
        Player player2 = new Player("Bob");
        game.addPlayer(player2);

        System.out.println("Wellcome to Battleship!\n");

        game.start();
        setUpShips(reader, game);

        gameLoop(reader, game);
        System.out.println("The winner is " + game.getWinner());
    }

    private static void gameLoop(BufferedReader reader, Game game) {
        while(game.getWinner() != null) {
            int x, y;
            game.print();
            while(true) {
                try {
                    System.out.println("Enter x: \n");
                    x = Integer.parseInt(reader.readLine());
                    System.out.println("Enter y: \n");
                    y = Integer.parseInt(reader.readLine());
                    break;
                } catch (Exception e) {
                    System.out.println("  Invalid value");
                }
            }
            game.fire(new Coordinate(x, y));
        }
    }

    private static void setUpShips(BufferedReader reader, Game game) {
        for(PLAYER_NM playerNumber : PLAYER_NM.values()){
            System.out.println("Setting for player " + playerNumber);
            for (SHIP_TYPE shipType : SHIP_TYPE.values()) {
                int x, y;
                while(true) {
                    try {
                        System.out.println("  Enter x for " + shipType);
                        x = Integer.parseInt(reader.readLine());
                        System.out.println("  Enter y for " + shipType);
                        y = Integer.parseInt(reader.readLine());
                        break;
                    } catch (Exception e) {
                        System.out.println("  Invalid value");
                    }
                }
                Ship ship = new Ship(shipType, new Coordinate(x, y));
                game.addShip(ship, playerNumber);
            }
            game.print(playerNumber);
        }
    }
}
