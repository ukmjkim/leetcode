import java.util.*;

public class Solution {
  public TreeNode trimBST(TreeNode root, int L, int R) {
    if (root == null) return null;

    if (root.val < L) return trimBST(root.right, L, R);
    if (root.val > R) return trimBST(root.left, L, R);

    root.left = trimBST(root.left, L, R);
    root.right = trimBST(root.right, L,R);

    return root;
  }

  public static void main(String[] args) {
    int[] nums = {3, 0, 4, 2, 1};
    BinarySearchTree bst = new BinarySearchTree();
    for (int i = 0; i < nums.length; i++) {
      bst.insert(nums[i]);
    }
    System.out.println(bst.tree2str(bst.root));

    Solution solution = new Solution();

    int L = 1;
    int R = 3;
    System.out.printf("trimBST(%d, %d)\n", L, R, solution.trimBST(bst.root, L, R));
    System.out.println(bst.tree2str(bst.root));
  }
}

class BinarySearchTree {
  TreeNode root;

  public BinarySearchTree() {
    this.root = null;
  }

  public void insert(int x) {
    if (root == null) {
      root = new TreeNode(x);
      return;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (x < node.val) {
        if (node.left == null) {
          node.left = new TreeNode(x);
          return;
        } else {
          queue.offer(node.left);
        }
      } else {
        if (node.right == null) {
          node.right = new TreeNode(x);
          return;
        } else {
          queue.offer(node.right);
        }
      }
    }
  }

  public boolean find(TreeNode root, int x) {
    if (root == null) return false;

    if (root.val == x) return true;
    return find(root.left, x) || find(root.right, x);
  }

  public String tree2str(TreeNode root) {
    if (root == null) return "";

    String result = root.val + "";

    String left = tree2str(root.left);
    String right = tree2str(root.right);

    if (left == "" && right == "") return result;
    if (left == "") return result + "()" + "(" + right + ")";
    if (right == "") return result + "(" + left + ")";
    return result + "(" + left + ")" + "(" + right + ")";
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}


