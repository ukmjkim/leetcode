import java.util.*;

public class Solution {
  public String reverseStr(String s, int k) {
    char[] cArray = s.toCharArray();

    // Case 1: length < k
    if (s.length() <= k) {
      reverse(cArray, 0, s.length()-1);
      return String.copyValueOf(cArray);
    }

    // Case 2: length > k and length < 2k
    if (s.length() < 2*k) {
      reverse(cArray, 0, k-1);
      return String.copyValueOf(cArray);
    }

    // Case 3: length >= 2*k
    reverse(cArray, 0, k-1);
    int start = 2 * k;
    while (start < s.length()) {
      int end = start + k > s.length()-1 ? s.length()-1 : start + k - 1;
//System.out.printf("start: %d, end: %d\n", start, end);
      reverse(cArray, start, end);
      start += (2 * k);
    }
 
    return String.copyValueOf(cArray);
  }

  private void reverse(char[] cArray, int start, int end) {
    while (start <= end) {
      char cTemp = cArray[start];
      cArray[start] = cArray[end];
      cArray[end] = cTemp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {

    Solution solution = new Solution();
    
    String s = "abcdefg";
    int k = 1;
	System.out.printf("convertBST(%s, %d) : %s\n", s, k, solution.reverseStr(s, k));
    
    String s2 = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
    int k2 = 39;
	System.out.printf("convertBST(%s, %d) : %s\n", s2, k2, solution.reverseStr(s2, k2));
  }
}


