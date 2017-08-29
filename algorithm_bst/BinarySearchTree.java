public class BinarySearchTree {
	public static TreeNode root;

	public BinarySearchTree() {
		this.root = null;
	}

	public void insert(int id) {
		TreeNode newNode = new TreeNode(id);
		if (root == null) {
			root = newNode;
			return;
		}

		TreeNode current = root;
		TreeNode parent = null;

		while (true) {
			parent = current;
			if (id < current.val) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			} else if (id > current.val) {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}	
	}

	public TreeNode find(int id) {
		if (root == null) {
			return null;
		}

		TreeNode current = root;
		while (current != null) {
			if (id == current.val) {
				return current;
			} else if (id < current.val) {
				current = current.left;
			} else if (id > current.val) {
				current = current.right;
			}
		}

		return null;
	}

	public void display(TreeNode root) {
		if (root != null) {
			display(root.left);
			System.out.println(" " + root.val);
			display(root.right);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 3, 5, 2, 4};

		BinarySearchTree bst = new BinarySearchTree();
		for (int i = 0; i < nums.length; i++) {
			bst.insert(nums[i]);
		}
		bst.display(bst.root);

		TreeNode node = bst.find(5);
		System.out.println("Found : " + node.val);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { this.val = x; }	
}
