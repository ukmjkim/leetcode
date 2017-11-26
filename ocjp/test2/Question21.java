import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Question21 {
  @SuppressWarnings("unchecked")
  public static void main(String...args) {
    Set s = new TreeSet();
    s.add("7");
    s.add(9);
    Iterator itr = s.iterator();
    while (itr.hasNext())
      System.out.print(itr.next() + " ");
  }
}

/*

Mijungs-MBP-2:test2 MijungKimMacPro$ java Question21
Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
  at java.lang.Integer.compareTo(Integer.java:52)
  at java.util.TreeMap.put(TreeMap.java:568)
  at java.util.TreeSet.add(TreeSet.java:255)
  at Question21.main(Question21.java:10)

*/
