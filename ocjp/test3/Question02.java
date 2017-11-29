class A {
  public void printValue() {
    System.out.println("A");
  }
}

class B extends A {
  public void printValue() {
    System.out.println("B");
  }
}

public class Question02 {
  public static void main(String[] args) {
    A b = new B();
    newValue(b);
  }

  public static void newValue(A a) {
    if (a instanceof B) {
      ((B)a).printValue();
    }
    if (a instanceof A) {
      ((A)a).printValue();
    }
  }
}

/*

B
B

*/

