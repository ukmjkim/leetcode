public class Solution {
  // Newton's method
  public boolean isPerfectSquare(int num) {
    if (num < 1) return false;

    long t = num/2+1;
    while (t*t > num) {
System.out.println("t: " + t);
      t = (t+num/t)/2;
    }
    return t*t == num;
  }

  public boolean isPerfectSquare2(int num) {
    long start = 1, end = num;
    while (start <= end) {
      long mid = start + (end-start)/2;
      long t = mid * mid;
      if (t == num) return true;
      else if (t < num) start = mid+1;
      else end = mid-1;
System.out.printf("start: %d, end: %d\n", start, end);
    }
    return false;
  }

  public static void main(String[] args) {
    int num = 16;

    Solution solution = new Solution();
    System.out.println("isPerfectSquare(16): " + solution.isPerfectSquare(16));
    System.out.println("isPerfectSquare(49): " + solution.isPerfectSquare2(49));
  }
}

