import java.util.*;

public class Solution {
  public int findSecondMinimumValue(TreeNode root) {
    if (root == null) return 0;

    int min = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node.val < min) {
        // node = 2, min = 3, min2 = 4
        min2 = min;
        min = node.val;
      } else  if (node.val > min && node.val < min2) {
        // node = 3, min = 2, min2 = 4
        min2 = node.val;
      }
      if (node.left != null) queue.offer(node.left);
      if (node.right != null) queue.offer(node.right);
    }

    return min2 == Integer.MAX_VALUE ? -1 : min2;
  }

  public static String tree2str(TreeNode root) {
    if (root == null) return "";

    String result = root.val + "";
    String left = tree2str(root.left);
    String right = tree2str(root.right);

    if (left == "" && right == "") return result;
    if (left == "") return result + "()" + "(" + right + ")";
    if (right == "") return result + "(" + left + ")";
    return result + "(" + left + ")" + "(" + right + ")";
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    //root.right.left = new TreeNode(5);
    //root.right.right = new TreeNode(7);

    System.out.println(tree2str(root));

    Solution solution = new Solution();
    System.out.printf("findSecondMinimumValue(root) : %d\n", solution.findSecondMinimumValue(root));
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
