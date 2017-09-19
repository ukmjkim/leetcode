import java.util.*;

public class Solution {
  public String[] findWords(String[] words) {
    String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      for (char c : strs[i].toCharArray()) {
        map.put(c, i);
      }
    }
      
    List<String> result = new LinkedList<>();
    for (int i = 0; i < words.length; i++) {
      String word = words[i].toUpperCase();
      int row = map.get(word.charAt(0));
      for (char c : word.toCharArray()) {
        if (row != map.getOrDefault(c, -1)) {
          row = -1;
          break;
        }
      }
      if (row > -1) {
       result.add(words[i]);
      }
    }

    return result.toArray(new String[0]);
  }
  
  public static void main(String[] args) {

    Solution solution = new Solution();

    String[] words = {"Hello", "Alaska", "Dad", "Peace"};
    System.out.println("findWords()");    
    System.out.println(Arrays.toString(words));      
    System.out.print("==> ");    
    System.out.println(Arrays.toString(solution.findWords(words)));    
    System.out.println("");

    String[] words2 = {"Agg", "Pop", "Ask", "Teet"};
    System.out.println("findWords()");    
    System.out.println(Arrays.toString(words2));      
    System.out.print("==> ");    
    System.out.println(Arrays.toString(solution.findWords(words2)));    
    System.out.println("");
  }
}

