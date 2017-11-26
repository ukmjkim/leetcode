class A implements Runnable {
  public void run() {
    try {
      for (int i=0;i < 4;i++) {
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName());
      }
    } catch (InterruptedException e) {
    }
  }
}


public class Question33 {
  public static void main(String argv[]) throws Exception{
    A a = new A(); 
    Thread t = new Thread(a,"A");
    Thread t1 = new Thread(a,"B");
    t.start();
    t.join();
    t1.start();
  }
}

/*

A
A
A
A
B
B
B
B

explanation:  method can be used to pause the current thread execution until unless the specified thread is dead. There are three overloaded join functions
*/
