import java.util.*;

public class Solution {
  public String convertToBase7(int num) {
    String sign = "";
    if (num < 0) {
      sign = "-";
      num = -num;
    }
    StringBuilder sb = new StringBuilder();
    while (num >= 0) {
      if (num < 7) {
        sb.insert(0, num);
        break;
      }
      int tail = num % 7;
      num = num / 7;
      sb.insert(0, tail);
    }
    sb.insert(0, sign);

    return sb.toString();
  }
  
  public static void main(String[] args) {
    int num;

    num = 100;
    Solution solution = new Solution();
    System.out.printf("convertToBase7(%d): %s\n", num, solution.convertToBase7(num));

    num = -7;
    System.out.printf("convertToBase7(%d): %s\n", num, solution.convertToBase7(num));
  }
}



