class A extends Thread {
  public void run() {
    for (int i=0; i < 2; i++) {
      System.out.println(i);
    }
  }
}

public class Question34 {
  public static void main(String args[]) {
    Question34 t = new Question34();
    t.check(new A(){});
  }

  public void check(A a) {
    a.start();
  }
}

