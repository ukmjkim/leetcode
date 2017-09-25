import java.util.*;

public class Solution {
  // find factors of the number
  // apply the rules and find the pair
  public int[] constructRectangle(int area) {
    int[] pair = new int[2];
    
    int w = (int) Math.sqrt(area);
    while (area % w != 0) w--;
    pair[0] = area / w;
    pair[1] = w;

    return pair;
  }
  
  public static void main(String[] args) {
    int num;

    Solution solution = new Solution();
    
    num = 4;
    System.out.printf("constructRectangle(%d)\n", num);    
    System.out.println(Arrays.toString(solution.constructRectangle(num)));    
    System.out.println("");    
    
    num = 15;
    System.out.printf("constructRectangle(%d)\n", num);    
    System.out.println(Arrays.toString(solution.constructRectangle(num)));    
    System.out.println("");    
    
    num = 48;
    System.out.printf("constructRectangle(%d)\n", num);    
    System.out.println(Arrays.toString(solution.constructRectangle(num)));    
    System.out.println("");    
  }
}

