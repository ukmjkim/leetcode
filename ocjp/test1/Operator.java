class Target {
  private int i = 0;
  public int addOne() {
    return ++i;
  }
}

class Target1 {
  private int i = 0;
  public int addOne() {
    return i++;
  }
}

public class Operator {
  public static void main(String[] args) {
    System.out.println(new Target().addOne());
    System.out.println(new Target1().addOne());
  }
}

/*
Answer: 
  return ++i => 1
  return i++ => 0
*/

