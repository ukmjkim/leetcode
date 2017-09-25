import java.util.*;

public class Solution {
  public int findNthDigit(int n) {
    int len = 1;
    long count = 9;
    int start = 1;

    while (n > len * count) {
System.out.printf("len=%d, count=%d, n=%d, start=%d\n", len, count, n, start);
      n -= len * count;
      len += 1;
      count *= 10;  // 9, 90, 900, 9000
      start *= 10;
System.out.printf("len=%d, count=%d, n=%d, start=%d\n", len, count, n, start);
    }

    // case 11, 11th digit is 0 which is a part of 10.
    // case 13, 13th digit is 1 which is a part of 12. if (n)/len then it would be 2
    // the digit is the last digit of a number, then it returns the next number if n/len
    start += (n-1) / len;
    String s = Integer.toString(start);
    return Character.getNumericValue(s.charAt((n - 1) % len));
  }
  
  public static void main(String[] args) {
    int num;

    Solution solution = new Solution();
    
    num = 13;
    System.out.printf("findNthDigit(%d): %d\n", num, solution.findNthDigit(num));
    /*
    num = 3;
    System.out.printf("findNthDigit(%d): %d\n", num, solution.findNthDigit(num));
    
    num = 20;
    System.out.printf("findNthDigit(%d): %d\n", num, solution.findNthDigit(num));
    */
  }
}

