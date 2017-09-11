public class Solution {
    public int climbStairs(int n) {
      if (n <= 0) return 0;
      if (n == 1) return 1;
      if (n == 2) return 2;
      
      int one_steps_before = 2;
      int two_steps_before = 1;
      int all_ways = 0;
      
      for (int i = 2; i < n; i++) {
        all_ways = one_steps_before + two_steps_before;
        two_steps_before = one_steps_before;
        one_steps_before = all_ways;
      }
	  return all_ways;
    }
  
  public static void main(String[] args) {
    int x = 4;
    
    Solution solution = new Solution();
    int result = solution.climbStairs(x);
    System.out.println("Result: " + result);
  }
}

