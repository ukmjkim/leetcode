class A extends Thread {
  int count = 0;
  public void run() {
    System.out.println("run");
    synchronized(this) {
      for (int i = 0; i < 50; i++) {
        count = count + i;
      }
      notify();
    }
  }
}

public class Question07 {
  public static void main(String[] args) {
    A a = new A();
    a.start();
    synchronized(a) {
      System.out.println("waiting");
      try {
        a.wait();
      } catch (InterruptedException e) {
      }

      System.out.println(a.count);
    }
  }
}


/*
waiting
run
1225
*/

