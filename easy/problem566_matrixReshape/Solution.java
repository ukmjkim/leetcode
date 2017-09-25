import java.util.*;

public class Solution {
  public int[][] matrixReshape(int[][] nums, int r, int c) {
    // Case 2: 4 -> (2, 4) -> maxRow = 2, maxCol = 2
    // Case 3: 20 -> (4, 5) -> maxRow = 4, maxCol = 5
    int numOfElements = nums.length * nums[0].length;

    if (numOfElements < r*c) return nums;

    int maxRow = (numOfElements < r) ? numOfElements : r;
    int maxCol = (numOfElements % maxRow) > 0 ? numOfElements/maxRow+1 : numOfElements/maxRow;

    int[][] result = new int[maxRow][maxCol];

    // numOfElements: 4, maxRow: 1, maxCol:4
    // 0,0 -> 0 -> 0, 0
    // 0,1 -> 1 -> 0, 1
    // 1,0 -> 2 -> 1, 0
    // 1,1 -> 3 -> 1, 1
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums[0].length; j++) {
        int sequenceNum = (i*nums[0].length) + j;
        int newRow = sequenceNum / maxCol;
        int newCol = sequenceNum % maxCol;
        result[newRow][newCol] = nums[i][j];
      }
    }

    return result;
  }

  private static String arrayToString(int[][] nums) {
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < nums.length; i++) {
      sb.append(Arrays.toString(nums[i]));
    }
    sb.append("]");
    return sb.toString();
  }

  public static void main(String[] args) {

    Solution solution = new Solution();

    int[][] nums = {{1, 2}, {3, 4}};
    int r = 1;
    int c = 4;
    int[][] result = solution.matrixReshape(nums, r, c);
    System.out.printf("matrixReshape(%s, %d, %d) ==> %s\n", arrayToString(nums), r, c, arrayToString(result));

    int[][] nums2 = {{1, 2}, {3, 4}};
    int r2 = 2;
    int c2 = 4;
    int[][] result2 = solution.matrixReshape(nums2, r2, c2);
    System.out.printf("matrixReshape(%s, %d, %d) ==> %s\n", arrayToString(nums2), r2, c2, arrayToString(result2));

    int[][] nums3 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};
    int r3 = 42;
    int c3 = 5;
    int[][] result3 = solution.matrixReshape(nums3, r3, c3);
    System.out.printf("matrixReshape(%s, %d, %d) ==> %s\n", arrayToString(nums3), r3, c3, arrayToString(result3));
  }
}

