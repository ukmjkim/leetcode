import java.util.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class Solution {
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int n = queue.size();
      double sum = 0.0;
      for (int i = 0; i < n; i++) {
        TreeNode node = queue.poll();
        sum += node.val;
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
      result.add(sum / n);
    }

    return result;
  }

  private static String tree2str(TreeNode root) {
    if (root == null) return "";

    String result = root.val + "";

    String left = tree2str(root.left);
    String right = tree2str(root.right);

    if (left == "" && right == "") return result;
    if (left == "") return result + "()" + "(" + right + ")";
    if (right == "") return result + "(" + left + ")";
    return result + "(" + left + ")" + "(" + right + ")";
  }

  private static TreeNode generateBT(Integer[] nums) {
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
      if (i >= nums.length) break;

      if (nums[i] != null) {
        parent.right = new TreeNode(nums[i]);
        queue.offer(parent.right);
      }
      i++;
    }
    return root;
  }

  public static void main(String[] args) {
    //Integer[] nums = {3, 9, 20, null, null, 15, 7};
    Integer[] nums = {3, 1, 5, 0, 2, 4, 6};
    System.out.println(Arrays.toString(nums));
    TreeNode root = generateBT(nums);
    System.out.println(tree2str(root));

    Solution solution = new Solution();
    List<Double> result = solution.averageOfLevels(root);

    DecimalFormat form = new DecimalFormat("#.##");
    form.setRoundingMode(RoundingMode.HALF_UP);
    for (Double num : result) {
      System.out.printf(" %s", form.format(num.doubleValue()));
    }
    System.out.println("");
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

