public class Solution {
  public int reverseBits(int n) {
    if (n == 0) return 0;
    
    int result = 0;
    for (int i = 0; i < 32; i++) {
        result <<= 1;
        if ((n & 1) == 1) result++;
        n >>= 1;
    }
    return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println("reverseBits(3): " + Integer.toBinaryString(solution.reverseBits(3)));
    System.out.println("reverseBits(5): " + Integer.toBinaryString(solution.reverseBits(5)));
    System.out.println("reverseBits(7): " + Integer.toBinaryString(solution.reverseBits(7)));
  }
}

