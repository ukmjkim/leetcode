public class Solution {
  public String longestCommonPrefix(String[] strArray) {
    if (strArray == null || strArray.length == 0) return "";
    
    String pre = strArray[0];
    for (int i = 1; i < strArray.length; i++) {
      while (strArray[i].indexOf(pre) != 0) {
        pre = pre.substring(0, pre.length()-1);
      }
    }
    return pre;
  }

  public static void main(String[] args) {
    String[] strArray = {"abcdef", "abcd", "abcde"};
    
    Solution solution = new Solution();
    String result = solution.longestCommonPrefix(strArray);
    System.out.println("Result: " + result);
  }
}

