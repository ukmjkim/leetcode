import java.util.*;

public class Solution {
  final static int NULL = -9999;

  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) return false;
    if (isSame(s, t)) return true;
    return isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  public boolean isSame(TreeNode s, TreeNode t) {
    if (s == null && t == null) return true;
    if (s == null || t == null) return false;

    if (s.val != t.val) return false;

    return isSame(s.left, t.left) & isSame(s.right, t.right);
  }

	public boolean isSubtree2(TreeNode s, TreeNode t) {
    String sStr = bTreeToString(s);
    String tStr = bTreeToString(t);

    System.out.println(sStr);
    System.out.println(tStr);
		return sStr.contains(tStr);
	}

	private static TreeNode generateBT(int[] nums) {
		if (nums == null || nums.length == 0) return null;
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(nums[0]);
		queue.offer(root);
    int i = 1;
		while (i < nums.length) {
			TreeNode parent = queue.poll();
      if (nums[i] != NULL) {
			  parent.left = new TreeNode(nums[i]);
			  queue.offer(parent.left);	
      }
		  i++;

      if (i == nums.length) break;

      if (nums[i] != NULL) {
			  parent.right = new TreeNode(nums[i]);
			  queue.offer(parent.right);
      }
      i++;
		}

		return root;
	}

	private static void display(TreeNode root, int depth) {
		if (root != null) {
			System.out.printf(" depth[%d] = %d ", depth, root.val);
			display(root.left, depth+1);
			display(root.right, depth+1);
		}
	}

  private static String bTreeToString(TreeNode root) {
    StringBuilder sb = new StringBuilder();

    if (root == null) return sb.toString();

    String delimiter = " ";
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();

      // if handling not null value, it cannot determin whether it's subtree or not
      // using "#" to mark the node as null
      if (node == null) {
        sb.append(delimiter);
        sb.append("#");
      } else {
        sb.append(delimiter);
        sb.append(node.val);
      }
      if (node != null) {
        stack.push(node.right);
        stack.push(node.left);
      }
    }

    return sb.toString();
  }

  private static void testFunction(int[] nums_s, int[] nums_t) {
    TreeNode s = generateBT(nums_s);
	  TreeNode t = generateBT(nums_t);

	  System.out.printf("\nTreeNode s : ");
	  display(s, 0);
	  System.out.printf("\nTreeNode t : ");
	  display(t, 0);
    System.out.println("");

		Solution solution = new Solution();
	  System.out.printf("\nisSubtree(s, t) : %b\n", solution.isSubtree(s, t));
  }

	public static void main(String[] args) {
		int[] nums_s = {3, 4, 5, 1, 2};
		int[] nums_t = {4, 1, 2};
    testFunction(nums_s, nums_t);

		int[] nums_s2 = {3, 4, 5, NULL, NULL, 1, 2, NULL, NULL, 0};
		int[] nums_t2 = {4, 1, 2};
    testFunction(nums_s2, nums_t2);

		int[] nums_s3 = {1, 2, 3};
		int[] nums_t3 = {2, 3};
    testFunction(nums_s3, nums_t3);

		int[] nums_s4 = {12};
		int[] nums_t4 = {2};
    testFunction(nums_s4, nums_t4);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}


