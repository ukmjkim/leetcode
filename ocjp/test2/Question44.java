public class Question44 {
  public static void main(String[] args) {
    boolean b=11>=11;
    String str=(String)b;
    System.out.println(str);
  }
}

/*

1. Boolean.toString(b)
2. String.valueOf(b)

Mijungs-MacBook-Pro-2:test2 MijungKimMacPro$ javac Question44.java
Question44.java:4: error: incompatible types: boolean cannot be converted to String
    String str=(String)b;
                       ^
1 error

*/

