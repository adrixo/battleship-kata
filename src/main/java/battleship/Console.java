package battleship;

import battleship.model.Coordinate;
import battleship.model.Player;

public class Console {
    public void printLine(String line) {
        System.out.println(line);
    }

    public void printPlayersBoard(Player player) {
        String header = " | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |";
        printLine(header);

        for (int y = 0; y < 10; y++) {
            String line = "" + y;
            for (int x = 0; x <= 10; x++) {
                String boardMark = player.getMarkAt(new Coordinate(x, y));
                line += "| "+boardMark+" ";
            }
            line = line.trim();
            printLine(line);
        }
    }
}
