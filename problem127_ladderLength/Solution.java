import java.util.*;

public class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (beginWord.equals(endWord)) return 1;
		Set<String> set = new HashSet<>(wordList);
		Queue<String> q = new LinkedList<>();

		int len = 1;
		q.offer(beginWord);
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String curr = q.poll();
				for (int j=0; j < curr.length(); j++) {
					StringBuilder sb = new StringBuilder(curr);
					for (char c = 'a'; c <= 'z'; c++) {
						sb.setCharAt(j, c);
						String tmp = sb.toString();
						if (set.contains(tmp)) {
							len ++;
							if (tmp.equals(endWord)) return len;
							q.offer(tmp);
							set.remove(tmp);
							j = curr.length();
							break;
						}
					}
				}
			}
		}
		return 0;	
	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<String>(Arrays.asList("hot", "dot", "aot", "dog", "lot", "log", "cog"));
		Solution solution = new Solution();
		int result = solution.ladderLength(beginWord, endWord, wordList);
		System.out.println("The length of ladder worlds: " + result);
	}
}
