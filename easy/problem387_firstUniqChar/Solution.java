import java.util.*;

public class Solution {
  public int firstUniqChar(String s) {
    final int MaxNumberofAlphabet = 26;

    int[] alphabet = new int[MaxNumberofAlphabet];
    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      int idx = arr[i] - 'a';
      alphabet[idx] ++;
    }
    for (int i = 0; i < arr.length; i++) {
      int idx = arr[i] - 'a';
      if (alphabet[idx] == 1) {
        return i;
      }
    }
    
    return -1;
  }

  public static void main(String[] args) {
    String s = "loveleetcode";
    
    Solution solution = new Solution();
    System.out.println("Result: " + solution.firstUniqChar(s));
  }
}

