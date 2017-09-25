import java.util.*;

public class Solution {
  public int pathSum(TreeNode root, int sum) {
    HashMap<Integer, Integer> preSum = new HashMap<>();
    preSum.put(0,1);
    return helper(root, 0, sum, preSum);
  }

  public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
    if (root == null) return 0;
    
    currSum += root.val;
    int result = preSum.getOrDefault(currSum - target, 0);
    preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
    
    result += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
    preSum.put(currSum, preSum.get(currSum) - 1);
    return result;
  }

  private static TreeNode generateTree(int[] nums) {
    Queue<TreeNode> queue = new LinkedList<>();
    
    int val = 0;
    int idx = 0;
    TreeNode root = new TreeNode(nums[0]);
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      val = nums[++idx];
      node.left = (val == -99999) ? null : new TreeNode(val);
      val = nums[++idx];
      node.right = (val == -99999) ? null : new TreeNode(val);
      queue.offer(node.left);
      queue.offer(node.right);

      if (idx >= nums.length-1) return root;
    }
    
    return root;
  }

  private static void display(TreeNode root) {
    if (root != null) {
      System.out.print(" " + root.val);
      display(root.left);
      display(root.right);
    }
  }

  public static void main(String[] args) {
    int[] nums = {10, 5, -3, 3, 2, -99999, 11, 3, -2, -99999, 1};
    int sum = 8;

    TreeNode root = generateTree(nums);
    display(root);

    Solution solution = new Solution();
    System.out.println("\nResult: " + solution.pathSum(root, sum));
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}


