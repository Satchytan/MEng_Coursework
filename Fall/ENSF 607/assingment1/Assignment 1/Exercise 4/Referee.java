/**
 * Manages the game flow and player turns in a Tic-Tac-Toe game.
 */
public class Referee {
    private Board board;
    private Player xPlayer;
    private Player oPlayer;

    /**
     * Sets the game board for the referee.
     *
     * @param board The game board to be set.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Sets the 'X' player for the game.
     *
     * @param xPlayer The 'X' player to be set.
     */
    public void setxPlayer(Player xPlayer) {
        this.xPlayer = xPlayer;
    }

    /**
     * Sets the 'O' player for the game.
     *
     * @param oPlayer The 'O' player to be set.
     */
    public void setoPlayer(Player oPlayer) {
        this.oPlayer = oPlayer;
    }

    /**
     * Runs the Tic-Tac-Toe game by managing player turns.
     */
    public void runTheGame() {
        Player currentPlayer = xPlayer; // 'X' always starts
        Player otherPlayer = oPlayer;

        while (true) {
            board.display();
            System.out.println(currentPlayer.getName() + ", it's your turn.");
            currentPlayer.play();

            if (board.xWins()) {
                board.display();
                System.out.println("Congratulations, " + xPlayer.getName() + "! You win!");
                break;
            } else if (board.oWins()) {
                board.display();
                System.out.println("Congratulations, " + oPlayer.getName() + "! You win!");
                break;
            } else if (board.isFull()) {
                board.display();
                System.out.println("The game ends in a tie.");
                break;
            }

            // Switch players for the next turn
            Player temp = currentPlayer;
            currentPlayer = otherPlayer;
            otherPlayer = temp;
        }
    }
}
