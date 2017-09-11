public class Solution {
    public int mySqrt(int x) {
        int left = 1, right = x/2;
        while (left <= right) {
            int mid = (left + right) / 2;
			System.out.println("left: " + left + ", right: " + right + ", mid: " + mid);
            if (mid > x/mid) {
                right = mid - 1;
                continue;
            }
            if ((mid+1) <= x/(mid+1)) {
                left = mid + 1;
                continue;
            }
            return mid;
        }
        return x;
    }
  
  public static void main(String[] args) {
    int x = 64;
    
    Solution solution = new Solution();
    int result = solution.mySqrt(x);
    System.out.println("Result: " + result);
  }
}
