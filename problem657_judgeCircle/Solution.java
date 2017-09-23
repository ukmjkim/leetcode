public class Solution {
  public boolean judgeCircle(String moves) {
    int h = 0;
    int v = 0;
    for (char c : moves.toCharArray()) {
      if (c == 'U') v++;
      if (c == 'D') v--;
      if (c == 'R') h++;
      if (c == 'L') h--;
    }
    return v == 0 && h == 0;
  }
  public static void main(String[] args) {
    Solution solution = new Solution();

    String moves = "LL";
    System.out.printf("judgeCircle(%s) : %b\n", moves, solution.judgeCircle(moves));
  }
}

