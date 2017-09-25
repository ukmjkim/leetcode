import java.util.*;

public class Solution {
  public void merge(int A[], int m, int B[], int n) {
    int i=m-1, j=n-1, k=m+n-1;
    
    while (i > -1 && j > -1) {
      A[k--] = (A[i] > B[j]) ? A[i--] : B[j--];
    }
    while (j > -1){
      A[k--] = B[j--];
    }
  }

  
  // This solution has problem, java is call-by-value for parameter passing.
  // Array A has been changed since new int[m+n]. It must return the new array address.
  // The question mentioned that the length is enough for m+n
  // I made the function having return value 
  public int[] merge2(int A[], int m, int B[], int n) {
    int i=m-1, j=n-1, k=m+n-1;
    
    int[] temp = A.clone();
    A = new int[m+n];
    System.arraycopy(temp, 0, A, 0, temp.length);

    while (i > -1 && j > -1) {
      A[k--] = (A[i] > B[j]) ? A[i--] : B[j--];
    }
    while (j > -1){
      A[k--] = B[j--];
    }
    
    return A;
  }
  
  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
    int[] nums2 = {10, 20, 30, 40, 50, 60, 70, 80};

    Solution solution = new Solution();
    solution.merge(nums1, 3, nums2, 2);
    System.out.println(Arrays.toString(nums1));

    int[] result = solution.merge2(nums1, 3, nums2, 6);
    System.out.println(Arrays.toString(result));
  }
}
