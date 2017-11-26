interface TestA { String toString(); }

public class Anonymous {
  public static void main(String[] args) {
    System.out.println(new TestA() {
      public String toString() { return "test"; }
    });
  }
}

/*
Answer: test
*/

