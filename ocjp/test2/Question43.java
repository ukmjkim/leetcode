class Mango {
  final int a=5;
}
class Fruit extends Mango {
  final int a=10;
}

class DynamicDispatch extends Fruit {
  final int a=15;
}

public class Question43 {
  public static void main(String[] args) {
    DynamicDispatch t = new Mango();
    System.out.println(t.a);
  }
}

/*

Mijungs-MacBook-Pro-2:test2 MijungKimMacPro$ javac Question43.java
Question43.java:14: error: incompatible types: Mango cannot be converted to DynamicDispatch
    DynamicDispatch t = new Mango();
                        ^
1 error

*/

