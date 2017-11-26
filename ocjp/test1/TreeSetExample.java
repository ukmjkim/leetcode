import java.util.*;

public class TreeSetExample {
  public static void main(String[] args) {
    TreeSet<Integer> s = new TreeSet<Integer>();
    TreeSet<Integer> subs = new TreeSet<Integer>();

    for (int i = 606; i < 613; i++)
      if (i % 2 == 0)
        s.add(i);

    subs = (TreeSet<Integer>) s.subSet(608, true, 611, true);
    subs.add(629);
    System.out.println(s + " " + subs);
  }
}

/*
Answer:

Mijungs-MBP-2:ocjp MijungKimMacPro$ java TreeSetExample
Exception in thread "main" java.lang.IllegalArgumentException: key out of range
  at java.util.TreeMap$NavigableSubMap.put(TreeMap.java:1516)
  at java.util.TreeSet.add(TreeSet.java:255)
  at TreeSetExample.main(TreeSetExample.java:13)


subs.add(629); -> subs.add(609);
Mijungs-MBP-2:ocjp MijungKimMacPro$ java TreeSetExample
[606, 608, 609, 610, 612] [608, 609, 610]

*/

