import java.util.*;

public class Solution {
  public int hammingDistance(int x, int y) {
    // corresponding bits are different => XOR
    int xor = x ^ y, count = 0;
    for (int i = 0; i < 32; i++) count += (xor >> i) & 1;
      return count;
  }

  public int hammingDistance2(int x, int y) {
    // corresponding bits are different => XOR
    return Integer.bitCount(x ^ y);
  }

  public static void main(String[] args) {
    int x, y;

    Solution solution = new Solution();

    x = 1;
    y = 4;
    System.out.printf("hammingDistance(%d, %d): %d, %d\n\n", x, y, solution.hammingDistance(x, y), solution.hammingDistance2(x, y));

    x = 10;
    y = 20;
    System.out.printf("hammingDistance(%d, %d): %d, %d\n\n", x, y, solution.hammingDistance(x, y), solution.hammingDistance2(x, y));
  }
}



