public class Solution {
  public int firstBadVersion(int n) {
    int start = 1, end = n;
    while (start < end) {
      int mid = start + (end - start) / 2;
      if (!isBadVersion(mid)) start = mid + 1;
      else end = mid;
    }
    return start;
  }

  private boolean isBadVersion(int version) {
    return (version >= 1);
  }
  
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println("firstBadVersion: " + solution.firstBadVersion(2));
  }
}


