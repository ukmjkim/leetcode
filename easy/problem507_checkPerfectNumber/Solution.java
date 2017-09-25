import java.util.*;

public class Solution {
  public boolean checkPerfectNumber(int num) {
    if (num == 1) return false;
    
    int sum = 1;
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        sum += i + (num / i);
      }
    }

    return sum == num ? true : false;
  }
  
  public static void main(String[] args) {

    Solution solution = new Solution();

    int num = 28;
    System.out.printf("findRelativeRanks(%d): %b\n", num, solution.checkPerfectNumber(num));

    int num2 = 99999992;
    System.out.printf("findRelativeRanks(%d): %b\n", num2, solution.checkPerfectNumber(num2));
  }
}


