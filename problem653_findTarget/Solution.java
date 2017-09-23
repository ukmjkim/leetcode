import java.util.*;

public class Solution {
  public boolean findTarget(TreeNode root, int k) {
    HashSet<Integer> set = new HashSet<>();
    return dfs(root, set, k);

  }

  public boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
    if (root == null) return false;
    if (set.contains(k - root.val)) return true;
    set.add(root.val);
    return dfs(root.left, set, k) || dfs(root.right, set, k);
  }

  public static void main(String[] args) {
    int[] nums = {2, 1, 3};
    BinarySearchTree bst = new BinarySearchTree();
    for (int i = 0; i < nums.length; i++) {
      bst.insert(nums[i]);
    }
    System.out.println(bst.tree2str(bst.root));
    System.out.println(bst.find(bst.root, 9));

    Solution solution = new Solution();
    System.out.printf("findTarget(%d) = %b\n", 4, solution.findTarget(bst.root, 4));
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


