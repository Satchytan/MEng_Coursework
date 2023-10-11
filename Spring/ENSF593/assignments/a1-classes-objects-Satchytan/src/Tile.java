
/**
 * @author Satchytan Karalasingham
 * 
 * Class Name: Tile
 * 
 * Represents a Scrabble tile with a letter and value assigned to it
 * and allow the user to get these assignments and check if two tiles are equal
 * 
 * 
 */

public class Tile {
	
	public char letter;
	public int value;
	
	//constructor that allows Tiles to be created with arguments passed from main().
	Tile (char l, int v) {
		this.letter = l;
		this.value = v;
	}
	
	//'default' constructor initializes variables to 'A' and 1 if none explicitly provided.
	Tile() {
		this.letter = 'A';
		this.value = 1;
			
	}
	
		public String toString() {
			String outputString = Character.toString(letter) + "[" + Integer.toString(value) + "]";
			return outputString;
		}
			
		public boolean equals(Tile other) {
			//return this.start == other.start;
			//boolean isEqual = False;
			if (this.letter == other.letter && this.value == other.value) {
				return true; }
			else {
				return false;
			}
			
			
			//System.out.println("Tile " + tileNum1 + " is equal to " + tileNum2 + " is " + isEqual);
				
				
		}
		
	
	
	

	public static void main(String[] args) {
		Tile tile0 = new Tile ('A', 1);
		Tile tile1 = new Tile ();
		Tile tile2 = new Tile ('Z', 10);
		System.out.println("Tile 0: " + tile0.toString());
		System.out.println("Tile 1: " + tile1.toString());
		System.out.println("Tile 2: " + tile2.toString());

		System.out.println("Tile 0 is equal to Tile 1 is " + tile0.equals(tile1));
		System.out.println("Tile 0 is equal to Tile 2 is " + tile1.equals(tile2));


	}

}
