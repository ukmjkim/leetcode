import java.util.*;

public class Solution {
  // Recursive
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;

    if (root.left == null && root.right == null && sum - root.val == 0) return true;
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
  }

  // Iterative
  public boolean hasPathSum2(TreeNode root, int sum) {
    if (root == null) return false;
    
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<Integer> queueValue = new LinkedList<>();
    
    queue.offer(root);
    queueValue.offer(root.val);
    
    while (!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      int sumValue = queueValue.poll();
      
      if (curr.left == null & curr.right == null && sumValue == sum) {
        return true;
      }
      
      if (curr.left != null) {
        queue.offer(curr.left);
        queueValue.offer(sumValue+curr.left.val);
      }
      if (curr.right != null) {
        queue.offer(curr.right);
        queueValue.offer(sumValue+curr.right.val);
      }
    }
    
    return false;
  }

  // Recursive
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) return null;

    return makeBST(nums, 0, nums.length-1);
  }

  private TreeNode makeBST(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }
    
    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = makeBST(nums, start, mid - 1);
    node.right = makeBST(nums, mid + 1, end);
    return node;
  }

  // Recursive
  private static List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> list = new LinkedList<List<Integer>>();

    if (root == null) return list;

    makeList(list, root, 0);
    return list;
  }

  private static void makeList(List<List<Integer>> list, TreeNode node, int level) {
    if (node == null) return;
    if (level >= list.size()) {
      list.add(0, new LinkedList<Integer>());
    }
    makeList(list, node.left, level+1);
    makeList(list, node.right, level+1);
    list.get((list.size()-1)-level).add(node.val);
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    Solution solution = new Solution();
    TreeNode head = solution.sortedArrayToBST(nums);
    List<List<Integer>> list = solution.levelOrderBottom(head);
    System.out.println(list);
    System.out.println("Result: " + solution.hasPathSum(head, 7));

    TreeNode head2 = solution.sortedArrayToBST(nums2);
    List<List<Integer>> list2 = solution.levelOrderBottom(head2);
    System.out.println(list2);
    System.out.println("Result: " + solution.hasPathSum2(head2, 8));
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

