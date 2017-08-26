import java.util.*;

public class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);

		wordSet.add(beginWord);
		List<List<String>> res = new ArrayList<List<String>>();
		if (!wordSet.contains(endWord)) {
			return 1;
		}

		List<String> path = new ArrayList<String>();
		Map<String, List<String>> graph = new HashMap<String, List<String>>();
		Map<String, Integer> dist = new HashMap<>();

		bfs(graph, dist, beginWord, endWord, wordSet);

		int shortestDepth = 0;
		for (String str : dist.keySet()) {
			shortestDepth = Math.max(shortestDepth, dist.get(str));
		}

		return shortestDepth + 1;
	}

	public static void bfs(Map<String, List<String>> graph, Map<String, 
                    Integer> dist, String beginWord, 
                    String endWord, Set<String> wordSet) {

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        dist.put(beginWord, 0);

        for (String w: wordSet) {
            graph.put(w, new ArrayList<String>());
        }

        while (!queue.isEmpty()) {
            String word = queue.poll();
            List<String> neighbors = getNeighbors(word, wordSet);
            for (String neighbor: neighbors) {
                graph.get(neighbor).add(word);
                if (!dist.containsKey(neighbor)) {
                    dist.put(neighbor, dist.get(word) + 1);
                    queue.offer(neighbor);
                }
            }
        }


		for (String str : graph.keySet()) {
			System.out.println(str + ": " + graph.get(str));
		}

        System.out.println();

		for (String str : dist.keySet()) {
			System.out.println(str + ": " + dist.get(str));
		}

    }

	static List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'a'; ch < 'z' + 1; ch++) {
                char[] chs = word.toCharArray();
                if (ch != chs[i]) {
                    chs[i] = ch;
                    String next = new String(chs);
                    //System.out.println(next);
                    if (wordSet.contains(next)) {
                        res.add(next);
                    }
                }
            }
        }
        return res;
    }


	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<String>(Arrays.asList("hot", "dot", "aot", "dog", "lot", "log", "cog"));
		Solution solution = new Solution();
		int ladderLength = solution.ladderLength(beginWord, endWord, wordList);
		System.out.println("Shortest Depth: " + ladderLength);
	}
}
