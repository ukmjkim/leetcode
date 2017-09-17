import java.util.*;

public class Solution {
  public List<String> fizzBuzz(int num) {
	List<String> list = new LinkedList<>();
    for (int i = 1; i <= num; i++) {
      if ((i % 3 == 0) && (i % 5 == 0)) {
        list.add("FizzBuzz");
      } else if (i % 3  == 0) {
        list.add("Fizz");
      } else if (i % 5  == 0) {
        list.add("Buzz");
      } else {
        list.add(String.valueOf(i));
      }
    }
    
    return list;
  }

  public static void main(String[] args) {
    int num;

    Solution solution = new Solution();

    num = 15;
    System.out.printf("fizzBuzz(%d)\n", num);
    System.out.println(solution.fizzBuzz(num));
	System.out.printf("\n\n");

    num = 21;
    System.out.printf("fizzBuzz(%d)\n", num);
    System.out.println(solution.fizzBuzz(num));
	System.out.printf("\n\n");
  }
}

