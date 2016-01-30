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
  public WordPanel(String[] words) {
    super(new GridLayout(0, 3, 3, 3));
    this.words = words;
    String word;
    JLabel wordLabel;
    for (int i = 0; i < words.length; i++) {
      wordLabel = new JLabel();
      //word = "<html>";
      word = words[i];
      //word += "</html>";
      wordLabel.setText(word);
      add(wordLabel);
    }    
  }
}
