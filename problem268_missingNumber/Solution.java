public class Solution {
  public int missingNumber(int[] nums) {
    int xor = 0, i = 0;
    for (i = 0; i < nums.length; i++) {
      xor = xor ^ i ^ nums[i];
    }
    return xor ^ i;
  }

  public static void main(String[] args) {
    int[] num1 = {0, 1, 2, 4};
    int[] num2 = {0, 1, 3, 4};
    int[] num3 = {0, 2, 3, 4};
    Solution solution = new Solution();
    System.out.println("missingNumber(): " + solution.missingNumber(num1));
    System.out.println("missingNumber(): " + solution.missingNumber(num2));
    System.out.println("missingNumber(): " + solution.missingNumber(num3));
  }
}

