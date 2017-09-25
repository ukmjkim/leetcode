import java.util.*;

public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		levelHelper(res, root, 0);
		return res;
	}

	public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
		if (root == null) return;
		if (height >= res.size()) {
			res.add(new LinkedList<Integer>());
		}
		res.get(height).add(root.val);
		levelHelper(res, root.left, height+1);
		levelHelper(res, root.right, height+1);
	}

	private TreeNode makeTree() {
		// int[] nums = {3, 9, 20, null, null, 15, 7}

		TreeNode n1 = new TreeNode(9);
		TreeNode n2 = new TreeNode(20);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(7);

		BinaryTree tree = new BinaryTree(3);
		tree.add(tree.root, n1, "left");
		tree.add(tree.root, n2, "right");
		tree.add(n2, n3, "left");
		tree.add(n2, n4, "right");

		tree.display(tree.root);

		return tree.root;	
	}

	public static void main(String[] args) {

		Solution solution = new Solution();
		TreeNode root = solution.makeTree();
		List<List<Integer>> result = solution.levelOrder(root);
		System.out.println(result);
	}
}

class BinaryTree {
	public static TreeNode root;
	public BinaryTree(int id) {
		this.root = new TreeNode(id);
	}
	public void add(TreeNode parent, TreeNode child, String orientation) {
		if (orientation.equals("left")) {
			parent.left = child;
		} else {
			parent.right = child;
		}
	}
	public void display(TreeNode root) {
		if (root != null) {
			display(root.left);
			System.out.print(" " + root.val);
			display(root.right);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
