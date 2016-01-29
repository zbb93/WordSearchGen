package test;

import java.util.Random;

public class WordIntersectionTests {

	public static void main(String[] args) {
		//Create a character array to represent word search.
		char[][] puzzle = new char[20][20];
		//Create a test word and insert into char array with vertical orientation.
		String test = "teststring";
		Random r = new Random();
		int row = r.nextInt(test.length());
		int col = r.nextInt(test.length());
		
		//Create test words and insert into char array such that it intersects with
		//the original word. Test horizontal, diagonal up, and diagonal down here.
		
		//Clear the character array.
		//Place test word into array with horizontal orientation.
		//Insert intersection test words with vertical, diagonal up, and diagonal down orientations.
		
		//Clear the character array.
		//Place the test word into array with diagonal up orientation.
		//Insert test words with vertical, horizontal, and diagonal down orientations.
		
		//Clear the character array.
		//Place test word into array with diagonal down orientation.
		//Insert test words with vertical, horizontal, and diagonal up orientations.
	}
}
