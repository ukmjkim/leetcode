class Super {
  private int a;
  protected Super(int a) { this.a = a; }
}

class Sub extends Super {
  public Sub(int a) { super(a); }
  public Sub() { this.a = 5; }
}

public class Constructor2 {
}

/*


public Sub() { this(5); }
public Sub() { super(5); }


Mijungs-MBP-2:ocjp MijungKimMacPro$ javac Constructor2.java
Constructor2.java:8: error: constructor Super in class Super cannot be applied to given types;
  public Sub() { this.a = 5; }
               ^
  required: int
  found: no arguments
  reason: actual and formal argument lists differ in length
Constructor2.java:8: error: a has private access in Super
  public Sub() { this.a = 5; }
                     ^
2 errors
*/
