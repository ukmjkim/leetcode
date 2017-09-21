import java.util.*;

public class Solution {
  public int findUnsortedSubarray(int[] nums) {
    if (nums.length < 2) return 0;

    int[] newArray = new int[nums.length];
    newArray = Arrays.copyOf(nums, nums.length);
    Arrays.sort(newArray);

    int start = 0;
    int end = nums.length-1;
    boolean leftEnd = false;
    boolean rightEnd = false;
    while (true) {
      if (start >= end) break;
      if (leftEnd == true && rightEnd == true) break;
      if (nums[start] == newArray[start]) {
        start++;
      } else {
        leftEnd = true;
      }
      if (nums[end] == newArray[end]) {
        end--;
      } else {
        rightEnd = true;
      }
    }
    return (leftEnd == false && rightEnd == false) ? 0 : end - start + 1;
  }
  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = {2, 6, 4, 8, 10, 9, 15};
    System.out.printf("findUnsertedSubarray(%s) : %d\n", Arrays.toString(nums), solution.findUnsortedSubarray(nums));

    int[] nums2 = {10, 3, 4, 8, 10, 9, 15};
    System.out.printf("findUnsertedSubarray(%s) : %d\n", Arrays.toString(nums2), solution.findUnsortedSubarray(nums2));

    int[] nums3 = {1, 2, 3, 3, 3};
    System.out.printf("findUnsertedSubarray(%s) : %d\n", Arrays.toString(nums3), solution.findUnsortedSubarray(nums3));
  }
}
