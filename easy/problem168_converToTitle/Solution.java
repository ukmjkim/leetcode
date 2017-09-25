public class Solution {
    // Recursion
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }

    // Interative
    public String convertToTitle2(int n) {
        if (n <= 0) return "";
        
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            char ch = (char) (n % 26 + 'A');
            n /= 26;
            sb.append(ch);
        }
        sb.reverse();
        return sb.toString();
    }
    
    public static void main(String[] args) {
        int colNum = 28;

        Solution solution = new Solution();
        String title = solution.convertToTitle(colNum);
        System.out.println("Result: " + title);

        String title2 = solution.convertToTitle2(colNum);
        System.out.println("Result: " + title2);
    }
}
