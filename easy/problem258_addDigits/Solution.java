public class Solution {
  public int addDigits(int num) {
    if (num == 0) return 0;
    
    while (true) {
      if (num < 10) return num;

      int sum = 0;
      while (num >= 10) {
        int lastDigit = num % 10;
        sum += lastDigit;
        num /= 10;
      }
      if (num > 0) sum += num;
      num = sum;
    }
  }

  public static void main(String[] args) {
    int num = 19;

    Solution solution = new Solution();
    System.out.println("Result " + solution.addDigits(num));
  }
}


