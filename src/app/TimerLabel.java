public class TimerLabel {
  private long startTime;
  public TimerLabel() {
    this.startTime = System.currentTimeMillis();
    super("Elapsed time: " + elapsedTime());
    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        this.setText("Elapsed time: " + elapsedTime());
      }
    };
    Timer t = new Timer(1000, actionListener);
    t.start();
  }

  private String elapsedTime() {
    long elapsedTime = System.currentTimeMillis() - this.startTime;
    long elapsedSeconds = elapsedTime / 1000;
    int elapsedHours = elapsedSeconds / 3600;
    int elapsedMinutes = elapsedSeconds / 60;
    int formattedSeconds = elapsedSeconds % 60;
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
