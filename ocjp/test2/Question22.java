class A {
  static {System.out.println("static");}
  {System.out.println("block");}

  public A() {
    System.out.println("A");
  }
}

public class Question22 {
  public static void main(String[] args) {
    A a = new A();
  }
}

/*

static
block
A

*/

