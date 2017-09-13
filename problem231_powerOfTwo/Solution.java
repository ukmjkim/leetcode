public class Solution {
  public boolean isPowerOfTwo(int n) {
    return ((n & (n - 1)) == 0 && n > 0);
  }

  public static void main(String[] args) {
    int num = 4;

    Solution solution = new Solution();
	System.out.println("Result: " + solution.isPowerOfTwo(num));
  }
}


