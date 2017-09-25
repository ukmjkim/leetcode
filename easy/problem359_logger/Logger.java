import java.util.*;

public class Logger {
  Map<String, Integer> map;
  private static final int THRESHHOLD = 10;

  public Logger() {
    map = new HashMap<>();
  }
  
  public boolean shouldPrintMessage(int timestamp, String message) {
    if (map.containsKey(message)) {
      if (timestamp - map.get(message) >= THRESHHOLD) {
        map.put(message, timestamp);
        return true;
      } else {
        return false;
      }
    } else {
      map.put(message, timestamp);
      return true;
    }
  }

  public static void main(String[] args) {
    Logger logger = new Logger();
    System.out.println("should Print Message: " + logger.shouldPrintMessage(1, "foot"));
    System.out.println("should Print Message: " + logger.shouldPrintMessage(2, "bar"));
    System.out.println("should Print Message: " + logger.shouldPrintMessage(3, "foo"));
    System.out.println("should Print Message: " + logger.shouldPrintMessage(8, "bar"));
    System.out.println("should Print Message: " + logger.shouldPrintMessage(10, "foo"));
    System.out.println("should Print Message: " + logger.shouldPrintMessage(11, "foo"));
    System.out.println("should Print Message: " + logger.shouldPrintMessage(20, "bar"));
  }
}


