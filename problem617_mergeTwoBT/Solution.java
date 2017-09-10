import java.util.*;

public class Solution {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null)  return null;
    
    int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
    TreeNode newNode = new TreeNode(val);

    newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
    newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
    
    return newNode;
  }

  public static void main(String[] args) {
    BinaryTree bt1 = new BinaryTree();
    bt1.insertRoot(1);
    bt1.insertLeft(bt1.root, 3);
    bt1.insertRight(bt1.root, 2);
    bt1.insertLeft(bt1.root.left, 5);

    BinaryTree bt2 = new BinaryTree();
    bt2.insertRoot(2);
    bt2.insertLeft(bt2.root, 1);
    bt2.insertRight(bt2.root, 3);
    bt2.insertRight(bt2.root.left, 4);
    bt2.insertRight(bt2.root.right, 7);

    bt1.display(bt1.root);
    bt2.display(bt2.root);

    Solution solution = new Solution();
    TreeNode mergedNode = solution.mergeTrees(bt1.root, bt2.root);

    Stack<TreeNode> s = new Stack<>();
    TreeNode cur = mergedNode; 
    while (!s.empty() || cur != null) {
      if (cur != null) {
        s.push(cur);
        cur = cur.left;
      } else {
        TreeNode n = s.pop();
        System.out.print(" " + n.val);
        cur = n.right;
      }
    }
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { this.val = x; }
}

class BinaryTree {
  public TreeNode root;
  
  public BinaryTree() {
    this.root = null;
  }

  public void insertRoot(int id) {
    this.root = new TreeNode(id);
  }

  public void insertLeft(TreeNode parent, int id) {
    TreeNode newNode = new TreeNode(id);
    parent.left = newNode;
  }
  
  public void insertRight(TreeNode parent, int id) {
    TreeNode newNode = new TreeNode(id);
    parent.right = newNode;
  }
  
  public void display(TreeNode root) {
    if (root != null) {
      display(root.left);
      System.out.print(" " + root.val);
      display(root.right);
    } else {
      System.out.println("");
    }
  }
}

