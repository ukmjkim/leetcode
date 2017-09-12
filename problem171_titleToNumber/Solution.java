public class Solution {
  public int titleToNumber(String s) {
    char[] charArray = s.toCharArray();

    int loopNum = 0;
    for (int i = 0; i < charArray.length; i++) {
      loopNum = (loopNum * 26) + (charArray[i] - 'A' + 1);
    }
    return loopNum;
  }
    
  public static void main(String[] args) {
    Solution solution = new Solution();
    
    System.out.println("titleToNumber(C): " + solution.titleToNumber("C"));
    System.out.println("titleToNumber(AB): " + solution.titleToNumber("AB"));
  }
}

