public class Question23 {
  public static void main(String[] args) {
    char a = 5;
    short b=-++a;
    System.out.println(b);
  }
}

/*

Mijungs-MBP-2:test2 MijungKimMacPro$ javac Question23.java
Question23.java:4: error: incompatible types: possible lossy conversion from int to short
    short b=-++a;
            ^
1 error

*/

