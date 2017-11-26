import java.io.*;

class A {}

class B implements Serializable {
  private static A a = new A();
}

public class Question12 {
  public static void main(String... args) {
    B b = new B();
    try {
      FileOutputStream fs = new FileOutputStream("b.ser");
      ObjectOutputStream os = new ObjectOutputStream(fs);
      os.writeObject(b);
      os.close();

      ObjectInputStream restore = new ObjectInputStream(new FileInputStream("b.ser"));
      B bb = (B) restore.readObject();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

