package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WordSearch {

	private int difficulty;
	private String[] words;
	private ArrayList<String> lines = new ArrayList<String>();
	private char[][] puzzle = new char[20][20];
	
	public WordSearch(int difficulty) {
		this.difficulty = difficulty;
		this.words = new String[difficulty + 4];
		int lengthLowerBound = 4;
		int lengthUpperBound = 8;
		// Read in the file into a list of strings
		readFile();
		for (int i = 0; i < words.length; i++) {
			String word = selectWord(lengthLowerBound, lengthUpperBound);
			words[i] = word;
		}
		createPuzzle();
		
	}
	
	public String[] getWords() {
		return this.words;
	}
	
	public char[][] getPuzzle() {
		return this.puzzle;
	}
	
	private void readFile() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("word_list.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line = null;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while( line != null ) {
		    lines.add(line);
		    try {
				line = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private String selectWord(int low, int high) {
		// Choose a random one from the list
		Random r = new Random();
		boolean wordFound = false;
		String randomString = null;
		while (!wordFound) {
			randomString = lines.get(r.nextInt(lines.size()));
			if (randomString.length() > low && randomString.length() < high) {
				wordFound = true;
			}
		}
		return randomString;
	}
	
	private void createPuzzle() {
		Random r = new Random();
		String orientation = null;
		for (int i = 0; i < words.length; i++) {
			int rand = r.nextInt(4);
			switch (rand) {
			case 0:
				orientation = "horiz";
				break;
			case 1:
				orientation = "vert";
				break;
			case 2:
				orientation = "diagUp";
				break;
			case 3:
				orientation = "diagDown";
				break;
			}
			placeWord(words[i], orientation);
		}
		fillPuzzle();
	}
	
	private void placeWord(String word, String orientation) {
		Random r = new Random();
		int row, col;
		switch (orientation) {
			case "horiz":
				row = r.nextInt(puzzle.length);
				col = r.nextInt(puzzle.length - word.length());
				if (checkPlacement(row, col, orientation, word)) {
					for (int i = 0; i < word.length(); i++) {
						puzzle[row][col + i] = word.charAt(i);
					}
				}
				else {
					placeWord(word, orientation);
				}
				break;
			case "vert":
				row = r.nextInt(puzzle.length - word.length());
				col = r.nextInt(puzzle.length);
				if (checkPlacement(row, col, orientation, word)) {
					for (int i = 0; i < word.length(); i++) {
						puzzle[row + i][col] = word.charAt(i);
					}
				}
				else {
					placeWord(word, orientation);
				}
				break;
			case "diagUp":
				row = r.nextInt(puzzle.length - word.length());
				col = r.nextInt(puzzle.length - word.length());
				if (checkPlacement(row, col, orientation, word)) {
					for (int i = 0; i < word.length(); i++) {
						puzzle[row + i][col + i] = word.charAt(i);
					}
				}
				else {
					placeWord(word, orientation);
				}
				break;
			case "diagDown":
				row = r.nextInt(puzzle.length - word.length());
				col = r.nextInt(puzzle.length - word.length());
				if (checkPlacement(row, col, orientation, word)) {
					for (int i = 0; i < word.length(); i++) {
						puzzle[row - i][col + i] = word.charAt(i);
					}					
				}
				else {
					placeWord(word, orientation);
				}
				break;
			default:
				System.err.println("Error: Unsupported Format");
				//placeWord(word, orientation);
		}
					
	}
	
	private void fillPuzzle() {
		Random r = new Random();
		int rand;
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[i].length; j++) {
				if (puzzle[i][j] == 0) {
					rand = r.nextInt(25);
					switch (rand) {
					case 0:
						puzzle[i][j] = 'a';
						break;
					case 1:
						puzzle[i][j] = 'b';
						break;
					case 2:
						puzzle[i][j] = 'c';
						break;
					case 3:
						puzzle[i][j] = 'd';
						break;
					case 4:
						puzzle[i][j] = 'e';
						break;
					case 5:
						puzzle[i][j] = 'f';
						break;
					case 6:
						puzzle[i][j] = 'g';
						break;
					case 7:
						puzzle[i][j] = 'h';
						break;
					case 8:
						puzzle[i][j] = 'i';
						break;
					case 9:
						puzzle[i][j] = 'j';
						break;
					case 10:
						puzzle[i][j] = 'k';
						break;
					case 11:
						puzzle[i][j] = 'l';
						break;
					case 12:
						puzzle[i][j] = 'm';
						break;
					case 13:
						puzzle[i][j] = 'n';
						break;
					case 14:
						puzzle[i][j] = 'o';
						break;
					case 15:
						puzzle[i][j] = 'p';
						break;
					case 16:
						puzzle[i][j] = 'q';
						break;
					case 17:
						puzzle[i][j] = 'r';
						break;
					case 18:
						puzzle[i][j] = 's';
						break;
					case 19:
						puzzle[i][j] = 't';
						break;
					case 20:
						puzzle[i][j] = 'u';
						break;
					case 21:
						puzzle[i][j] = 'v';
						break;
					case 22:
						puzzle[i][j] = 'w';
						break;
					case 23:
						puzzle[i][j] = 'x';
						break;
					case 24:
						puzzle[i][j] = 'y';
						break;
					case 25:
						puzzle[i][j] = 'z';
						break;
					}
				}
			}
		}
	}
	
	//TODO: Test placement of shared characters between words
	private boolean checkPlacement(int row, int col, String orientation, String word) {
		switch (orientation) {
			case "horiz":
				if (col + word.length() < puzzle.length) {
					for (int i = 0; i < word.length(); i++) {
						if (puzzle[row][col + i] != '\0') {
							if (puzzle[row][col + i] != word.charAt(i)) {
								return false;
							}
						}
					}
					return true;
				}
				else {
					return false;
				}
			case "vert":
				if (row + word.length() < puzzle.length) {
					for (int i = 0; i < word.length(); i++) {
						if (puzzle[row + i][col] != '\0') {
							if (puzzle[row + i][col] != word.charAt(i)) {
								return false;
							}
						}
					}
					return true;
				}
				else {
					return false;
				}
			case "diagUp":
				if (row + word.length() < puzzle.length && col + word.length() < puzzle.length) {
					for (int i = 0; i < word.length(); i++) {
						if (puzzle[row + i][col + i] != '\0') {
							if (puzzle[row + i][col + i] != word.charAt(i)) {
								return false;
							}
						}
					}
					return true;
				}
				else {
					return false;
				}
			case "diagDown":
				if (col + word.length() < puzzle.length && row - word.length() >= 0) {
					for (int i = 0; i < word.length(); i++) {
						if (puzzle[row - i][col + i] != '\0') {
							if (puzzle[row - i][col + i] != word.charAt(i)) {
								return false;
							}
						}
					}
					return true;
				}
				else {
					return false;
				}
			default:
				System.err.println("Unsupported Format");
				return false;
		}	
	}
	public int getDifficulty() {
		return this.difficulty;
	}
}
