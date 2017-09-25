public class Solution {
  public int hammingWeight(int n) {
    int ones = 0;
    while (n != 0) {
      ones = ones + (n & 1);
      n = n >>> 1;
    }
    
    return ones;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println("hammingWeight(3): " + solution.hammingWeight(3));
    System.out.println("hammingWeight(5): " + solution.hammingWeight(5));
    System.out.println("hammingWeight(7): " + solution.hammingWeight(7));
  }
}

