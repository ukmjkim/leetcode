public class BinaryTree {
	public static TreeNode root;

	public BinaryTree() {
		this.root = null;
	}

	public void insertRoot(int id) {
		TreeNode newNode = new TreeNode(id);
		this.root = newNode;
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

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();

		bt.insertRoot(2);
		bt.insertLeft(1, bt.root);
		bt.insertRight(3, bt.root);
		bt.display(bt.root);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { this.val = x; }
}

