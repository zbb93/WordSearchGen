package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverTest {

	public static void main(String[] args) {
		JFrame gameOver = new JFrame("Puzzle Creator");
		gameOver.setSize(375, 100);
		JPanel p = new JPanel();
		JLabel congrats = new JLabel("Congratulations! You have completed the puzzle!");
		p.add(congrats);
		//gameOver.add(congrats);
		JButton b1 = new JButton("Play Again");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO: Create new wordsearch
				
			}
			
		});
		p.add(b1);
		JButton b2 = new JButton("Quit");
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Exit game
				
			}
			
		});
		p.add(b2);
		gameOver.add(p);
		gameOver.setVisible(true);
		//gameOver.pack();
	}
}
