import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Represents a player in the Tic-Tac-Toe game.
 */
public class Player {
    private String name;
    private char mark;
    private Player opponent;
    private Board board;

    /**
     * Initializes a player with a name and a mark ('X' or 'O').
     *
     * @param name The name of the player.
     * @param mark The mark ('X' or 'O') of the player.
     */
    public Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    /**
     * Sets the opponent for this player.
     *
     * @param opponent The opponent player to be set.
     */
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    /**
     * Sets the game board for the player.
     *
     * @param board The game board to be set.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Executes the player's turn, prompting for a move and updating the board.
     */
    public void play() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int row, col;

        try {
            // Prompt for row and column input until a valid move is made
            while (true) {
                System.out.print("Enter the row (0-2) and column (0-2) separated by a space: ");
                String input = reader.readLine();
                String[] parts = input.split(" ");

                if (parts.length != 2) {
                    System.out.println("Invalid input. Please enter row and column numbers.");
                    continue;
                }

                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);

                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Invalid move. Row and column must be between 0 and 2.");
                    continue;
                }

                if (board.getMark(row, col) != ' ') {
                    System.out.println("Invalid move. That position is already taken.");
                    continue;
                }

                break;
            }

            // Make the move on the board
            board.addMark(row, col, mark);

        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    }

    /**
     * Gets the name of the player.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }
}
