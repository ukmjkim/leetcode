import java.io.IOException;

class A {
  public void process() {
    System.out.print("A,");
  }
}

class B extends A {
  public void process() throws IOException {
    super.process();
    System.out.print("B,");
    throw new IOException();
  }

  public static void main(String[] args) {
    try {
      new B().process();
    } catch (IOException e) {
      System.out.println("Exception");
    }
  }
}

/*
Answer:
Compilation Error

Mijungs-MBP-2:ocjp MijungKimMacPro$ javac ExceptionQuestion2.java
ExceptionQuestion2.java:10: error: process() in B cannot override process() in A
  public void process() throws IOException {
              ^
  overridden method does not throw IOException
1 error
Mijungs-MBP-2:ocjp MijungKimMacPro$
*/

