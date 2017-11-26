public class TryCatch {
  public static void parse(String str) {
    try {
      float f = Float.parseFloat(str);
    } catch (NumberFormatException nfe) {
      f = 0;
    } finally {
      System.out.println(f);
    }
  }

  public static void main(String[] args) {
    parse("invalid");
  }
}

/*
Answer:
Mijungs-MBP-2:ocjp MijungKimMacPro$ javac TryCatch.java
TryCatch.java:6: error: cannot find symbol
      f = 0;
      ^
  symbol:   variable f
  location: class TryCatch
TryCatch.java:8: error: cannot find symbol
      System.out.println(f);
                         ^
  symbol:   variable f
  location: class TryCatch
2 errors
*/

