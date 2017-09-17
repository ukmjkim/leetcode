import java.util.*;

public class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> list = new ArrayList<>();
    if (p.length() > s.length()) return list;

    Map<Character, Integer> map = new HashMap<>();
    for (Character c : p.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) +1);
    }
    int counter = map.size();
    
    int begin = 0, end = 0;
    int len = Integer.MAX_VALUE;

    while (end < s.length()) {
      char c = s.charAt(end);

      if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0) counter--;
      }
      end++;

      while (counter == 0) {
        char tempc = s.charAt(begin);
        if (map.containsKey(tempc)) {
          map.put(tempc, map.get(tempc) + 1);
          if (map.get(tempc) > 0) counter++;
        }

        if (end-begin == p.length()) {
          list.add(begin);
        }

        begin++;
      }
    }

    return list;
  }

  public static void main(String[] args) {
    String s;
    String p;

    Solution solution = new Solution();

    s = "cbaebabacd";
    p = "abc";
    System.out.printf("findAnagrams(%s, %s)\n", s, p);
    System.out.println(solution.findAnagrams(s, p));

    s = "cbba";
    p = "abc";
    System.out.printf("findAnagrams(%s, %s)\n", s, p);
    System.out.println(solution.findAnagrams(s, p));

    s = "abab";
    p = "ab";
    System.out.printf("findAnagrams(%s, %s)\n", s, p);
    System.out.println(solution.findAnagrams(s, p));

    s = "aa";
    p = "bb";
    System.out.printf("findAnagrams(%s, %s)\n", s, p);
    System.out.println(solution.findAnagrams(s, p));

    s = "baaa";
    p = "aaa";
    System.out.printf("findAnagrams(%s, %s)\n", s, p);
    System.out.println(solution.findAnagrams(s, p));
  }
}

