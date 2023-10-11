class Text{
	
	private String content;
	
	public Text(String t) {
		this.content = t;
	}
	
	public int getNumberOfSentences() {
		// TODO implement method. Sentences are separated by period, question or exclamation marks
		// regex: [.!?] defines a group
		String[] sentences = this.content.trim().split("[.!?]");

		if(sentences.length == 1 && sentences[0].equals("")) return 0;
		return sentences.length;
	}
	
	public int getNumberOfWords() {
		// TODO implement method. Words are separated by one or more whitespaces
		// regex: \\s any whitespace
		// regex: \\s+ one or more whitespace
		String[] words = this.content.trim().split("\\s+");
		
		if(words.length == 1 && words[0].equals("")) return 0;
		return words.length;
	}
	
}

public class TextAnalysis {

	public static void main(String[] args) {
		String content = """
A simple, but powerful, sentence. 

All right! 

Got it?
""";
		Text text = new Text(content);
		
		System.out.println(content);
		
		System.out.println("  Number of Words: "+text.getNumberOfWords());
		
		System.out.println("  Number of Sentences: "+text.getNumberOfSentences());

	}

}
