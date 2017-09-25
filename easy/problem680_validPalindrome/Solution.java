public class Solution {
  public boolean validPalindrome(String s) {
    int start = 0;
    int end = s.length()-1;
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return isPalindrome(s, start+1, end) || isPalindrome(s, start, end-1);
      }
      start++;
      end--;
    }
    return true;
  }

  public boolean isPalindrome(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) return false;
      start++;
      end--;
    }
    return true;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    String s = "abbca";
    System.out.printf("validPalindrome(%s) : %b\n", s, solution.validPalindrome(s));

    String s2 = "acbcba";
    System.out.printf("validPalindrome(%s) : %b\n", s2, solution.validPalindrome(s2));

    String s3 = "abc";
    System.out.printf("validPalindrome(%s) : %b\n", s3, solution.validPalindrome(s3));

    String s4 = "cbbcc";
    System.out.printf("validPalindrome(%s) : %b\n", s4, solution.validPalindrome(s4));
  }
}
