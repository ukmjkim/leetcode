public class Question39 {
  public static void main(String[] args) {
    double strictfp=5.02;
    strictfp += .333;
    System.out.print(strictfp);
  }
}

/*

strictfp is keyword to be used to force the precision of floating point calculations in Java.
without that, floating point precision will be different depending on OS.

strictfp class X {}
strictfp interface X {}
strictfp double X(a, b) {}
BUT NOT strictfp variable.


Mijungs-MacBook-Pro-2:test2 MijungKimMacPro$ javac Question39.java
Question39.java:3: error: not a statement
      double strictfp=5.02;
      ^
Question39.java:3: error: ';' expected
      double strictfp=5.02;
            ^
Question39.java:3: error: class, interface, or enum expected
      double strictfp=5.02;
                     ^
Question39.java:4: error: class, interface, or enum expected
    strictfp += .333;
             ^
Question39.java:5: error: illegal start of expression
        System.out.print(strictfp);
                         ^
Question39.java:5: error: ';' expected
        System.out.print(strictfp);
                                 ^
6 errors

*/
