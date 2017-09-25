import java.util.*;

public class Solution {
  public int largestPalindrome(int n) {
    if (n == 1) return 9;
    
    // if n == 3, upperBound = 999, lowerBound = 99
    int upperBound = (int) Math.pow(10, n) - 1;
    int lowerBound = (int) upperBound / 10;
    // if n == 3, max number is 999(3digits) * 999(3digits)
    long maxNumber = (long) upperBound * (long) upperBound;
    
    // if n == 3, 999*999 = 998001, so 998 is the firstHalf
    int firstHalf = (int) (maxNumber / (long) Math.pow(10, n));
    
    boolean palindromeFound = false;
    long palindrome = 0;
    
    while (!palindromeFound) {
      // if n == 3, at the first loop, the palindrome number is 998,899
      palindrome = createPalindrome(firstHalf);
      
      //System.out.printf("n: %d, firstHalf: %d, palindrome: %d, maxNumber: %d ==================\n", n, firstHalf, palindrome, maxNumber);
      
      for (long i = upperBound; upperBound > lowerBound; i--) {

        /*
        System.out.printf("i: %d, maxNumber: %d, palindrome / i > maxNumber: %b, i * i < palindrome: %b\n", 
                         i, maxNumber,
                         (palindrome / i > maxNumber),
                         (i * i < palindrome));
        */

        // if n == 3, (1) 998,899 / 999 > 998,001 (false)                           
        // if n == 3, (2) 999*999 = 998001 < 998,899 (true)
        if (palindrome / i > maxNumber || i * i < palindrome) {
          break;
        }
        
        if (palindrome % i == 0) {
          //System.out.printf("***** palindrome: %d, i: %d, palindromeFound\n", palindrome, i);
          palindromeFound = true;
          break;
        }
      }
      firstHalf--;
    }
    
    return (int) (palindrome % 1337);
  }

  private long createPalindrome(long num) {
    String str = num + new StringBuilder().append(num).reverse().toString();
    return Long.parseLong(str);
  }

  public static void main(String[] args) {
    int num = 2;

    Solution solution = new Solution();
    System.out.printf("largestPalindrome(%d): %d", num, solution.largestPalindrome(num));
  }
}

