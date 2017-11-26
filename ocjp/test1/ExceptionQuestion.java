class A {
  void foo() throws Exception {
    throw new Exception();
  }
}

class SubB2 extends A {
  void foo() {
    System.out.println("B ");
  }
}

public class ExceptionQuestion {
  public static void main(String[] args) {
    A a = new SubB2();
    a.foo();
  }
}

/*
Answer:

Mijungs-MBP-2:ocjp MijungKimMacPro$ javac ExceptionQuestion.java
ExceptionQuestion.java:16: error: unreported exception Exception; must be caught or declared to be thrown
    a.foo();
         ^
1 error
*/

