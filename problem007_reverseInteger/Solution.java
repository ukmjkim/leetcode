public class Solution {
  public int reverse(int x) {
    int result = 0;
    while (x != 0) {
      int tail = x % 10;
      int newResult = result * 10 + tail;
      
      // Overflow check
      if ((newResult - tail) / 10 != result) { return 0; }
      result = newResult;
      x = x / 10;
    }
    
    return result;
  }

  /* This solution will have overflow issue
  public int reverse(int x) {
    if (x == 0) return 0;

    int sign = 1;
    if (x < 0) {
      sign = -1;
      x *= -1;
    }
    String newNum = "";
    while (x > 0) {
      int digit = x % 10;
      newNum += digit;
      x = x / 10;
    }
    
    return Integer.parseInt(newNum) * sign;
  }
  */

  public static void main(String[] args) {
    int num = -413;

    Solution solution = new Solution();
    System.out.println("Result: " + solution.reverse(num));
  }
}
