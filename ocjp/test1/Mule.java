public class Mule {
  public static void main(String[] args) {
    boolean assert = true;
    if (assert) {
      System.out.println("assert is true");
    }
  }
}

/*
Answer:

Mijungs-MBP-2:ocjp MijungKimMacPro$ javac Mule.java
Mule.java:3: error: as of release 1.4, 'assert' is a keyword, and may not be used as an identifier
    boolean assert = true;
            ^
  (use -source 1.3 or lower to use 'assert' as an identifier)
Mule.java:4: error: as of release 1.4, 'assert' is a keyword, and may not be used as an identifier
    if (assert) {
        ^
  (use -source 1.3 or lower to use 'assert' as an identifier)
2 errors

*/
