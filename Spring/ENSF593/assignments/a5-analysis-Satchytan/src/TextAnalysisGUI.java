
/**
 * @author Satchytan Karalasingham
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A graphical user interface (GUI) application for text analysis.
 * Allows the user to enter text and analyze the number of sentences and words.
 */
public class TextAnalysisGUI implements ActionListener {
    private JFrame frame;
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JButton analyzeButton;
    private JButton clearButton;

    /**
     * Constructs the TextAnalysisGUI and sets up the GUI elements.
     */
    public TextAnalysisGUI() {
        frame = new JFrame("Text Analysis");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputTextArea = new JTextArea(30, 50);
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);

        outputTextArea = new JTextArea(5, 15);
        outputTextArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputTextArea);

        analyzeButton = new JButton("Analyze");
        analyzeButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(analyzeButton);
        buttonPanel.add(clearButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputScrollPane, BorderLayout.WEST);
        mainPanel.add(outputScrollPane, BorderLayout.EAST);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Performs the actions when a button is clicked.
     *
     * @param e the ActionEvent representing the button click
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == analyzeButton) {
            String text = inputTextArea.getText();
            TextAnalyzer analyzer = new TextAnalyzer(text);
            outputTextArea.setText(analyzer.toString());
        } else if (e.getSource() == clearButton) {
            inputTextArea.setText("");
            outputTextArea.setText("");
        }
    }

    /**
     * The entry point of the application.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextAnalysisGUI::new);
    }
}
