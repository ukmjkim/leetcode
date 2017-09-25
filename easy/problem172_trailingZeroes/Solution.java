public class Solution {
  // Recursive
  public int trailingZeroes(int n) {
    return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
  }
  
  // Iterative
  public int trailingZeroes2(int n) {
    int sum = 0;
    while (n >= 5) {
      sum += n/5;
      n /= 5;
    }
    return sum;
  }
    
  public static void main(String[] args) {
    Solution solution = new Solution();
    
    System.out.println("trailingZeroes(60): " + solution.trailingZeroes(60));
    System.out.println("trailingZeroes(80): " + solution.trailingZeroes2(80));
  }
}

