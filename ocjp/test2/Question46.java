import java.util.Iterator;
import java.util.TreeSet;

public class Question46 {
  public static void main(String... args) {
    TreeSet<String> s1 = new TreeSet<String>();
    s1.add("one"); 
    s1.add("two");
    s1.add("three");
    s1.add("one");
    Iterator it = s1.iterator();
    while (it.hasNext() ) { System.out.print( it.next() + " " ); }
  }
}

/*

Sorted

one three two

*/

