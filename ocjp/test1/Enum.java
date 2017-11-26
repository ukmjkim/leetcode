class Nav {
  public enum Direction { NORTH, SOUTH, EAST, WEST }
}

public class Enum {
  Nav.Direction d = Nav.Direction.NORTH;

  public static void main(String[] args) {
    System.out.println(new Enum().d);
  }
}

