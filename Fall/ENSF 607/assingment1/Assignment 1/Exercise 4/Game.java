
import java.io.*;

/**
 * The main class that represents the Tic-Tac-Toe game.
 * It initializes the game and appoints a referee to run it.
 */

public class Game implements Constants {

	private Board theBoard;
	private Referee theRef;
	
    /**
     * Initializes the game by creating a new board.
     */
    public Game( ) {
        theBoard  = new Board();
	}
    
    /**
     * Appoints a referee for the game and starts the game.
     *
     * @param r The referee to be appointed.
     * @throws IOException If an I/O error occurs.
     */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }
	
    /**
     * The main method to start the Tic-Tac-Toe game.
     *
     * @param args Command-line arguments (not used in this program).
     * @throws IOException If an I/O error occurs.
     */
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

        // Get the name of the 'X' player
		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
        // Get the name of the 'O' player
		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);
		
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef);
	}
	

}
