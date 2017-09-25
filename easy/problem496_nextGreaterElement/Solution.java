import java.util.*;

public class Solution {
  public int[] nextGreaterElement(int[] findNums, int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    
    for (int num : nums) {
      while (!stack.isEmpty() && stack.peek() < num) {
        map.put(stack.pop(), num);
      }
      stack.push(num);
    }
    
    for (int i = 0; i < findNums.length; i++)
      findNums[i] = map.getOrDefault(findNums[i], -1);

    return findNums;
  }
  
  public static void main(String[] args) {

    Solution solution = new Solution();

    int[] findNums = {4, 1, 2};
    int[] nums = {1, 3, 4, 2};
    System.out.println("nextGreaterElement()");    
    System.out.println(Arrays.toString(findNums));    
    System.out.println(Arrays.toString(nums));    
    System.out.print("==> ");    
    System.out.println(Arrays.toString(solution.nextGreaterElement(findNums, nums)));    
    System.out.println("");

    int[] findNums1 = {8, 2, 4};
    int[] nums2 = {9, 8, 7, 3, 2, 1, 6, 5, 4, 10};
    System.out.println("nextGreaterElement()");    
    System.out.println(Arrays.toString(findNums1));    
    System.out.println(Arrays.toString(nums2));    
    System.out.print("==> ");    
    System.out.println(Arrays.toString(solution.nextGreaterElement(findNums1, nums2)));    
    System.out.println("");
  }
}

