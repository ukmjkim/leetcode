import java.util.*;

public class Solution {
  // Recursive
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) return 0;
    int sum = 0;
    
    if (root.left != null) {
      if (root.left.left == null && root.left.right == null) sum += root.left.val;
      else sum += sumOfLeftLeaves(root.left);
    }
    sum += sumOfLeftLeaves(root.right);
    
    return sum;
  }
  
  // Iterative - Queue
  public int sumOfLeftLeaves2(TreeNode root) {
    if (root == null) return 0;
    
    int sum = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node.left != null && node.left.left == null && node.left.right == null) {
        sum += node.left.val;
      }
      if (node.left != null) queue.offer(node.left);
      if (node.right != null) queue.offer(node.right);
    }
    return sum;
  }


  // Iterative - Stack
  public int sumOfLeftLeaves3(TreeNode root) {
    if (root == null) return 0;
    
    int sum = 0;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      if (node.left != null) {
        if (node.left.left == null && node.left.right == null) {
          sum += node.left.val;
        } else {
          stack.push(node.left);
        }
      }
      if (node.right != null) {
        if (node.right.left != null || node.right.right != null) {
          stack.push(node.right);
        }
      }
    }
    return sum;
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    
    Solution solution = new Solution();
    System.out.println("sum of left leaves: " + solution.sumOfLeftLeaves(root));
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}


