package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//TODO: Time the amount of time it takes to complete a puzzle and display it in the GUI. 
//TODO: Keep track of high score for each level of word search?
public class WordSearchGUI {
	
	private static ArrayList<JButton> selectedChars = new ArrayList<JButton>();	
	private static WordSearch w = new WordSearch(5);
	private static boolean[] foundWords = new boolean[w.getWords().length];
	//private static JPanel wordSection = new JPanel(new FlowLayout());
  private static WordPanel wordSection;
  private static JFrame frame;

  public static void main(String[] args) throws FileNotFoundException, ParseException {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    for (int i = 0; i < foundWords.length; i++) {
    	foundWords[i] = false;
    }
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {               	
          displayWordSearch(w);
        }
      });
    }
    
	public static void displayWordSearch(WordSearch w) {
    //Create and set up the window.
    frame = new JFrame("Word Search");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    //Draw Puzzle  
    JPanel panel = new JPanel(new GridLayout(20, 20));        
    char[][] puzzle = w.getPuzzle();
    JButton button;
    for (int i = 0; i < puzzle.length; i++) {
      for (int j = 0; j < puzzle[i].length; j++) {
        button = new JButton(Character.toString(puzzle[i][j]));
        button.setBackground(Color.WHITE);
        button.setBorderPainted(false);
        button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent ae) {						
						JButton b = (JButton) ae.getSource();
						if (b.getBackground() == Color.WHITE) {
							b.setBackground(Color.YELLOW);
							selectedChars.add(b);
							if (checkForWords()) {
								for (int i = 0; i < selectedChars.size(); i++) {
									selectedChars.get(i).setBackground(Color.GREEN);									
								}
								selectedChars.clear();
								redrawWordLabel();
                frame.validate();
								if (checkGameStatus()) {
									final JButton b1 = new JButton("Play Again");
									b1.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent arg0) {
											// TODO: Create new wordsearch
											frame.dispose();
											displayWordSearch(new WordSearch(w.getDifficulty() + 1));											
										}
										
									});
									JButton b2 = new JButton("Quit");
									b2.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(ActionEvent e) {
											// TODO: Exit game
											System.exit(0);
										}
										
									});
									Object[] buttons = {b1, b2};
									int n = JOptionPane.showOptionDialog(frame, "Congratulations, you finished the puzzle!",
											"Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, null);
								}
							}
						} else if (b.getBackground() == Color.YELLOW) {
							b.setBackground(Color.WHITE);
							selectedChars.remove(b);
						}		
					}	
        		});
        		panel.add(button);
        	}
        } 
        frame.add(panel, BorderLayout.CENTER);
        wordSection = new WordPanel(w.getWords());
        frame.add(wordSection, BorderLayout.PAGE_END);
        frame.pack();
        frame.setVisible(true);
	}
	
	private static boolean checkForWords() {
		String[] words = w.getWords();
		String selectedWord = "";
		for (int i = 0; i < selectedChars.size(); i++) {
			selectedWord += selectedChars.get(i).getText();
		}
		//selectedWord.toLowerCase();
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(selectedWord)) {
				foundWords[i] = true;
        wordSection.markAsFound(i);
				return true;
			}
		}
		return false;		
	}
	
	private static void redrawWordLabel() {/*
		String[] words = w.getWords();
    JLabel wordLabel = new JLabel();
    String word;
		for (int i = 0; i < words.length; i++) {
      word = "<html>";
			if (foundWords[i] == true) {
				word += "<strike>";
				word += words[i];
				word += "</strike>";
        wordLabel.setText(word);
			} else {
				word += words[i];
        wordLabel.setText(word);
			  }
      word += "</html>";
      wordSection.add(wordLabel); 
	  }
    frame.repaint(); */
    wordSection.update();
  }
	
	private static boolean checkGameStatus() {
		int count = 0;
		for (int i = 0; i < foundWords.length; i++) {
			if (foundWords[i] == true) {
				count ++;
			}
		}
		if (count == foundWords.length) {
			return true;
		}
		return false;
	}
}
