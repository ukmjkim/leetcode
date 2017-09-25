import java.util.*;

public class Solution {
  public boolean validWordSquare(List<String> words) {
    if (words == null || words.size() == 0) return true;
    
    int n = words.size();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < words.get(i).length(); j++) {
        if (j >= n || words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j))
          return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    List<String> words = new LinkedList<>();
 
    Solution solution = new Solution();

    words.add("abcd");
    words.add("bnrt");
    words.add("crmy");
    words.add("dtye");
    System.out.println(words.toString());
    System.out.printf("\tvalidWordSquare: %b\n", solution.validWordSquare(words));
	words.clear();
    

    words.add("abcd");
    words.add("bnrt");
    words.add("crm");
    words.add("dt");
    System.out.println(words.toString());
    System.out.printf("\tvalidWordSquare: %b\n", solution.validWordSquare(words));
	words.clear();

    words.add("ball");
    words.add("area");
    words.add("read");
    words.add("lady");
    System.out.println(words.toString());
    System.out.printf("\tvalidWordSquare: %b\n", solution.validWordSquare(words));
	words.clear();
  }
}


