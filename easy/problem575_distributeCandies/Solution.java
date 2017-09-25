import java.util.*;

public class Solution {
  public int distributeCandies(int[] candies) {
    Set<Integer> kinds = new HashSet<>();
    for (int candy : candies) kinds.add(candy);
    return (kinds.size() >= candies.length / 2) ? candies.length / 2 : kinds.size();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] candies = {1, 1, 2, 3};
    System.out.printf("distributeCandies(%s) : %d\n", Arrays.toString(candies), solution.distributeCandies(candies));
  }
}
