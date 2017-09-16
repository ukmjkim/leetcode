import java.util.*;

public class Solution {
  public List<String> readBinaryWatch(int num) {
    List<String> times = new ArrayList<>();
    for (int h=0; h<12; h++)
      for (int m=0; m<60; m++)
        if ((Integer.bitCount(h) + Integer.bitCount(m)) == num)
          times.add(String.format("%d:%02d", h, m));
    return times;        
  }
  
  public static void main(String[] args) {
    int num;

    Solution solution = new Solution();
    
    num = 1;
    System.out.printf("findNthDigit(%d)\n", num);
    System.out.print("    ");
    System.out.println(solution.readBinaryWatch(num));

    num = 2;
    System.out.printf("findNthDigit(%d)\n", num);
    System.out.print("    ");
    System.out.println(solution.readBinaryWatch(num));
  }
}

