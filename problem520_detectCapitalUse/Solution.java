import java.util.*;

public class Solution {
  public boolean detectCapitalUse(String word) {
    if (word == null || word.length() == 0) return false;

    int CapitalFirst = (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') ? 1 : 0;
    int CapitalRemains = 0;
    for (int i = 1; i < word.length(); i++) {
      if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
        CapitalRemains++;
      }
    }
    return (CapitalFirst+CapitalRemains == word.length() || CapitalRemains == 0) ? true : false;
  }
  
  public static void main(String[] args) {

    Solution solution = new Solution();

    String word = "USA";
    System.out.printf("findRelativeRanks(%s): %b\n", word, solution.detectCapitalUse(word));

    String word2 = "leetcode";
    System.out.printf("findRelativeRanks(%s): %b\n", word2, solution.detectCapitalUse(word2));

    String word3 = "Google";
    System.out.printf("findRelativeRanks(%s): %b\n", word3, solution.detectCapitalUse(word3));

    String word4 = "FlaG";
    System.out.printf("findRelativeRanks(%s): %b\n", word4, solution.detectCapitalUse(word4));
  }
}



