import java.util.*;

public class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int count = 0;
    for (int i = 0; i < flowerbed.length && count < n; i++) {
      if (flowerbed[i] == 0) {
        int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i+1];
        int prev = (i == 0) ? 0 : flowerbed[i - 1];
        if (next == 0 && prev == 0) {
          flowerbed[i] = 1;
          count++;
        }
      }
    }

    return count == n;
  }

  public static void main(String[] args) {

    Solution solution = new Solution();

    // 1, 0, 1, 0, 1 -> true, 3 0s -> 1 (N*2+1)
    int n1 = 1;
    int[] flowerbed1 = {1, 0, 0, 0, 1};
    System.out.printf("canPlaceFlowers(%s, %d) : %b\n", Arrays.toString(flowerbed1), n1, solution.canPlaceFlowers(flowerbed1, n1));

    // 1, 0, 1, 0, 1, 0, 0, 1, 0, 1 -> false
    int n2 = 3;
    int[] flowerbed2 = {0, 0, 1, 0, 0, 0, 0, 1, 0, 0};
    System.out.printf("canPlaceFlowers(%s, %d) : %b\n", Arrays.toString(flowerbed2), n2, solution.canPlaceFlowers(flowerbed2, n2));

    // 1, 0, 1, 0, 1, 0, 1 -> true, 5 0s -> 2 (N*2+1)
    int n3 = 2;
    int[] flowerbed3 = {1, 0, 0, 0, 0, 0, 1};
    System.out.printf("canPlaceFlowers(%s, %d) : %b\n", Arrays.toString(flowerbed3), n3, solution.canPlaceFlowers(flowerbed3, n3));

    // 1, 0, 1, 0, 1, 0, 1, 0, 1 -> true, 7 0s -> 3 (N*2+1)
    int n4 = 3;
    int[] flowerbed4 = {1, 0, 0, 0, 0, 0, 0, 0, 1};
    System.out.printf("canPlaceFlowers(%s, %d) : %b\n", Arrays.toString(flowerbed4), n4, solution.canPlaceFlowers(flowerbed4, n4));
  }
}
