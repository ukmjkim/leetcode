import java.util.*;

public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while ((root.val - p.val) * (root.val - q.val) > 0)
			root = p.val < root.val ? root.left : root.right;
		return root;
	}

	private static TreeNode[] initializeBinarySearchTree(int[] nums, int firstNum, int secondNum) {
		BinarySearchTree bSearchTree = new BinarySearchTree();
		for (int i = 0; i < nums.length; i++) {
			bSearchTree.insert(nums[i]);	
		}

		TreeNode firstNumNode = bSearchTree.find(firstNum);
		TreeNode secondNumNode = bSearchTree.find(secondNum);

		if (firstNumNode == null || secondNumNode == null) {
			System.out.println("Couldn't find the nodes in the Tree");
			System.exit(0);
		}

		TreeNode[] nodelist = new TreeNode[3];
		nodelist[0] = bSearchTree.root;
		nodelist[1] = firstNumNode;
		nodelist[2] = secondNumNode;

		bSearchTree.display(bSearchTree.root);

		return nodelist;
	}

	public static void main(String[] args) {
		int[] nums = {6, 2, 8, 0, 4, 3, 5, 7, 9};
		int firstNum = 2;
		int secondNum = 8;
		Solution solution = new Solution();
		TreeNode[] nodelist = initializeBinarySearchTree(nums, firstNum, secondNum);
		TreeNode ancestor = solution.lowestCommonAncestor(nodelist[0], nodelist[1], nodelist[2]);
		System.out.println("Result: " + ancestor.val);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { this.val = x; }
}

class BinarySearchTree {
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
		while (true) {
			if (current == null) {
				return null;
			}

			if (id == current.val) {
				return current;
			} else if (id < current.val) {
				current = current.left;
			} else if (id > current.val) {
				current = current.right;
			}
		}
	}

	public void display(TreeNode root) {
		if (root != null) {
			display(root.left);
			System.out.println(" " + root.val);
			display(root.right);
		}
	}

	public boolean delete(int id){
		TreeNode parent = root;
		TreeNode current = root;
		boolean isLeftChild = false;
		while(current.val!=id){
			parent = current;
			if(current.val>id){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			//now we have found the minimum element in the right sub tree
			TreeNode successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
	}

	public TreeNode getSuccessor(TreeNode deleleNode){
		TreeNode successsor =null;
		TreeNode successsorParent =null;
		TreeNode current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}
}

