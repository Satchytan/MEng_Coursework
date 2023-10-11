
/**
 * @author Satchytan Karalasingham
 *
 */
/**
 * A class that analyzes the text and calculates the number of sentences and words.
 */
public class TextAnalyzer {
    private int numOfSentences;
    private int numOfWords;

    /**
     * Constructs a TextAnalyzer object with the given text and calculates the statistics.
     *
     * @param text the input text to analyze
     */
    public TextAnalyzer(String text) {
        calculateStatistics(text);
    }

    /**
     * Calculates the number of sentences and words in the given text.
     *
     * @param text the input text to analyze
     */
    private void calculateStatistics(String text) {
        // Split the text into sentences based on delimiters: '.', '!', '?'
        String[] sentences = text.split("[.!?]");

        numOfSentences = 0;
        numOfWords = 0;
        
        String[] words = text.trim().split("\\s+");
        numOfWords = words.length;

        for (String sentence : sentences) {
            // Ignore empty sentences
            if (!sentence.trim().isEmpty()) {
                numOfSentences++;

            }
        }
    }

    /**
     * Returns the number of sentences.
     *
     * @return the number of sentences
     */
    public int getNumOfSentences() {
        return numOfSentences;
    }

    /**
     * Returns the number of words.
     *
     * @return the number of words
     */
    public int getNumOfWords() {
        return numOfWords;
    }

    /**
     * Returns a string representation of the TextAnalyzer object.
     *
     * @return a string containing the number of sentences and words
     */
    @Override
    public String toString() {
        return "Number of sentences: " + numOfSentences + "\nNumber of words: " + numOfWords;
    }
}
