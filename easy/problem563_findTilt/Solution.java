public class Solution {
  int sum = 0;

  public int findTilt(TreeNode root) {
    helper(root);
    return sum;
  }

  public int helper(TreeNode root) {
    if (root == null) return 0;

    int left = helper(root.left);
    int right =  helper(root.right);

    sum += Math.abs(left - right);

    return left + right + root.val;
  }

  private static TreeNode generateBT() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    return root;
  }

  private static void display(TreeNode root, int depth) {
    if (root != null) {
      System.out.printf(" depth[%d] = %d ", depth, root.val);
      display(root.left, depth+1);
      display(root.right, depth+1);
    }
  }
  public static void main(String[] args) {
    TreeNode root = generateBT();
    display(root, 0);
    System.out.println("");

    Solution solution = new Solution();
    System.out.printf("findTilt() : %d\n", solution.findTilt(root));
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { this.val = x; }
}

