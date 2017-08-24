import java.util.*;

public class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (root == null) {
			return res;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);

		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<Integer>();

			for (int i = 0; i < size; i++) {
				TreeNode t = q.poll();
				list.add(t.val);

				if (t.left != null) {
					q.offer(t.left);
				}
				if (t.right != null) {
					q.offer(t.right);
				}	
			}
			res.add(list);
		}

		return res;
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

