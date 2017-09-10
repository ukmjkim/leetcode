import java.util.*;

public class Solution {
  public int[] plusOne(int[] digits) {
    int carry = 1;
    int index = digits.length - 1;
    
    while (index >= 0 && carry > 0) {
      digits[index] = (digits[index] + carry) % 10;
      carry = digits[index] == 0 ? 1 : 0;
      index--;
    }
    
    if (carry > 0) {
      digits = new int[digits.length + 1];
      digits[0] = 1;
    }
    
    return digits;
  }

  public static void main(String[] args) {
    int[] nums = {9, 9, 9, 9, 9};
	Solution solution = new Solution();
    int[] result = solution.plusOne(nums);
    System.out.println(Arrays.toString(result));
  }
}
