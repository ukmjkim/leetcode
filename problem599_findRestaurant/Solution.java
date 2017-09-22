import java.util.*;

public class Solution {
  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> mapIndex = new HashMap<>();
    for (int i = 0; i < list1.length; i++) {
      map.put(list1[i], map.getOrDefault(list1[i], 0) + 1);
      mapIndex.put(list1[i], i);
    }
    for (int j = 0; j < list2.length; j++) {
      map.put(list2[j], map.getOrDefault(list2[j], 0) + 1);
      mapIndex.put(list2[j], mapIndex.getOrDefault(list2[j], 0) + j);
    }

    int min = Integer.MAX_VALUE;
    List<String> stores = new LinkedList<>();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() > 1) {
        if (min > mapIndex.get(entry.getKey())) {
          min = mapIndex.get(entry.getKey());
          stores.clear();
          stores.add(entry.getKey());
        } else if (min == mapIndex.get(entry.getKey())) {
          stores.add(entry.getKey());
        }
      }
    }

    String[] result = new String[stores.size()];
    int i = 0;
    for (String store : stores) {
      result[i] = store;
      i++;
    }

    return result;
  }

  public static void main(String[] args) {
    String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
    String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter SteakHouse", "Shogun"};

    Solution solution = new Solution();
    String[] result = solution.findRestaurant(list1, list2);
    System.out.println(Arrays.toString(result));
  }
}

