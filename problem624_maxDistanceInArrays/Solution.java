import java.util.*;

public class Solution {
  public int maxDistance(List<List<Integer>> list) {
    int result = Integer.MIN_VALUE;
    int max = list.get(0).get(list.get(0).size()-1);
    int min = list.get(0).get(0);

    for (int i = 1; i < list.size(); i++) {
      result = Math.max(result, Math.abs(list.get(i).get(0) - max));
      result = Math.max(result, Math.abs(list.get(i).get(list.get(i).size() - 1) - min));
      max = Math.max(max, list.get(i).get(list.get(i).size() - 1));
      min = Math.min(min, list.get(i).get(0));
    }

    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> oneList = new ArrayList<>();
    oneList.add(1);
    oneList.add(2);
    oneList.add(3);
    list.add(new ArrayList<>(oneList));
    oneList.clear();

    oneList.add(4);
    oneList.add(5);
    list.add(new ArrayList<>(oneList));
    oneList.clear();

    oneList.add(1);
    oneList.add(2);
    oneList.add(3);
    list.add(new ArrayList<>(oneList));
    oneList.clear();

    System.out.println(list);
    System.out.printf("maxDistanceOfArrayList() : %d\n", solution.maxDistance(list));
  }
}

