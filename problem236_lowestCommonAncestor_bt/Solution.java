public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) return root;
		return left != null ? left : right;
	}

	private static BinaryTree initializeBT() {
		BinaryTree bt = new BinaryTree();

		bt.insertRoot(3);
		bt.insertLeft(5, bt.root);
		bt.insertRight(1, bt.root);

		TreeNode node5 = bt.findNode(bt.root, 5);
		bt.insertLeft(6, node5);
		bt.insertRight(2, node5);
		TreeNode node1 = bt.findNode(bt.root, 1);
		bt.insertLeft(0, node1);
		bt.insertRight(8, node1);
		TreeNode node2 = bt.findNode(bt.root, 2);
		bt.insertLeft(7, node2);
		bt.insertRight(4, node2);

		return bt;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		BinaryTree bt = initializeBT();	
		bt.display(bt.root);
		System.out.println("");
		TreeNode p = bt.findNode(bt.root, 5);
		TreeNode q = bt.findNode(bt.root, 1);
		TreeNode ancestor = solution.lowestCommonAncestor(bt.root, p, q);
		System.out.println("Result: " + ancestor.val);
	}
}

class BinaryTree {
	public static TreeNode root;

	public BinaryTree() {
		this.root = null;
	}

	public void insertRoot(int id) {
		this.root = new TreeNode(id);
	}

	public void insertLeft(int id, TreeNode parent) {
		TreeNode newNode = new TreeNode(id);
		parent.left = newNode;
	}

	public void insertRight(int id, TreeNode parent) {
		TreeNode newNode = new TreeNode(id);
		parent.right = newNode;
	}

	public TreeNode findNode(TreeNode root, int id) {
		TreeNode result = null;

		if (root == null) {
			return null;
		}

		if (root.val == id) {
			return root;
		}

		if (root.left != null) {
			result = findNode(root.left, id);
		}
		
		if (result == null) {
			result = findNode(root.right, id);
		}

		return result;
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
	TreeNode(int x) { this.val = x; }
}
