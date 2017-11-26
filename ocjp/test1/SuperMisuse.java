class Money {
  private String country = "Canada";
  public String getC() { return country; }
}

class Yen extends Money {
  public String getC() { return super.country; }
}

class Euro extends Money {
  public String getC(int x) { return super.getC(); }
}

public class SuperMisuse {
  public static void main(String[] args) {
    System.out.print(new Yen().getC() + " " + new Euro().getC());
  }
}

/*
Compilation error due to an error on line 7

Correction: protected String country = "Canada";
*/

