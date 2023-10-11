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

	public RandomPasswordGUI(String title) {
		
		JFrame jfrm = new JFrame(title);
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(450, 250);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Password length: ");
		jfrm.add(label);

		this.inField = new JTextField(10);
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
			String pwd = this.generatePassword(length);
			this.display.append(pwd+"\n");
			
		}

	}
	
	public String generatePassword(int length) {
		return "password123";
	}

	public static void main(String[] args) {

		// Starting the GUI application
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new RandomPasswordGUI("Random Password");
			}
		});

	}

}
