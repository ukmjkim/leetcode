class D {
  int i;
  int j;
  public D(int i,int j) {
    this.i=i;
    this.j=j;
  }
  public void printName() {
    System.out.println("Name-D");
  }
}

public class Question41 {
  public static void main (String[] args){
    D d = new D();
    d.printName();
  }
}

/*

Mijungs-MacBook-Pro-2:test2 MijungKimMacPro$ javac Question41.java
Question41.java:15: error: constructor D in class D cannot be applied to given types;
    D d = new D();
          ^
  required: int,int
  found: no arguments
  reason: actual and formal argument lists differ in length
1 error

*/

