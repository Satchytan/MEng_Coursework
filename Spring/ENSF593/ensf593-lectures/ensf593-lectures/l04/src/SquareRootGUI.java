import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Yves
 *
 */
public class SquareRootGUI implements ActionListener {

	private JTextArea display;
	private JTextField inField;
	private JButton goButton;

	public SquareRootGUI() {
		this("A title");
	}
	
	public SquareRootGUI(String title) {
		
		JFrame jfrm = new JFrame(title);
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(450, 250);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Enter number: ");
		jfrm.add(label);

		this.inField = new JTextField(10);
		jfrm.add(this.inField);

		this.goButton = new JButton("sqrt");
		this.goButton.addActionListener(this);
		jfrm.add(this.goButton);
		
		this.display = new JTextArea(10, 30);
		jfrm.add(this.display);

		jfrm.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		double number;
		// TODO implement button callback
		if (e.getSource() == this.goButton) {
			
			number = Double.valueOf(this.inField.getText());
			
			
			this.display.append("sqrt("+number+") = " +Math.sqrt(number)+"\n");
			
		}
		
//		number = 10;

	}

	public static void main(String[] args) {

		// Starting the GUI application
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SquareRootGUI();
			}
		});

	}

}
