public class Solution {
  public boolean isPowerOfFour(int num) {
    if (num == 0) return false;
    return (num == Math.pow(4, Math.round(Math.log(num)/Math.log(4))));
  }

  // Recursive
  public boolean isPowerOfFour2(int num) {
    if (num == 0) return false;
    if (num == 1) return true;
    
    if (num > 1)
      return ((num%4) == 0 && isPowerOfFour2(num/4));
    else
      return false;
  }

  // Iterative
  public boolean isPowerOfFour3(int num) {
    if (num == 0) return false;
    
    while (num >= 1) {
      num /= 4;
      if (num == 1) return true;
      if ((num % 4) > 0) return false;
    }
    
    return true;
  }

  public static void main(String[] string) {
    Solution solution = new Solution();
    System.out.printf("isPowerOfFour(%d): %b\n", 4, solution.isPowerOfFour(4));
    System.out.printf("isPowerOfFour(%d): %b\n", 8, solution.isPowerOfFour(8));
    System.out.printf("isPowerOfFour(%d): %b\n", 16, solution.isPowerOfFour(16));

    System.out.printf("isPowerOfFour(%d): %b\n", 4, solution.isPowerOfFour2(4));
    System.out.printf("isPowerOfFour(%d): %b\n", 8, solution.isPowerOfFour2(8));
    System.out.printf("isPowerOfFour(%d): %b\n", 16, solution.isPowerOfFour2(16));

    System.out.printf("isPowerOfFour(%d): %b\n", 4, solution.isPowerOfFour3(4));
    System.out.printf("isPowerOfFour(%d): %b\n", 8, solution.isPowerOfFour3(8));
    System.out.printf("isPowerOfFour(%d): %b\n", 16, solution.isPowerOfFour3(16));
  }
}

