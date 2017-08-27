import java.util.*;

public class Solution {
	public List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>(wordDict);

		List<String> res = new ArrayList<String>();
		if (dict.contains(s)) {
			res.add(s);
			return res;
		}

		Map<Integer, List<String>> graph = new HashMap<Integer, List<String>>();

		bfs(graph, s, dict);
		System.out.println(graph);

		List<String> path = new ArrayList<String>();
		dfs(res, path, s.length(), graph, s);

		System.out.println(path);

		return res;
	}

	public static void bfs(Map<Integer, List<String>> graph, String s, Set<String> dict) {

		for (int i = 0; i < s.length() + 1; i++) {
			graph.put(i, new ArrayList<String>());
		}

		Set<String> visited = new HashSet<String>();

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(0);
		while (!queue.isEmpty()) {
			int curIdx = queue.poll();
			for (int i = curIdx+1; i <= s.length(); i++) {
				if (visited.contains(s.substring(curIdx, i))) continue;

				if (dict.contains(s.substring(curIdx, i))) {
					graph.get(i).add(s.substring(curIdx, i));
					queue.offer(i);
					visited.add(s.substring(curIdx, i));
				}
			}
		}
	}

	public static void dfs(List<String> res, List<String> path, int start, Map<Integer, List<String>> graph, String s) {
		if (start == 0) {
			res.add(path.toString());
			return;
		}

// System.out.print(start + ": ");
		for (String word : graph.get(start)) {
			path.add(0, word);
// System.out.println(path);
			start = start - (word.length() - 1);
			dfs(res, path, start-1, graph, s);
		}
	}
 
	public static void main(String[] args) {
		String fullString = "catsanddog";
		List<String> wordDict = new ArrayList<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
		Solution solution = new Solution();
		List<String> sentenceList = solution.wordBreak(fullString, wordDict);
		System.out.println(sentenceList);
	}
}
