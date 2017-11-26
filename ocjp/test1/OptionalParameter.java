public class OptionalParameter {
  public static void main(String[] args) {
    new OptionalParameter().go(1, "hi");
    new OptionalParameter().go(2, "hi", "world");
  }

  /* Compilation fails */
  /*
  public void go(String... y, int x) {
    System.out.println(y[y.length-1] + " ");
  }
  */

  public void go(int x, String... y) {
    System.out.println(y[y.length-1] + " ");
  }
}

