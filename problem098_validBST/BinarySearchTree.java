import java.util.*;

public class BinarySearchTree {
	public static TreeNode root;

	public BinarySearchTree() {
		this.root = null;
	}

	public void insert(int id) {
		TreeNode newTreeNode = new TreeNode(id);
		if (root == null) {
			root = newTreeNode;
			return;
		}
		TreeNode current = root;
		TreeNode parent = null;

		while (true) {
			parent = current;
			if (id < current.val) {
				current = current.left;
				if (current == null) {
					parent.left = newTreeNode;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newTreeNode;
					return;
				}
			}	
		}
	}

	public void display(TreeNode root) {
		if (root != null) {
			display(root.left);
			System.out.print(" " + root.val);
			display(root.right);	
		}
	}

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode root, int minVal, int maxVal) {
		if (root == null) return true;
		if (root.val >= maxVal || root.val <= minVal) return false;
		return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 6, 8, 9, 10, 15, 16, 20, 25};

		BinarySearchTree bst = new BinarySearchTree();
		for (int i = 0; i < nums.length; i++) {
			bst.insert(nums[i]);
		}
		System.out.println("Original Tree: ");
		bst.display(bst.root);
		System.out.println("");
		System.out.println("Is BST Valid? " + bst.isValidBST(bst.root));
	}
}
