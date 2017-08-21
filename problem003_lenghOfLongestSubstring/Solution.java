import java.util.*;

public class Solution {
	public int lengthOfLongestSubstringApproach2(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0, maxLength = 0;
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				maxLength = Math.max(ans, j - i);
				if (ans < maxLength) {
					ans = maxLength;
					// System.out.println("Substring found: [" + i + ":" + (i + ans) + "]" + s.substring(i, i+ans));
				}
			} else {
				set.remove(s.charAt(i++));
			}
		}
		System.out.println("Result: " + ans);
		return ans;
	}

	public int lengthOfLongestSubstringApproach3(String s) {
		int n = s.length(), ans = 0;
		boolean hit = false;
		Map<Character, Integer> map = new HashMap<>();
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
				hit = true;
			}
			ans = Math.max(ans, j - i);
			map.put(s.charAt(j), j);
			/*
			if (hit) {
				Set set = map.entrySet();
				Iterator iterator = set.iterator();
				while(iterator.hasNext()) {
					Map.Entry mentry = (Map.Entry) iterator.next();
					System.out.print("["+mentry.getKey() + ":" + mentry.getValue() +"] ");
				}
				System.out.println("");
				hit = false;
			}
			*/
		}
		System.out.println("Result: " + ans);
		return ans;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		long duration1 = 0, duration2 = 0, startTime = 0, endTime = 0;
		int result = 0;
		Scanner sc = new Scanner(System.in);
		while (true) {
			String input = sc.nextLine();
			if (input.length() == 0) break;

			startTime = System.nanoTime();
			result = solution.lengthOfLongestSubstringApproach2(input);
			endTime = System.nanoTime();
			duration1 = endTime - startTime;

			startTime = System.nanoTime();
			result = solution.lengthOfLongestSubstringApproach3(input);
			endTime = System.nanoTime();
			duration2 = endTime - startTime;

			System.out.println("Approach2 Execution Time: " + duration1 + ", Approach3 Execution Time: " + duration2);
		}
		sc.close();
	}
}
