import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TimerLabel extends JLabel {
  private long startTime = System.currentTimeMillis();
  public TimerLabel() {
    super("Elapsed time: ");
    //super("Elapsed time: " + elapsedTime());
    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source instanceof TimerLabel) {
          TimerLabel tl = (TimerLabel) source;
          tl.setText("Elapsed time: " + elapsedTime());
        }
      }
    };
    Timer t = new Timer(1000, actionListener);
    t.start();
  }

  private String elapsedTime() {
    long elapsedTime = System.currentTimeMillis() - this.startTime;
    long elapsedSeconds = elapsedTime / 1000;
    int elapsedHours = (int) (elapsedSeconds / 3600);
    int elapsedMinutes = (int) (elapsedSeconds / 60);
    int formattedSeconds = (int) (elapsedSeconds % 60);
    StringBuilder sb = new StringBuilder();
    sb.append(elapsedHours);
    sb.append('h');
    sb.append(elapsedMinutes);
    sb.append('m');
    sb.append(elapsedSeconds);
    sb.append('s');
    String time = sb.toString();
    return time;
  }
}
