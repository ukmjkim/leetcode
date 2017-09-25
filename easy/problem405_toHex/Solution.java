import java.util.*;

public class Solution {
  char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
  public String toHex(int num) {
    if(num == 0) return "0";
      String result = "";
      while(num != 0){
        result = map[(num & 15)] + result; 
        num = (num >>> 4);
      }
      return result;
  }

  public static void main(String[] args) {
    int num;

    Solution solution = new Solution();

    num = 26;
    System.out.printf("toHex(%d): %s\n", num, solution.toHex(num));

    num = -1;
    System.out.printf("toHex(%d): %s\n", num, solution.toHex(num));
  }
}

