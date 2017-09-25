import java.util.*;

public class Solution {
  TreeSet<Integer> set = new TreeSet<>();
  int min = Integer.MAX_VALUE;
  Integer prev = null;

  
  // BST inOrder traverse
  public int getMinimumDifference(TreeNode root) {
    if (root == null) return min;
    
    getMinimumDifference(root.left);
    
    if (prev != null) {
      min = Math.min(min, root.val - prev);
    }
    prev = root.val;

    getMinimumDifference(root.right);
    
    return min;
  }

  // Not BST Pre-Order traverse
  public int getMinimumDifference2(TreeNode root) {
    if (root == null) return min;
    
    if (!set.isEmpty()) {
      if (set.floor(root.val) != null) {
        min = Math.min(min, root.val - set.floor(root.val));
      }
      if (set.ceiling(root.val) != null) {
        min = Math.min(min, set.ceiling(root.val) - root.val);
      }
    }
    set.add(root.val);

    getMinimumDifference2(root.left);
    getMinimumDifference2(root.right);

    return min;
  }
  
  public static void main(String[] args) {
    int[] nums = {1, 2, 3};

    BinarySearchTree bst = new BinarySearchTree();
    for (int i = 0; i < nums.length; i++) {
      bst.insert(nums[i]);
    }
    bst.display(bst.root);

    Solution solution = new Solution();
    System.out.printf("\ngetMinimumDifference(): %d\n", solution.getMinimumDifference(bst.root));
    solution.prev = null;
    System.out.printf("\ngetMinimumDifference2(): %d\n", solution.getMinimumDifference2(bst.root));
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
      System.out.print(" " + root.val);
      display(root.left);
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


