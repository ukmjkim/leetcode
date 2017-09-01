public class Solution {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null & t2 == null) return null;

		int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
		TreeNode newNode = new TreeNode(val);

		newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
		newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

		return newNode;
	}

	private static TreeNode initializeTree1() {
		BinaryTree bt = new BinaryTree();

		bt.insertRoot(1);
		bt.insertLeft(3, bt.root);
		bt.insertRight(2, bt.root);
		bt.insertLeft(5, bt.root.left);
		bt.display(bt.root);

		return bt.root;
	}

	private static TreeNode initializeTree2() {
		BinaryTree bt = new BinaryTree();

		bt.insertRoot(2);
		bt.insertLeft(1, bt.root);
		bt.insertRight(3, bt.root);
		bt.insertRight(4, bt.root.left);
		bt.insertRight(7, bt.root.right);
		bt.display(bt.root);

		return bt.root;
	}

	private static void display(TreeNode root) {
		if (root != null) {
			display(root.left);
			System.out.print(" " + root.val);
			display(root.right);
		} else {
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		TreeNode t1 = initializeTree1();
		TreeNode t2 = initializeTree2();

		Solution solution = new Solution();
		TreeNode head = solution.mergeTrees(t1, t2);
		
		display(head);

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
		} else {
			System.out.println("");
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x) { this.val = x; }
}
