public class Question07 {
  public static void main(String[] args) {
    byte b=127;
    System.out.println(b*2);
  }
}

/*
Mijungs-MBP-2:test2 MijungKimMacPro$ javac Question07.java
Question07.java:3: error: incompatible types: possible lossy conversion from int to byte
    byte b=129;
           ^
1 error
*/

