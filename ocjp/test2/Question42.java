import java.io.*;

class Root {
  public Root() {
    System.out.println("Root");
  }
}

class A extends Root {
  public A() {
    System.out.println("A");
  }
}

class B extends A implements Serializable {
  public B() {
    System.out.println("B");
  }
}

public class Question42 {
  public static void main(String... args) throws Exception {
    B b = new B();
    ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("datafile"));
    save.writeObject(b);
    save.flush();

    ObjectInputStream restore = new ObjectInputStream(new FileInputStream("datafile"));
    B z = (B) restore.readObject();
  }
}

/*

A
B
A

*/

