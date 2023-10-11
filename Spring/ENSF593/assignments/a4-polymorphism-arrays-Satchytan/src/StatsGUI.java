import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * GUI for grade statistics
 * 
 * Allows the user to inpt grades and sorts them from lowest to highest 
 * then computes the average and median
 *
 * @author Satchytan Karalasingham
 */
public class StatsGUI implements ActionListener {
	private JTextField inputField;
	private JTextArea display;
	private JButton reset, displayStats;
	private Stats stats;		//Add stats instance variable

	
	/**
	 * Creates a new instance of StatsGUI and initializes its components
	 * 
	 * @param title
	 */
	public StatsGUI(String title) { 
		
		stats = new Stats(); 	//Instantiate stats object
		
		
		JFrame jfrm = new JFrame(title);
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(300, 200);  
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel prompt = new JLabel("Next Grade (press ENTER)");
		jfrm.add(prompt);
		
		this.inputField = new JTextField(4); 
		this.inputField.setText("");
		this.inputField.addActionListener( this ); 
		jfrm.add(inputField);
		
		this.display = new JTextArea (5 ,20);
		jfrm.add(display);
		
		displayStats = new JButton("STATS");
		displayStats.addActionListener(this);
		jfrm.add(displayStats);

		reset = new JButton("RESET");
		reset.addActionListener(this);
		jfrm.add(reset);
		
		jfrm.setVisible(true);	
			
	}

	/**
	 * Handles the events to take place depending on trigger from user on StatsGUI
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == inputField) {
			int number = Integer.parseInt(inputField.getText());
			stats.add(number); 		// ADD THE GRADE TO stats
			inputField.setText("");	//Clear input field
		}else if (e.getSource() == displayStats) {	//Add handling of display button -  DISPLAY THE RESULTS
			String result = stats.toString(); 	//Get results from stats
			display.setText(result);			//Display results
		}else if (e.getSource() == reset) {		//Add handling of reset button - CREATE A NEW stats
			stats = new Stats();
			display.setText("");
		}
	}

	/**
	 * Entry point for the program, opens GUI in window
	 * 
	 */
	public static void main(String[] args) {
		//Starting the GUI application
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new StatsGUI("Grades statistics");
			}
		});
	}
}
