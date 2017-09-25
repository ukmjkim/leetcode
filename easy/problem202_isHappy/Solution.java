import java.util.*;

public class Solution {
  public boolean isHappy(int n) {
    if (n < 1) {
      return false;
    }
    HashSet<Integer> set = new HashSet<>(32);
    int tmp;
    int newN;
    
    while (n != 1 && !set.contains(n)) {
      set.add(n);
      newN = 0;
      while (n > 0) {
        tmp = n % 10;
        n /= 10;
        newN += tmp * tmp;
      }
      System.out.println("newN: " + newN);
      n = newN;
    }
    
    return n == 1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println("isHappy(): " + solution.isHappy(19));
  }
}

