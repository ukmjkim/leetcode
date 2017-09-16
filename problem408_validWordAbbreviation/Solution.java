import java.util.*;

public class Solution {
  public boolean validWordAbbreviation(String word, String abbr) {
    char[] abbrFullChar = new char[word.length()];

    int idx = 0;
    String numStr = "";
    for (int i = 0; i < abbr.length(); i++) {
      if (abbr.charAt(i) >= '0' && abbr.charAt(i) <= '9') {
        numStr += abbr.charAt(i);
      } else {
        if (numStr.length() > 0) {
          int numberOfChar = Integer.parseInt(numStr);

          for (int j = 0; j < numberOfChar; j++) {
            abbrFullChar[idx+j] = ' ';
          }
          numStr = "";
          idx += numberOfChar;
        }
        abbrFullChar[idx] = abbr.charAt(i);
        idx += 1;
      }
    }

    for (int i = 0; i < word.length(); i++) {
      if (abbrFullChar[i] != ' ' && abbrFullChar[i] != word.charAt(i)) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String s;
    String abbr;

    Solution solution = new Solution();

    s = "internationalization";
    abbr = "i12iz4n";
    System.out.printf("validWordAbbreviation(%s, %s): %b", s, abbr, solution.validWordAbbreviation(s, abbr));
  }
}


