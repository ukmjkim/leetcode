public class Question06 {
  int i = 8;
  int j = 9;

  public static void main(String[] args) {
    add();
  }

  public static void add() {
    int k = i + j;
    System.out.println(k);
  }
}

/*

Mijungs-MBP-2:test2 MijungKimMacPro$ javac Question06.java
Question06.java:10: error: non-static variable i cannot be referenced from a static context
    int k = i + j;
            ^
Question06.java:10: error: non-static variable j cannot be referenced from a static context
    int k = i + j;
                ^
2 errors

*/

