public class Question30 extends Thread {
  public static void main(String...args) {
    Question30 t = new Question30();
    t.run();
    t.start();
  }

  public void run() {
    System.out.println("run-test");
  }
}


/*

Mijungs-MBP-2:test2 MijungKimMacPro$ java Question30
run-test
run-test

*/

