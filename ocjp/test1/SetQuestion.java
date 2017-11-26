import java.util.*;

public class SetQuestion {
  enum Example { ONE, TWO, THREE };

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    Collection coll = new ArrayList();
    coll.add(Example.THREE);
    coll.add(Example.THREE);
    coll.add(Example.THREE);
    coll.add(Example.TWO);
    coll.add(Example.TWO);
    coll.add(Example.ONE);
    Set set = new HashSet(coll);
    System.out.println(set);
  }
}

/*
Answer:

The set variable contains only three elements from the coll collection, but the order is NOT guaranteed to be preserved
*/

