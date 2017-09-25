[Question]
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

[Solution]
majority element is more than n/2

Another possible solution.
public class Solution {
    public int majorityElement(int[] nums) {
      Arrays.sort(nums);
	  int len = nums.length;
	  return nums[len/2];
    }
}
