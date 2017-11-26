abstract class A {
  abstract void a1();
  void a2() {}
}

class B extends A {
  void a1() {}
  void a2() {}
}

class C extends B {
  void c1() {}
}

public class PolymorphicMethodCall {
  public static void main(String[] args) {
    A x = new B();
    C y = new C();
    A z = new C();
  }
}

/*
Question: What are four valid of polymorphic method calls? (Choose four)

A. x.a2();
B. z.a2();
C. z.c1();  ==> not a polymorphic call
D. z.a1();
E. y.c1();  ==> not a polymorphic call
F. x.a1();
*/

