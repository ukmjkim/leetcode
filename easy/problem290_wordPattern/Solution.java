import java.util.*;

public class Solution {
  public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (words.length != pattern.length())
        return false;
    Map<Character, Integer> patterMap = new HashMap<>();
    Map<String, Integer> wordMap = new HashMap<>();
    for (Integer i=0; i<words.length; ++i) {
      if (patterMap.put(pattern.charAt(i), i) != wordMap.put(words[i], i)) {
        return false;
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    String[] patterns = {"abba", "abba", "aaaa", "abba"};
    String[] str = {"dog cat cat dog",
                    "dog cat cat fish",
                    "dog cat cat dog",
                    "dog dog dog dog"};

    Solution solution = new Solution();
    System.out.println("Result: " + solution.wordPattern("abc", "b c a"));
/*
    for (int i = 0; i < patterns.length; i++) {
      for (int j = 0; j < str.length; j++) {
        System.out.println("wordPattern('" + patterns[i] +"', '" + str[j] + "'): "
                         + solution.wordPattern(patterns[i], str[j]));
      }
    }
*/
  }
}


