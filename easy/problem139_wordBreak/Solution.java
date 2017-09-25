import java.util.*;

public class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
					System.out.println("[" + j + ":" + i + "]" + s.substring(j, i) + " HIT");
                    f[i] = true;
                    break;
                } else {
					System.out.println("[" + j + ":" + i + "]" + s.substring(j, i) + " MISS");
				}
            }
        }
		return f[s.length()];
	}

	public static void main(String[] args) {
		String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
		Solution solution = new Solution();
		List<String> strList = new ArrayList<String>(Arrays.asList(wordDict));
		boolean result = solution.wordBreak("catsanddog", strList);
	}
}
