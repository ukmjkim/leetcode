public class Solution {
	public boolean isAnagram(String s, String t) {
		int[]  alphabat = new int[26];
		char[] arr1 = s.toCharArray();
		char[] arr2 = t.toCharArray();
		for (int i = 0; i < arr1.length; i++) {
			int idx = arr1[i] - 'a';
			alphabat[idx] += 1;
		}
		for (int i = 0; i < arr2.length; i++) {
			int idx = arr2[i] - 'a';
			alphabat[idx] -= 1;
		}
		for (int i = 0; i < 26; i++) {
			if (alphabat[i] != 0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		String s = "anagramdd";
		String t = "nagaram";

		Solution solution = new Solution();
		System.out.println("isAnagram(" + s + ", " + t + ") is " + solution.isAnagram(s, t));
	}
}
