class Atom {
  Atom() { System.out.print("atom "); }
}

class Rock extends Atom {
  Rock(String type) { System.out.print(type); }
}

public class Constructor extends Rock {
  Constructor() {
    super("granite ");
    new Rock("granite ");
  }

  public static void main(String[] a) { new Constructor(); }
}

/*
Answer: atom granite atom granite
*/

