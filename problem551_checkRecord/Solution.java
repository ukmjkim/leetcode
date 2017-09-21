public class Solution {
  public boolean checkRecord(String s) {
    boolean absentFlag = false;
    boolean lateFlag = true;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'A') {
        if (absentFlag == true) return false;
        absentFlag = true;
      }
      if (c == 'L') {
        if (i > 0 && s.charAt(i-1) == 'L') {
          if (lateFlag == true) return false;
          lateFlag = true;
        } else {
          lateFlag = false;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    String s = "PPALLP";
    System.out.printf("checkRecord(%s) : %b\n", s, solution.checkRecord(s));
    String s2 = "PPALLL";
    System.out.printf("checkRecord(%s) : %b\n", s2, solution.checkRecord(s2));
  }
}
