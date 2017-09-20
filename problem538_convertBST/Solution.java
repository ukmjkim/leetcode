import java.util.*;

public class Solution {
  int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    if (root == null) return null;
    
    convertBST(root.right);
    root.val = root.val + sum;
    sum = root.val;
    convertBST(root.left);

    return root;
  }
  
  private static void printTree(TreeNode node) {
    if (node != null) {
      printTree(node.left);
      System.out.print(" " + node.val);
      printTree(node.right);
    } 
  }

  public static void main(String[] args) {
    int[] nums = {5, 2, 13};

    BinarySearchTree bst = new BinarySearchTree();
    for (int i = 0; i < nums.length; i++) {
      bst.insert(nums[i]);
    }
    bst.display(bst.root);
	System.out.println("");

    Solution solution = new Solution();
    
    TreeNode node = solution.convertBST(bst.root);
    printTree(node);
	System.out.println("");
  }
}

class BinarySearchTree {
  TreeNode root;
  
  public void BinarySearchTree() {
    this.root = null;
  }
  
  public void insert(int x) {
    TreeNode newNode = new TreeNode(x);
    if (root == null) {
      root = newNode;
      return;
    }
    
    TreeNode cur = root;
    while (cur != null) {
      if (x <= cur.val) {
        if (cur.left == null) {
          cur.left = newNode;
          return;
        }
        cur = cur.left;
      } else if (x > cur.val) {
        if (cur.right == null) {
          cur.right = newNode;
          return;
        }
        cur = cur.right;
      }
    }
  }
  
  public void display(TreeNode root) {
    if (root != null) {
      display(root.left);
      System.out.print(" " + root.val);
      display(root.right);
    }
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { this.val = x; }
}



