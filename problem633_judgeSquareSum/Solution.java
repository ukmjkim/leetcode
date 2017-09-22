public class Solution {
  public boolean judgeSquareSum(int c) {
    if (c < 0) return false;

    int left = 0, right = (int) Math.sqrt(c);
    while (left <= right) {
      int cur = (left*left) + (right*right);
      if (cur < c) {
        left++;
      } else if (cur > c) {
        right--;
      } else {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int c = 5;
    System.out.printf("judgeSquareSum(%d) : %b\n", c, solution.judgeSquareSum(c));

    int c2 = 4;
    System.out.printf("judgeSquareSum(%d) : %b\n", c2, solution.judgeSquareSum(c2));
  }
}

