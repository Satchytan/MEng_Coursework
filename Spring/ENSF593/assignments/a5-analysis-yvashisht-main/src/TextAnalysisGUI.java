import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Yajur Vashisht
 * 
 * TextAnalysisGUI uses ActionListener to get the user input and has two buttons (Analysis and Clear) which 
 * provide the number of words or clear all the fields.
 *
 */
public class TextAnalysisGUI implements ActionListener {
	
	private JTextArea inputTextArea; 
	private JTextArea outputTextArea;
	private JButton resetButton, analysisButton;
	private TextAnalyzer TextAnalyzer;
	
	public TextAnalysisGUI(String title) {
		
		TextAnalyzer = new TextAnalyzer("");
		
		//creating GUI outline
		JFrame jfrm = new JFrame(title);
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(800, 600);  
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//initial input section
        JPanel inputPanel = new JPanel(new BorderLayout());		
		JLabel inputLabel = new JLabel("Enter or copy text.");
		inputPanel.add(inputLabel, BorderLayout.NORTH);
		inputTextArea = new JTextArea(25, 60);
		JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
	    inputPanel.add(inputScrollPane, BorderLayout.CENTER);
	    jfrm.add(inputPanel, BorderLayout.CENTER);
		this.inputTextArea.setText("");
		jfrm.add(inputPanel, BorderLayout.CENTER);
		
		//buttons for both analysis and clear
		JPanel buttonPanel = new JPanel();
		analysisButton = new JButton("Analysis");
		analysisButton.addActionListener(this);
		buttonPanel.add(analysisButton);
		jfrm.add(analysisButton, BorderLayout.SOUTH);
		resetButton = new JButton("Clear");
		resetButton.addActionListener(this);
		buttonPanel.add(resetButton);
		jfrm.add(resetButton, BorderLayout.SOUTH);

		//output area 
		this.outputTextArea = new JTextArea (5 ,20);
		jfrm.add(outputTextArea, BorderLayout.CENTER);
		
		jfrm.setVisible(true);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == analysisButton) { //getting stats if analysis is pressed
			String inputText = inputTextArea.getText();
			TextAnalyzer = new TextAnalyzer(inputText);
			outputTextArea.setText(TextAnalyzer.toString());
		} else if (e.getSource() == resetButton) { //clearing if reset button is pressed
			TextAnalyzer = new TextAnalyzer("");
            inputTextArea.setText("");
            outputTextArea.setText("");
		}
	}

	//starting the GUI application
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TextAnalysisGUI("Text Statistics");
			}
		});
	}
}
