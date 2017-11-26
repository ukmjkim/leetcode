interface A {
  public void printValue();
}

public class Question13 {
  public static void main(String[] args) {
    A a1 = new A() {
      public void printValue() {
        System.out.println("A");
      }
    };

    a1.printValue();
  }
}
