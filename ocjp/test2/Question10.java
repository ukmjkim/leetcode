class A implements Runnable {
  public void run() {
    System.out.println("run-a");
  }
}

public class Question10 {
  public static void main(String... args) {
    A a = new A();
    Thread t = new Thread(a);
    t.start();
    t.start();
  }
}

/*

run-aException in thread "main"
java.lang.IllegalThreadStateException
  at java.lang.Thread.start(Thread.java:708)
  at Question10.main(Question10.java:12)

*/

