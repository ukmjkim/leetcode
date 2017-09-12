public class Solution {
  public boolean isPalindrome(String s) {
    if (s.isEmpty()) return true;
    
    int head = 0;
    int tail = s.length() - 1;
    char cHead, cTail;
    while (head <= tail) {
      cHead = s.charAt(head);
      cTail = s.charAt(tail);
      
      if (!Character.isLetterOrDigit(cHead)) {
        head++;
      } else if (!Character.isLetterOrDigit(cTail)) {
        tail--;
      } else {
        if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
          return false;
        }
        head++;
        tail--;
      }
    }

    return true;
  }
  
  public static void main(String[] args) {
    String input = "A man, a plan, a canal: Panama";
    
    Solution solution = new Solution();
    System.out.println("Result: " + solution.isPalindrome(input));

    String input2 = "race a car";
    System.out.println("Result: " + solution.isPalindrome(input2));
  }
}

