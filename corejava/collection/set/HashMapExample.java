import java.util.*;
import java.util.Map.Entry;

public class HashMapExample {
  public static void main(String[] args) {
    HashMap<Integer, String> hmap = new HashMap<Integer, String>();

    // Adding elements to HashMap
    hmap.put(12, "Sandy");
    hmap.put(2, "Runy");
    hmap.put(7, "Johny");
    hmap.put(49, "Rally");
    hmap.put(3, "York");

    System.out.println("containsKey:" + hmap.containsKey(12));
    System.out.println("containsValue:" + hmap.containsValue("Rally"));

    System.out.println("For Loop:");
    for (Map.Entry<Integer, String> entry : hmap.entrySet()) {
      System.out.println("Key: " + entry.getKey() + " & Value: " + entry.getValue());
    }

    // Display content using Iterator
    Set<Map.Entry<Integer, String>> set = hmap.entrySet();
    Iterator<Map.Entry<Integer, String>> itr = set.iterator();
    while (itr.hasNext()) {
      Map.Entry<Integer, String> entry = itr.next();
      System.out.print("key is: " + entry.getKey() + " & value is: ");
      System.out.println(entry.getValue());
    }

    // Get values based on key
    String var = hmap.get(2);
    System.out.println("Value at index 2 is: " + var);

    // Remove values based on key
    hmap.remove(3);
    System.out.println("Map key and values after removal: ");

    // Display content using Iterator
    Set<Map.Entry<Integer, String>> set2 = hmap.entrySet();
    Iterator<Map.Entry<Integer, String>> iterator2 = set2.iterator();
    while (iterator2.hasNext()) {
      Map.Entry<Integer, String> entry2 = iterator2.next();
      System.out.print("Key is: " + entry2.getKey() + " & Value is: ");
      System.out.println(entry2.getValue());
    }

    // Sort HashMap
    Map<Integer, String> map = new TreeMap<Integer, String>(hmap);
    for (Map.Entry<Integer, String> entry : map.entrySet()) {
      System.out.println("Sorted Key: " + entry.getKey() + ", Value: " + entry.getValue());
    }

    Map<Integer, String> sortedMap = sortByValues(hmap);
    for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
      System.out.println("Sorted Key: " + entry.getKey() + ", Value: " + entry.getValue());
    }

    HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
    hashMap.put(1, "Tony");
    hashMap.put(2, "Tom");
    hashMap.put(3, "Derik");
    Map<Integer, String> synchMap = Collections.synchronizedMap(hashMap);
    Set<Map.Entry<Integer, String>> entrySet = synchMap.entrySet();
    synchronized(map) {
      Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
      while (iterator.hasNext()) {
        Map.Entry<Integer, String> entry = iterator.next();
        System.out.print(entry.getKey() + ": ");
        System.out.println(entry.getValue());
      }
    }
  }

  private static HashMap<Integer, String> sortByValues(HashMap<Integer, String> map) {
    List<Map.Entry<Integer, String>> list = new LinkedList<>(map.entrySet());

    // Defined Custom Comparator here
    Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
      public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
        String str1 = o1.getValue();
        String str2 = o1.getValue();
        return str1.compareTo(str2);
      }
    });

    HashMap<Integer, String> sortedHashMap = new LinkedHashMap<Integer, String>();
    Iterator<Map.Entry<Integer, String>> it = list.iterator();
    while (it.hasNext()) {
      Map.Entry<Integer, String> entry = it.next();
      sortedHashMap.put(entry.getKey(), entry.getValue());
    }
    return sortedHashMap;
  }
}
