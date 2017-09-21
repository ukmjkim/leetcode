import java.util.*;

public class Solution {
  public String reverseWords(String s) {
    char[] cArray = s.toCharArray();
    int start = 0;
    for (int i = 0; i < cArray.length; i++) {
      if (cArray[i] == ' ') {
        reverse(cArray, start, i-1);
        start = i+1;
      }
    }
    if (start < cArray.length) {
      reverse(cArray, start, cArray.length-1);
    }

    return new String(cArray);
  }

  private void reverse(char[] cArray, int start, int end) {
    if (start == end) return;
    while (start <= end) {
      char tempC = cArray[start];
      cArray[start] = cArray[end];
      cArray[end] = tempC;
      start++;
      end--;
    }
    return;
  }
  public static void main(String[] args) {
    Solution solution = new Solution();

    String s = "Let's take LeetCode contest";
    System.out.printf("reverseWords(%s) : %s\n", s, solution.reverseWords(s));
  }
}
