public class Solution {
  public String reverseString(String str) {
    char[] charArray = str.toCharArray();
    int start = 0;
    int end = charArray.length - 1;
    while (start < end) {
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
    System.out.printf("reverseString(%s): %s\n", str, solution.reverseString(str));

    str = "morning";
    System.out.printf("reverseString(%s): %s\n", str, solution.reverseString(str));
  }
}

