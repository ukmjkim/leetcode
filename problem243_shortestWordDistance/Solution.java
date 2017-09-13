public class Solution {
  public int shortestDistance(String[] words, String word1, String word2) {
    int m = -1;
    int n = -1;
    int min = Integer.MAX_VALUE;
    
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        m = i;
        if (n != -1) {
          min = Math.min(min, m-n);
        }
      } else if (words[i].equals(word2)) {
        n = i;
        if (m != -1) {
          min = Math.min(min, n-m);
        }
      }
    }

    return min;
  }

  public static void main(String[] args) {
    String[] words = {"practice", "makes", "perfect", "coding", "makes"};
    String word1 = "makes";
    String word2 = "coding";

    Solution solution = new Solution();
    int distance = solution.shortestDistance(words, word1, word2);
    System.out.println("Distance between two words: " + distance);

    String word3 = "coding";
    String word4 = "practice";

    int distance2 = solution.shortestDistance(words, word3, word4);
    System.out.println("Distance between two words: " + distance2);
  }
}

