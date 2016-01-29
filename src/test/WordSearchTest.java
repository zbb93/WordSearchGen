package test;

import app.WordSearch;

public class WordSearchTest {
	public static void main(String[] args) {
		
		WordSearch test = new WordSearch(1);
		String[] words = test.getWords();
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
		char[][] puzzle = test.getPuzzle();
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[i].length; j++) {
				System.out.print(puzzle[i][j]);
			}
			System.out.println();
		}
	}
}
