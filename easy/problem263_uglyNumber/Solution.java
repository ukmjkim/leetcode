public class Solution {
  public boolean isUgly(int num) {
    for (int i=2; i < 6 && num > 0; i++)
      while (num % i == 0)
        num /= i;
    return num == 1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println("isUgly(6) " + solution.isUgly(6));
    System.out.println("isUgly(8) " + solution.isUgly(8));
    System.out.println("isUgly(14) " + solution.isUgly(14));
  }
}


