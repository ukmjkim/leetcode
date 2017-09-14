import java.util.*;

public class Solution {
  public boolean canPermutePalindrome (String s) {
    if (s == null) return false;
    
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (set.contains(c)) {
        set.remove(c);
      } else {
        set.add(c);
      }
    }
    
    return set.size() <= 1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println("canPermutePalindrome(carerac) " + solution.canPermutePalindrome("carerac"));
    System.out.println("canPermutePalindrome(code) " + solution.canPermutePalindrome("code"));
    System.out.println("canPermutePalindrome(aab) " + solution.canPermutePalindrome("aab"));
  }
}


