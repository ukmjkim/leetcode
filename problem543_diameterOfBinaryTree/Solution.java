import java.util.*;

public class Solution {
  int max = 0;
  public int diameterOfBinaryTree(TreeNode root) {
    maxDepth(root);
    return max;
  }

  private int maxDepth(TreeNode root) {
    if (root == null) return 0;

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    max = Math.max(max, left + right);

    // the height of left tree + the height of right tree + 1 (root itself)
    return Math.max(left, right) + 1;
  }

  public int diameterOfBinaryTree2(TreeNode root) {
    int res = 0;
    if (root == null) return res;

    int cur = maxDepth2(root.left) + maxDepth2(root.right);
    int left = diameterOfBinaryTree2(root.left);
    int right = diameterOfBinaryTree2(root.right);

    return Math.max(cur, Math.max(left, right));
  }

  public int maxDepth2(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right));
  }

  private static TreeNode generateBT(int[] nums) {
    if (nums.length == 0) return null;

    Queue<TreeNode> queue = new LinkedList<>();

    TreeNode root = new TreeNode(nums[0]);
    queue.offer(root);

    int i = 1;
    while (i < nums.length) {
      TreeNode parent = queue.poll();
      TreeNode newNode = new TreeNode(nums[i]);
      parent.left = newNode;
      i++;
      if (i == nums.length) {
        break;
      }

      newNode = new TreeNode(nums[i]);
      parent.right = newNode;
      i++;

      queue.offer(parent.left);
      queue.offer(parent.right);
    }

    return root;
  }

  private static void display(TreeNode root, int depth) {
    if (root != null) {
      display(root.left, depth+1);
      System.out.printf("depth[%d]: %d ", depth, root.val);
      display(root.right, depth+1);
    }
  }
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5};
    TreeNode root = generateBT(nums);
    display(root, 0);
    System.out.println("");

    Solution solution = new Solution();
    System.out.printf("diameterOfBinaryTree() = %d\n", solution.diameterOfBinaryTree(root));
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { this.val = x; }
}

