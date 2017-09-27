import java.util.*;

public class HashSetExample {
  public static void main(String[] args) {
    HashSet<String> hset = new HashSet<String>();

    // Adding elements to the Hashset
    hset.add("Apple");
    hset.add("Mango");
    hset.add("Grapes");
    hset.add("Orange");
    hset.add("Fig");

    // Addition of duplicates elements
    hset.add("Apple");
    hset.add("Mango");

    // Addition of null values
    hset.add(null);
    hset.add(null);

    // Displaying HashSet elements
    System.out.println(hset);

    // Displaying HashSet using Iterator
    System.out.println("HashSet Iterator: ");
    Iterator<String> itr = hset.iterator();
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }

    // Displaying HashSet using Advanced For loop 
    System.out.println("HashSet Advanced For loop: ");
    for (String str : hset) {
      System.out.println(str);
    }

    //  Creating an Array from HashSet
    System.out.println("HashSet to Array: ");
    String[] arr = new String[hset.size()];
    hset.toArray(arr);
    System.out.println(Arrays.toString(arr));

    System.out.println("HashSet to ArrayList: ");
    ArrayList<String> arrList = new ArrayList<String>(hset);
    System.out.println(arrList);

    // Creating a TreeSet of HashSet elements
    // Exception in thread "main" java.lang.NullPointerException
    // You must remove null first
    hset.remove(null);
    System.out.println("HashSet to TreeSet: ");
    Set<String> tset = new TreeSet<String>(hset);
    System.out.println(tset);

    hset.clear();
    System.out.println("After: HashSet contains: " + hset);
  }
}

