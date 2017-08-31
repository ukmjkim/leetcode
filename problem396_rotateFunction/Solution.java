public class Solution {
	public int maxRotateFunction(int[] A) {
		int allSum = 0;
		int len = A.length;
		int F = 0;

		for (int i = 0; i < len; i++) {
			F += i * A[i];
			allSum += A[i];
		}

System.out.println("F: " + F);
System.out.println("allSum: " + allSum);

		int max = F;
		for (int i = len - 1; i >= 1; i--) {
			F = F + allSum - len * A[i];
System.out.println("F: " + F + ", len: " + len + ", A[" + i +"]: " + A[i]);
			max = Math.max(F, max);
		}

		return max;
	}

	public static void main(String[] args) {
		int[] A = {4, 3, 2, 6};

		Solution solution = new Solution();
		System.out.println("Result: " + solution.maxRotateFunction(A));
	}
}
