class B {
  public synchronized void printName() {
    try {
      System.out.println("printName");
      Thread.sleep(5*1000);
    } catch (InterruptedException e) {
    }
  }

  public synchronized void printValue() {
    System.out.println("printValue");
  }
}

public class Question15 extends Thread {
  B b = new B();
  public static void main(String argv[]) throws Exception {
    Question15 t = new Question15();
    Thread t1 = new Thread(t, "t1");
    Thread t2 = new Thread(t, "t2");
    t1.start();
    t2.start();
  }

  public void run() {
    if (Thread.currentThread().getName().equals("t1")) {
      b.printName();
    } else {
      b.printValue();
    }
  }
}


/*
printName
printValue
*/

