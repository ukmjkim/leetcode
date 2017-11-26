class Mango {
  final int a=5;
}

class Fruit extends Mango {
  final int a = 10;
}

class DynamicDispatch extends Fruit {
  final int a = 20;
}

public class Question01 {
  public static void main(String[] args) {
    Mango m = new DynamicDispatch();
    Fruit f = new DynamicDispatch();

    // 101 | 1010 => 1111
    System.out.print(m.a | f.a);
  }
}

/* Answer: 15 */
