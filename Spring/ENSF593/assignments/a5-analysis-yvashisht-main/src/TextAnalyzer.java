/**
 * @author Yajur Vashisht
 * TextAnalyzer uses numOfSentences and numOfWords to calculate the number of words and sentences in the
 * input using .split and .length. The output is then displayed in the GUI it interacts with.
 *
 */
public class TextAnalyzer {
	
	private int numOfSentences; 
	private int numOfWords;
	
	public TextAnalyzer(String text) {
		calcStats(text);
	}
	
	public void calcStats(String text) {
		
		String[] sentences = text.split("[.!?]"); //calculate the number of sentences using characters in between
		numOfSentences = sentences.length;
		
		String[] words = text.split("\\s+"); //calculate the number of words using space between
		numOfWords = words.length;
	}
	
	public int numOfSentences() {
		return numOfSentences;
	}
	
	public int numOfWords() {
		return numOfWords;
	}
	
	@Override
	public String toString() { //print the number of words and strings
		return "The number of sentences are: " + numOfSentences + "\nThe number of words are: " + numOfWords;
	}

}
