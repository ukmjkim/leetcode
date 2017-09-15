import java.util.*;

public class Solution {
  public String reverseVowels(String str) {
    Set<Character> vowels = new HashSet<>();
    vowels.add('a');
    vowels.add('A');
    vowels.add('e');
    vowels.add('E');
    vowels.add('i');
    vowels.add('I');
    vowels.add('o');
    vowels.add('O');
    vowels.add('u');
    vowels.add('U');
    
    char[] charArray = str.toCharArray();
    int start = 0;
    int end = charArray.length - 1;
    while (start < end) {
      while (start < (charArray.length - 1) && !vowels.contains(charArray[start])) {
        start++;
      }
      while (end >= 0 && !vowels.contains(charArray[end])) {
        end--;
      }
      if (start > end) break;

      char temp = charArray[start];
      charArray[start] = charArray[end];
      charArray[end] = temp;
      start++;
      end--;
    }

    return new String(charArray);
  }

  public static void main(String[] string) {
    Solution solution = new Solution();
    String str = "hello";
    System.out.printf("reverseString(%s): %s\n", str, solution.reverseVowels(str));

    str = "aA";
    System.out.printf("reverseString(%s): %s\n", str, solution.reverseVowels(str));
  }
}


