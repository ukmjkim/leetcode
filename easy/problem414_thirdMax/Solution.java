import java.util.*;

public class Solution {
  public int thirdMax(int[] nums) {
    Integer max1 = null;
    Integer max2 = null;
    Integer max3 = null;
    
    for (Integer n : nums) {
      if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
      if (max1 == null || n > max1) {
        max3 = max2;
        max2 = max1;
        max1 = n;
      } else if (max2 == null || n > max2) {
        max3 = max2;
        max2 = n;
      } else if (max3 == null || n > max3) {
        max3 = n;
      }
    }
    
    return max3 == null ? max1 : max3;
  }

  public static void main(String[] args) {
    int[] nums1 = {3, 2, 1};
    int[] nums2 = {1, 2};
    int[] nums3 = {2, 2, 3, 1};
    int[] nums4 = {1};

    Solution solution = new Solution();

	System.out.println(Arrays.toString(nums1));
    System.out.printf("thirdMax(): %d\n", solution.thirdMax(nums1));
    System.out.println();

  	System.out.println(Arrays.toString(nums2));
    System.out.printf("thirdMax(): %d\n", solution.thirdMax(nums2));
    System.out.println();

  	System.out.println(Arrays.toString(nums3));
    System.out.printf("thirdMax(): %d\n", solution.thirdMax(nums3));
    System.out.println();

  	System.out.println(Arrays.toString(nums4));
    System.out.printf("thirdMax(): %d\n", solution.thirdMax(nums4));
    System.out.println();
  }
}


