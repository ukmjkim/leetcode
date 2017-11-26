class SuperClass {
  public int doIt(String str, Integer... data) throws Exception {
    String signature = "(String, Integer[])";
    System.out.println(str + " " + signature);
    return 1;
  }
}

class SubClass extends SuperClass {
  public int doIt(String str, Integer... data) {
    String signature = "(String, Integer[])";
    System.out.println("Overridden: " + str + " " + signature);
    return 0;
  }
}

public class Question19 {
  public static void main(String... args) {
    SuperClass sb = new SubClass();
    sb.doIt("hello", 3);
  }
}


/*

Question19.java:20: error: unreported exception Exception; must be caught or declared to be thrown
    sb.doIt("hello", 3);
           ^
1 error



Additional Info:

SuperClass method has throws Exception but SubClass method doesn't have it, then override error

Question19.java:10: error: doIt(String,Integer...) in SubClass cannot override doIt(String,Integer...) in SuperClass
  public int doIt(String str, Integer... data) throws Exception {
             ^
  overridden method does not throw Exception
1 error

*/
