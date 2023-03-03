public class Solution2 {
  public boolean isValidPalindrome(String str) {
    int i = 0;
    int j = str.length()-1;
    boolean dirtybit = false;
    while (i < j) {
      if (str.charAt(i) != str.charAt(j)) {
        if (dirtybit == false && i == j-1) return true;
        if (str.charAt(i) != str.charAt(j-1) && str.charAt(i+1) != str.charAt(j)) return false;
        
        if (str.charAt(i) == str.charAt(j-1)) {
          j--;
          dirtybit = true;
        }

        if (str.charAt(i+1) == str.charAt(j)) {
          i++;
          dirtybit = true;
        }
      }
      i++;
      j--;
    }
    return true;
  }

  public static void main(String[] args) {
    String str;
    boolean isValid;

    Solution solution = new Solution();

    str = "aa";
    isValid = solution.isValidPalindrome(str);
    System.out.printf("Is %s valid palindrome? %b\n", str, isValid);

    str = "aba";
    isValid = solution.isValidPalindrome(str);
    System.out.printf("Is %s valid palindrome? %b\n", str, isValid);

    str = "abca";
    isValid = solution.isValidPalindrome(str);
    System.out.printf("Is %s valid palindrome? %b\n", str, isValid);

    str = "abcca";
    isValid = solution.isValidPalindrome(str);
    System.out.printf("Is %s valid palindrome? %b\n", str, isValid);

    str = "abfcca";
    isValid = solution.isValidPalindrome(str);
    System.out.printf("Is %s valid palindrome? %b\n", str, isValid);
  }
}
