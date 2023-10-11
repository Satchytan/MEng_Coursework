import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
	
/**
 * @author : Satchytan Karalasingham
 *
 * Graphical user interface for the SecretWord class which enables the user to play the secret word guessing game.
 */
public class SecretWordGUI implements ActionListener{

	private JTextField inputField; 
	private JTextArea display;
    private String inputString;
    private SecretWord secret;

	public SecretWordGUI(String title)  {
		this.secret = new SecretWord();
		
		JFrame jfrm = new JFrame(title);
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(500, 250 );  
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel prompt = new JLabel("Input a single character to guess the secret word (hit ENTER):");
		jfrm.add(prompt);
		
		this.inputField = new JTextField(1); 
		this.inputField.setText("");
		this.inputField.addActionListener( this ); 
		jfrm.add(inputField);
		
		this.display = new JTextArea (10 ,30);
		this.display.append("The secret word: " + secret.getDisplayedWord() +"\n");
		jfrm.add(display);
		
		jfrm.setVisible(true);

	}

	public void actionPerformed(ActionEvent evt)  { 
		if ( evt.getSource() == inputField) { 
			this.inputString = inputField.getText();
	        this.inputField.setText("");
	        boolean guess = secret.makeGuess(inputString.charAt(0));

	                            // Process the user's guess
	        if (guess == true) 
	            this.display.append ("That Guess Was Right " + secret.getDisplayedWord() + "\n");
	        else 
	            this.display.append ("That Guess Was Wrong " + secret.getDisplayedWord() + "\n");

		}
	}

	public static void main(String[] args) {

		//Starting the GUI application
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SecretWordGUI("Guess the secret word");
			}
		});

	}

}

