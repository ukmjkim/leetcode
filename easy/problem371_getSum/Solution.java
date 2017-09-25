public class Solution {
  public int getSum(int a, int b) {
    if (a == 0) return b;
    if (b == 0) return a;
    
    while (b != 0) {
      int carry = a & b;
      a = a ^ b;
      b = carry << 1;
System.out.printf("a: %d[%s], b: %d[%s], carry: %d[%s]\n", 
                 a, Integer.toBinaryString(a), b, Integer.toBinaryString(b),
                 carry, Integer.toBinaryString(carry));
    }
    return a;
  }

  // Recursive
  public int getSum2(int a, int b) {
    return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
  }

  // Iterative
  public int getSubtract(int a, int b) {
    while (b != 0) {
      int borrow = (~a) & b;
      a = a ^ b;
      b = borrow << 1;
    }
	
    return a;
  }

  // Recursive
  public int getSubtract2(int a, int b) {
    return (b == 0) ? a : getSubtract(a ^ b, (~a & b) << 1);
  }

  public static void main(String[] args) {
    
    Solution solution = new Solution();

    int a = 4;
    int b = 7;
    System.out.printf("getSum(%d, %d) = %d\n", a, b, solution.getSum(a, b));

    a = 2;
    b = 3;
    System.out.printf("getSum(%d, %d) = %d\n", a, b, solution.getSum(a, b));

    a = 11;
    b = 6;
    System.out.printf("getSubtract(%d, %d) = %d\n", a, b, solution.getSubtract(a, b));

    a = 20;
    b = 5;
    System.out.printf("getSubtract(%d, %d) = %d\n", a, b, solution.getSubtract2(a, b));
  }
}


