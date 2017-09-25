import java.util.*;

public class Solution {
  // Recursive
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new LinkedList<>();
    if (root == null) return paths;
    
    if (root.left == null && root.right == null) {
      paths.add(root.val+"");
      return paths;
    }
    
    for (String path : binaryTreePaths(root.left)) {
      paths.add(root.val + "->" + path);
    }
    for (String path : binaryTreePaths(root.right)) {
      paths.add(root.val + "->" + path);
    }

    return paths;
  }

  // BFS + Queue
  public List<String> binaryTreePaths2(TreeNode root) {
    List<String> paths = new ArrayList<>();
    if (root == null) return paths;
    
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<String> path = new LinkedList<>();
    path.offer(root.val + "");
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      String item = path.poll();
      if (cur.left == null && cur.right == null) {
        paths.add(item);
        continue;
      }
      if (cur.left != null) {
        queue.offer(cur.left);
        path.offer(item + "->" + cur.left.val);
      }
      if (cur.right != null) {
        queue.offer(cur.right);
        path.offer(item + "->" + cur.right.val);
      }
    }
        
    return paths;
  }

  private static TreeNode generateTreeNode() {
    TreeNode head = new TreeNode(1);
    TreeNode newNode = new TreeNode(2);
    head.left = newNode;
    newNode = new TreeNode(5);
    head.left.right = newNode;
    newNode = new TreeNode(3);
    head.right = newNode;
    
    return head;
  }

  public static void main(String[] args) {
    TreeNode head = generateTreeNode();

    Solution solution = new Solution();
    System.out.println("Result " + solution.binaryTreePaths(head));
    System.out.println("Result " + solution.binaryTreePaths2(head));
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { this.val = x; }
}


