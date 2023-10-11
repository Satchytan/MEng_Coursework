import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Yves
 *
 */
public class RandomPasswordGUI implements ActionListener {
	
	private JTextArea display;
	private JTextField inField;
	private JButton goButton;
	//TODO add a PasswordGenerator object
	private PasswordGenerator generator;

	public RandomPasswordGUI(String title) {
		
		this.generator = new PasswordGenerator();
		
		JFrame jfrm = new JFrame(title);
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(450, 250);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Length of password: ");
		jfrm.add(label);

		// TODO use a JSpinner
		this.inField = new JTextField(2);
		jfrm.add(this.inField);

		this.goButton = new JButton("generate");
		this.goButton.addActionListener(this);
		jfrm.add(this.goButton);
		
		this.display = new JTextArea(10, 30);
		jfrm.add(this.display);

		jfrm.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		// TODO implement button callback
		if (e.getSource() == this.goButton) {
			int length = Integer.parseInt(this.inField.getText());
			this.display.append(this.generator.generatePassword(length)+"\n");

		}

	}
	
	public String generatePassword(int length) {
		return "password123";
	}

	public static void main(String[] args) {

		// Starting the GUI application
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new RandomPasswordGUI("Generate Password");
			}
		});

	}

}
