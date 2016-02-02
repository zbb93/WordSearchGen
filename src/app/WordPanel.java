package app;
/**
 * @author zbb
 * 01/29/15
 * Simple class that provides pretty alignment for the words hidden in the wordsearch.
 */
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class WordPanel extends JPanel {
  private String[] words;
  private boolean[] foundWords;
  public WordPanel(String[] words) {
    super(new GridLayout(0, 3, 3, 3));
    this.words = words;
    this.foundWords = new boolean[words.length];
    for (int i = 0; i < foundWords.length; i++) {
      foundWords[i] = false;
    }
    String word;
    JLabel wordLabel;
    for (int i = 0; i < words.length; i++) {
      wordLabel = new JLabel();
      word = "<html>";
      word += words[i];
      word += "</html>";
      wordLabel.setText(word);
      add(wordLabel);
    }    
  }

  public void repaint() {
    removeAll();
    JLabel wordLabel;
    String word;
    for (int i = 0; i < foundWords.length; i++) {
      wordLabel = new JLabel();
      if (foundWords[i] == true) {
        word = "<html><strike>";
        word += this.words[i];
        word += "</strike></html>";
        wordLabel.setText(word);
        add(wordLabel);
      }
      else {
        word = "<html>";
        word += this.words[i];
        word += "</html>";
        wordLabel.setText(word);
        add(wordLabel);
      }
    }
  }

  public void markAsFound(int index) {
    this.foundWords[index] = true;
  }
}
