// Answer: Compilation of class C will fail because of an error in line 6
// Explanation: The return type is incompatible with B.execute()

public interface A {
  public void doSomething(String thing);
}

public class AImpl implements A {
  public void doSomething(String msg) {}
}

public class B {
  public A doit() {
    // more code here
  }

  public String execute() {
    // more code here
  }
}

public class C extends B {
  public AImpl doit() {
    // more code here
  }

  public Object execute() {
    // more code here
  }
}

