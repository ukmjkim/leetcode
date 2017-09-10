public class Solution {
  public int romanToInt(String s) {
    
    int sum = 0;

    // IV : 4,     IX : 9
    // XL : 40,    XC : 90
    // CD : 400,   CM : 900
    if (s.indexOf("IV") != -1) { sum -= 2; }
    if (s.indexOf("IX") != -1) { sum -= 2; }
    if (s.indexOf("XL") != -1) { sum -= 20; }
    if (s.indexOf("XC") != -1) { sum -= 20; }
    if (s.indexOf("CD") != -1) { sum -= 200; }
    if (s.indexOf("CM") != -1) { sum -= 200; }

    for (char c : s.toCharArray()) {
      if (c == 'M') sum += 1000;
      if (c == 'D') sum += 500;
      if (c == 'C') sum += 100;
      if (c == 'L') sum += 50;
      if (c == 'X') sum += 10;
      if (c == 'V') sum += 5;
      if (c == 'I') sum += 1;
    }
    
    return sum;
  }

  public static void main(String[] args) {
    String numStr = "MMMDLXXXVI";
    
    Solution solution = new Solution();
    int result = solution.romanToInt(numStr);
    System.out.println("Result: " + result);
  }
}

