class A implements Runnable {
  public void run() {
    System.out.println("run-A");
  }
}

public class Question09 {
  public static void main(String argv[]) {
    A a = new A();
    Thread t = new Thread(a);
    System.out.println(t.isAlive());
    t.start();
    System.out.println(t.isAlive());
  }
}

/*

false
true
run-A

*/

