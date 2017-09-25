import java.util.*;

public class Solution {
  // Recursive: Time ~ O(N), Space ~ O(1)
  public void rotate(int[] nums, int k) {
    k %= nums.length;
    // A (len = n - k), B (len = k)
    // rev(rev(A)rev(B)) = BA
    reverse(nums, 0, nums.length-1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }
  
  public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  // Iterative : Interesting way, O(n) time cost, O(1) space cost
  public void rotate2(int[] nums, int k) {
    if(nums.length <= 1){
      return;
    }
    //step each time to move
    int step = k % nums.length;
    //find GCD between nums length and step
    int gcd = findGcd(nums.length, step);
    int position, count;
        
    //gcd path to finish movie
    for(int i = 0; i < gcd; i++){
      //beginning position of each path
      position = i;
      //count is the number we need swap each path
      count = nums.length / gcd - 1;
      for(int j = 0; j < count; j++){
        position = (position + step) % nums.length;
        //swap index value in index i and position
        nums[i] ^= nums[position];
        nums[position] ^= nums[i];
        nums[i] ^= nums[position];
      }
    }
  }
    
  public int findGcd(int a, int b){
    return (a == 0 || b == 0) ? a + b : findGcd(b, a % b);
  }
    

  // Iterative : Normal way, O(n) time cost, O(k % nums.length) space cost
  public void rotate3(int[] nums, int k) {
    if(nums.length <= 1){
      return;
    }
    //step each time to move
    int step = k % nums.length;
    int[] tmp = new int[step];
    for(int i = 0; i < step; i++){
      tmp[i] = nums[nums.length - step + i];
    }
    for(int i = nums.length - step - 1; i >= 0; i--){
      nums[i + step] = nums[i];
    }
    for(int i = 0; i < step; i++){
      nums[i] = tmp[i];
    }   
  }
    
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7};

    Solution solution = new Solution();
    solution.rotate2(nums, 3);
    System.out.println("rotate(nums): " + Arrays.toString(nums));
	solution.rotate2(nums, 3);
    System.out.println("rotate(nums): " + Arrays.toString(nums));
	solution.rotate3(nums, 3);
    System.out.println("rotate(nums): " + Arrays.toString(nums));
  }
}
