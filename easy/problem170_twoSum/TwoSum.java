import java.util.*;

public class TwoSum {
  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
  
  public void add(int number) {
    if (map.containsKey(number)) {
      map.put(number, map.get(number) + 1);
    } else {
      map.put(number, 1);
    }
  }

  public boolean find(int value) {
    for (int key : map.keySet()) {
      int diff = value - key;
      if (diff == key && map.get(key) > 1) {
        return true;
      } else if (diff != key && map.containsKey(diff)) {
        return true;
      }
    }
    return false;
  }
    
  public static void main(String[] args) {
    TwoSum twoSum = new TwoSum();
    twoSum.add(1);
    twoSum.add(3);
    twoSum.add(5);
    
    System.out.println("twoSum.find(4): " + twoSum.find(4));
    System.out.println("twoSum.find(4): " + twoSum.find(7));
  }
}

