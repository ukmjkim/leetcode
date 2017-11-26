import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatExample {
  public static void main(String[] args) {
    double input = 314159.26;
    NumberFormat nf = NumberFormat.getInstance(Locale.ITALIAN);
    String b = nf.format(input);

    System.out.println(b);
  }
}

