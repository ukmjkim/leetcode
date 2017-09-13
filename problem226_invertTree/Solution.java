import java.util.*;

public class Solution {
  // DFS
  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    
    final TreeNode left = root.left;
    final TreeNode right = root.right;
    
    root.left = invertTree(right);
    root.right = invertTree(left);
    
    return root;
  }

  // BFS - Using Stack
  public TreeNode invertTree2(TreeNode root) {
    if (root == null) return null;
    
    final Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    
    while (!stack.isEmpty()) {
      final TreeNode node = stack.pop();
      final TreeNode temp = node.left;
      node.left = node.right;
      node.right = temp;
      
      if (node.left != null) {
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }
    return root;
  }

  // BFS - level order traversal
  public TreeNode invertTree3(TreeNode root) {
    if (root == null) return null;
    
    final Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
      final TreeNode node = queue.poll();
      final TreeNode temp = node.left;
      node.left = node.right;
      node.right = temp;
      
      if (node.left != null) {
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
    }
    
    return root;
  }

  private static TreeNode generateTree() {
    TreeNode head = new TreeNode(4);
    
    TreeNode newOne = new TreeNode(2);
    head.left = newOne;
    newOne = new TreeNode(7);
    head.right = newOne;

    newOne = new TreeNode(1);
    head.left.left = newOne;
    newOne = new TreeNode(3);
    head.left.right = newOne;

    newOne = new TreeNode(6);
    head.right.left = newOne;
    newOne = new TreeNode(9);
    head.right.right = newOne;

    return head;
  }

  private static void display(TreeNode head) {
    if (head != null) {
      System.out.print(" " + head.val);
      display(head.left);
      display(head.right);
    }
  }

  public static void main(String[] args) {
    TreeNode head = generateTree();
    display(head);
	System.out.println("");

    Solution obj = new Solution();
    obj.invertTree(head);
    display(head);
	System.out.println("");

    obj.invertTree2(head);
    display(head);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode (int x) { this.val = x; }
}
