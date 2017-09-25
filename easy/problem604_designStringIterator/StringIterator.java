import java.util.*;

public class StringIterator {
  private Queue<int[]> queue = new LinkedList<>();

  public StringIterator(String compressedString) {
    int i = 0, n = compressedString.length();
    while (i < n) {
      int j = i + 1;
      // 0 - 9 : ASCII 48 - 57
      // A - Z : ASCII 65 - 90
      // a - z : ASCII 97 - 122
      while (j < n && compressedString.charAt(j) - 'A' < 0) j++;
      queue.add(new int[] {compressedString.charAt(i) - 'A', Integer.parseInt(compressedString.substring(i+1, j))});
      i = j;
    }
  }

  public char next() {
    if (queue.isEmpty()) return ' ';
    int[] top = queue.peek();
    if (--top[1] == 0) queue.poll();
    return (char) ('A' + top[0]);
  }

  public boolean hasNext() {
    return !queue.isEmpty();
  }

  public static void main(String[] args) {
    String compressedString = "L1e2t1C1o1d1e1";
    StringIterator iterator = new StringIterator(compressedString);
    System.out.printf("%s\n", iterator.next());
    System.out.printf("%s\n", iterator.next());
    System.out.printf("%s\n", iterator.next());
    System.out.printf("%s\n", iterator.next());
    System.out.printf("%s\n", iterator.next());
    System.out.printf("%s\n", iterator.next());
    System.out.printf("%s\n", iterator.next());
    System.out.printf("%b\n", iterator.hasNext());
    System.out.printf("%s\n", iterator.next());
    System.out.printf("%b\n", iterator.hasNext());
    System.out.printf("%s\n", iterator.next());
  }
}

