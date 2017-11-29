class Mango {
  final int a = 5;
  public String printName() {
    return "Mango";
  }
}

class Fruit extends Mango {
  final int a = 10;
  public String printName() {
    return "Fruit";
  }
}

class DynamicDispatch extends Fruit {
  final int a = 20;
  public String printName() {
    return "DynamicDispatch";
  }
}

public class Question04 {
  public static void main(String[] args) {
    Mango m = new DynamicDispatch();
    Fruit f = new DynamicDispatch();

    System.out.println("m.printName: " + m.printName() + ", m.a: " + m.a
          + ", (DynamicDispatch) m.a: " + ((DynamicDispatch)m).a);
    System.out.println("f.printName: " + f.printName() + ", f.a: " + f.a
          + ", (DynamicDispatch) f.a: " + ((DynamicDispatch)f).a);
  }
}

/*

Casting doesn't change its object type. m, f are the objects of DynamicDispatch

m.printName: DynamicDispatch, m.a: 5
f.printName: DynamicDispatch, f.a: 10

*/

