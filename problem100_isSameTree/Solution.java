import java.util.*;

public class Solution {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    if (p.val == q.val) {
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    return false;
  }
 
  public static void main(String[] args) {
    TreeNode head1 = new TreeNode(1);
    TreeNode newNode = new TreeNode(2);
    head1.left = newNode;
    newNode = new TreeNode(3);
    head1.right = newNode;

    TreeNode head2 = new TreeNode(1);
    newNode = new TreeNode(2);
    head2.left = newNode;
    newNode = new TreeNode(3);
    head2.right = newNode;

    Solution solution = new Solution();
    boolean result = solution.isSameTree(head1, head2);
    System.out.println("Result: " + result);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}


