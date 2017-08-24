import java.util.*;

public class BinarySearchTree {
	
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode root, int minVal, int maxVal) {
		if (root == null) return true;
		if (root.val >= maxVal || root.val <= minVal) return false;
		return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
	}

	public static void main(String[] args) {
		
	}
}
