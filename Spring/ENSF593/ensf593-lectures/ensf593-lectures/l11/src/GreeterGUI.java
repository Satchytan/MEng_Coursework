import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GreeterGUI implements ActionListener {

	private JTextArea display;
	private JTextField inField;
	private JButton goButton;

	public GreeterGUI(String title) {
		
		JFrame jfrm = new JFrame(title);
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(450, 250);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Enter name: ");
		jfrm.add(label);

		this.inField = new JTextField(10);
		jfrm.add(this.inField);

		this.goButton = new JButton("Click here for a greeting");
		//TODO: change to use lambda expression
		//TODO: change to use an anonymous class
		this.goButton.addActionListener(this);
		jfrm.add(this.goButton);
		
		this.display = new JTextArea(10, 30);
		jfrm.add(this.display);

		jfrm.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.goButton) {
			String name = this.inField.getText();

			this.display.append("Hello "+name+"\n");
		}

	}

	public static void main(String[] args) {

		// Starting the GUI application
		// TODO: example of an anonymous class, look up Runnable
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GreeterGUI("Greetings");
			}
		});

	}

}

