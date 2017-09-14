import java.util.*;

public class NumArray {
  int[] nums;

  public NumArray(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      nums[i] += nums[i-1];
    }
    this.nums = nums;
System.out.println(Arrays.toString(this.nums));
  }
  
  public int sumRange(int i, int j) {
    if (i == 0) return this.nums[j];

    return this.nums[j] - this.nums[i-1];
  }
  
  public static void main(String[] args) {
    int[] nums = {-2, 0, 3, -5, 2, -1};

    NumArray obj = new NumArray(nums);
    System.out.printf("sumRange(%d, %d): %d\n", 0, 2, obj.sumRange(0, 2));
    System.out.printf("sumRange(%d, %d): %d\n", 2, 5, obj.sumRange(2, 5));
    System.out.printf("sumRange(%d, %d): %d\n", 0, 5, obj.sumRange(0, 5));
  }
}


