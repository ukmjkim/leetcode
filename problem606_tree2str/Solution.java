import java.util.*;

public class Solution {
  public String tree2str(TreeNode t) {
    if (t == null) return "";

    String result = t.val + "";

    String left = tree2str(t.left);
    String right = tree2str(t.right);

    if (left == "" && right == "") return result;
    if (left == "") return result + "()" + "(" + right +")";
    if (right == "") return result + "(" + left + ")";
    return result + "(" + left + ")" + "(" + right + ")";
  }

  private static TreeNode generateBT(Integer[] nums) {
    if (nums.length == 0) return null;

    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root = new TreeNode(nums[0]);
    queue.offer(root);
    int i = 1;
    while (!queue.isEmpty() && i < nums.length) {
      TreeNode parent = queue.poll();
      if (nums[i] != null) {
        parent.left = new TreeNode(nums[i]);
        queue.offer(parent.left);
      }
      i++;
      if (i > nums.length-1) break;

      if (nums[i] != null) {
        parent.right = new TreeNode(nums[i]);
        queue.offer(parent.right);
      }
      i++;
    }
    return root;
  }

  private static void display(TreeNode root, int depth) {
    if (root != null) {
      System.out.printf(" depth[%d]=%s ", depth, root.val);
      display(root.left, depth+1);
      display(root.right, depth+1);
    }
  }

  public static void main(String[] args) {
    Integer[] nums = { new Integer(1), new Integer(2), new Integer(3), null, new Integer(4) };
    TreeNode root = generateBT(nums);
    display(root, 0);
    System.out.println("");

    Solution solution = new Solution();
    System.out.println(solution.tree2str(root));
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

