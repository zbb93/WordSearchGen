package test;

import java.util.Random;

public class NullCheckTest {
	private char[][] puzzle = new char[20][20];
	
	public static void main(String[] args) {
		//Add some words to puzzle
		
		//Check placement on taken spaces
		//Check placement on untaken spaces
	}
	
	private void placeWord(String word, String orientation) {
		Random r = new Random();
		int row, col;
		switch (orientation) {
			case "horiz":
				row = r.nextInt(puzzle.length);
				col = r.nextInt(puzzle.length - word.length());
				if (checkPlacement(row, col, "horiz", word)) {
					for (int i = 0; i < word.length(); i++) {
						puzzle[row][col + i] = Character.toUpperCase(word.charAt(i));
					}
					break;
				}
			case "vert":
				row = r.nextInt(puzzle.length - word.length());
				col = r.nextInt(puzzle.length);
				if (checkPlacement(row, col, "vert", word))
				for (int i = 0; i < word.length(); i++) {
					puzzle[row + i][col] = Character.toUpperCase(word.charAt(i));
				}
				break;
			case "diagUp":
				row = r.nextInt(puzzle.length - word.length());
				col = r.nextInt(puzzle.length - word.length());
				for (int i = 0; i < word.length(); i++) {
					puzzle[row - i][col + i] = Character.toUpperCase(word.charAt(i));
				}
				break;
			case "diagDown":
				row = r.nextInt(puzzle.length - word.length());
				col = r.nextInt(puzzle.length - word.length());
				for (int i = 0; i < word.length(); i++) {
					puzzle[row + i][col + i] = Character.toUpperCase(word.charAt(i));
				}
				break;
			default:
				System.err.println("Error: Unsupported Format");
		}
					
	}
	
	private boolean checkPlacement(int row, int col, String orientation, String word) {
		switch (orientation) {
			case "horiz":
				for (int i = 0; i < word.length(); i++) {
					if (puzzle[row][col + i] != '\0') {
						return false;
					}
				}
				return true;
			case "vert":
				for (int i = 0; i < word.length(); i++) {
					if (puzzle[row + i][col] != '\0') {
						return false;
					}
				}
				return true;
			case "diagUp":
				for (int i = 0; i < word.length(); i++) {
					if (puzzle[row + i][col + i] != '\0') {
						return false;
					}
				}
				return true;
			case "diagDown":
				for (int i = 0; i < word.length(); i++) {
					if (puzzle[row + i][col - i] != '\0') {
						return false;
					}
				}
				return true;
			default:
				System.err.println("Unsupported Format");
				return false;
		}	
	}
}
