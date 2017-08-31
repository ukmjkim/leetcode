public class Solution {
	public int firstUniqChar(String s) {
		int[] table = new int[26];
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			int index = charArray[i] - 'a';
			table[index] ++;
		}
		for (int i = 0; i < 26; i++) {
			if (table[i] == 1) return i;
		}

		return -1;
	}

	public static void main(String[] args) {
		String input = "loveleetcode";

		Solution solution = new Solution();
		int result = solution.firstUniqChar(input);
		System.out.println("First Unique Char: " + result);
	}
}
