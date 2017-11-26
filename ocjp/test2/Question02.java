public class Question02 {
  int $7;
  int £1;
  public static void main(String argv[]) {
    int k;

    Question02 question = new Question02();
    question.$7 = 7;
    System.out.println(question.$7);
    System.out.println(k);
  }
}

/*
--------------------------------------------------------------
[Answer]

Mijungs-MBP-2:test2 MijungKimMacPro$ javac Question02.java
Question02.java:9: error: variable k might not have been initialized
    System.out.println(k);
                       ^
1 error
--------------------------------------------------------------
*/
