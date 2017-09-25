import java.util.*;

public class Solution {
	public String frequencySort(String s) {
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
			max = Math.max(max, map.get(c));
		}


		String[] bucket = new String[max + 1];
		for (char key : map.keySet()) {
			int frequency = map.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = "" + key;
			} else {
				bucket[frequency] = bucket[frequency] + key;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int pos = bucket.length - 1; pos >= 0; pos--) {
			if (bucket[pos] != null) {
				for (char alphabet : bucket[pos].toCharArray()) {
					for (int i = 0; i < pos; i++) {
						sb.append(alphabet);
					}
				}
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String input = "cabb";
		Solution solution = new Solution();
		System.out.println("Result : " + solution.frequencySort(input));		
	}
}
