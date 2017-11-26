import java.util.regex.*;

public class Question11 {
  public static void main(String[] args) {
    // x+     one or more times
    // x?     zero or once
    // x*     zero or more times
    Pattern p = Pattern.compile("a+b?c*");
    Matcher m = p.matcher("ab");
    boolean b = m.matches();
    System.out.println(b);
  }
}

/*
true
*/
