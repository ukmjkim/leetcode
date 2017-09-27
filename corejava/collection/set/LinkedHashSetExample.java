import java.util.*;

public class LinkedHashSetExample {
  public static void main(String[] args) {
    // LinkedHashSet of Integer Type
    LinkedHashSet<Integer> lhset = new LinkedHashSet<Integer>();

    lhset.add(1);
    lhset.add(99);
    lhset.add(3);
    lhset.add(89);
    System.out.println(lhset);
  }
}

