import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Yves
 *
 */
public class GreeterGUI implements ActionListener {

	private JTextArea display;
	private JTextField inField;
	private JButton goButton;
	private Greeter greeter;

	public GreeterGUI(String title) {
		
		this.greeter = new Greeter();
		
		JFrame jfrm = new JFrame(title);
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(450, 250);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Enter name: ");
		jfrm.add(label);

		this.inField = new JTextField(10);
		jfrm.add(this.inField);

		this.goButton = new JButton("Click here for a greeting");
		this.goButton.addActionListener(this);
		jfrm.add(this.goButton);
		
		this.display = new JTextArea(10, 30);
		jfrm.add(this.display);

		jfrm.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		// TODO implement button callback
		if (e.getSource() == this.goButton) {
		}

	}

	public static void main(String[] args) {

		// Starting the GUI application
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GreeterGUI("Greetings");
			}
		});

	}

}
