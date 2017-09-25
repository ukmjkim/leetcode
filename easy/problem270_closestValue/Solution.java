import java.util.*;

public class Solution {
  public int closestValue(TreeNode root, double target) {
    int min = Integer.MAX_VALUE;
    TreeNode cur = root;
    while (cur != null) {
      min = Math.abs(target - min) < Math.abs(target - cur.val) ? min : cur.val;
      cur = target > cur.val ? cur.right : cur.left;
    }
    return min;
  }

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(8);
    bst.insert(1);
    bst.insert(3);
    bst.insert(9);
    bst.insert(7);
    bst.insert(4);
    bst.insert(5);

    bst.display(bst.root);
    System.out.println("");

    Solution solution = new Solution();
    System.out.println("Closest Integer: " + solution.closestValue(bst.root, 2.7));
    System.out.println("Closest Integer: " + solution.closestValue(bst.root, 6.1));
    System.out.println("Closest Integer: " + solution.closestValue(bst.root, 3));
  }
}

class BinarySearchTree {
  TreeNode root;
  
  public BinarySearchTree() {
    root = null;
  }
  
  public void insert(int x) {
    if (root == null) {
      root = new TreeNode(x);
      return;
    }

    TreeNode cur = root;
    while (cur != null) {
      if (cur.val == x) return;
      
      if (cur.val < x) {
        if (cur.right == null) {
          cur.right = new TreeNode(x);
          return;
        }
        cur = cur.right;
      }
      if (cur.val > x) {
        if (cur.left == null) {
          cur.left = new TreeNode(x);
          return;
        }
        cur = cur.left;
      }
    }
  }
  
  public TreeNode find(int x) {
    TreeNode cur = root;
    while (cur != null) {
      if (cur.val == x) return cur;
      
      if (cur.val < x) {
        cur = cur.right;
      }
      if (cur.val > x) {
        cur = cur.left;
      }
    }
    
    return null;
  }
  
  public void display(TreeNode node) {
    if (node != null) {
      System.out.print(" " + node.val);
      display(node.left);
      display(node.right);
    }
  }
}
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { this.val = x; }
}



