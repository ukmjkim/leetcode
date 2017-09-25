import java.util.*;

public class Solution {
  private static final int UNBALANCED = -99;

  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    return getHeight(root) != UNBALANCED;
  }
  
  private int getHeight(TreeNode root) {
    if (root == null) return -1;
    
    int left = getHeight(root.left);
    int right = getHeight(root.right);
    if (left == UNBALANCED || right == UNBALANCED || Math.abs(left - right) > 1) {
      return UNBALANCED;
    }
    return 1 + Math.max(left, right);
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
    System.out.println("Result: " + solution.isBalanced(head));

    TreeNode head2 = solution.sortedArrayToBST(nums2);
    List<List<Integer>> list2 = solution.levelOrderBottom(head2);
    System.out.println(list2);
    System.out.println("Result: " + solution.isBalanced(head2));
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

