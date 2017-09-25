import java.util.*;

public class Solution {
  // Recursive
  public int maxDepth2(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }

  // Iterative
  public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    
    int depth = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int curLevel = 1;
    int nextLevel = 0;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      curLevel--;
      if (node.left != null) {
        queue.offer(node.left);
        nextLevel++;
      }
      if (node.right != null) {
        queue.offer(node.right);
        nextLevel++;
      }
      if (curLevel == 0) {
        curLevel = nextLevel;
        nextLevel = 0;
        depth++;
      }
    }
    return depth;
  }

  public static void main(String[] args) {
    TreeNode head = new TreeNode(1);
    TreeNode newNode = new TreeNode(2);
    head.left = newNode;
    newNode = new TreeNode(2);
    head.right = newNode;
    newNode = new TreeNode(3);
    head.left.left = newNode;
    newNode = new TreeNode(3);
    head.right.right = newNode;

    Solution solution = new Solution();
    int result = solution.maxDepth(head);
    System.out.println("Result: " + result);

    int result2 = solution.maxDepth2(head);
    System.out.println("Result: " + result2);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

