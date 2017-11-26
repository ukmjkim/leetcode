import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class DateFormatExample {
  public static void main(String[] args) {
    Date d = new Date(0L);
    String ds = "December 15, 2004";

    DateFormat df = new SimpleDateFormat("MMMMM dd, yyyy");

    try {
      d = df.parse(ds);
    } catch (ParseException e) {};

    System.out.println(d);
  }
}
