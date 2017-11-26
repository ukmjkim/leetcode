import java.io.*;

class A {
  public A() {
    System.out.println("A");
  }
}

public class Question04 {
  public static void main(String... args) throws Exception {
    A a = new A();

    ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("datafile"));
    save.writeObject(a);
    save.flush();
/*
    ObjectInputStream restore = new ObjectInputStream(new FileInputStream("datafile"));
    A z = (A) restore.readObject();
*/
  }
}

/*

Mijungs-MBP-2:test2 MijungKimMacPro$ java Question04
A
Exception in thread "main" java.io.NotSerializableException: A
  at java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1184)
  at java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:348)
  at Question04.main(Question04.java:14)

*/

