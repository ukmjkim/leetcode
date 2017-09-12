import java.util.*;

public class Solution {
  // Recursive
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) return null;

    return makeBST(nums, 0, nums.length-1);
  }

  private TreeNode makeBST(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }
    
    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = makeBST(nums, start, mid - 1);
    node.right = makeBST(nums, mid + 1, end);
    return node;
  }

  // Iterative
  public TreeNode sortedArrayToBST2(int[] nums) {
    if(nums.length ==0 ) return null;
    
    Stack<MyNode> stack = new Stack<MyNode>();
    int mid = 0 + (nums.length -1 - 0)/2;
    TreeNode root = new TreeNode(nums[mid]);
    MyNode MyRoot = new MyNode(0, nums.length -1, root);
    stack.push(MyRoot);
    while(!stack.isEmpty()){
        MyNode curr = stack.pop();
        int oldMid = curr.start + (curr.end - curr.start)/2;
        if(oldMid -1 >= curr.start){
            mid = curr.start + (oldMid-1 - curr.start)/2;
            root = new TreeNode(nums[mid]);
            stack.push(new MyNode(curr.start, oldMid - 1, root));
            curr.node.left = root;
        }
        
        if(oldMid +1 <= curr.end){
            mid = oldMid +1 + (curr.end - oldMid -1)/2;
            root = new TreeNode(nums[mid]);
            stack.push(new MyNode(oldMid + 1, curr.end, root));
            curr.node.right = root;
        }    
    }
    
    return MyRoot.node;
  }

  // Recursive
  private static List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> list = new LinkedList<List<Integer>>();

    if (root == null) return list;

    makeList(list, root, 0);
    return list;
  }

  private static void makeList(List<List<Integer>> list, TreeNode node, int level) {
    if (node == null) return;
    if (level >= list.size()) {
      list.add(0, new LinkedList<Integer>());
    }
    makeList(list, node.left, level+1);
    makeList(list, node.right, level+1);
    list.get((list.size()-1)-level).add(node.val);
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    Solution solution = new Solution();
    TreeNode head = solution.sortedArrayToBST(nums);
    List<List<Integer>> list = solution.levelOrderBottom(head);
    System.out.println(list);

    TreeNode head2 = solution.sortedArrayToBST2(nums2);
    List<List<Integer>> list2 = solution.levelOrderBottom(head2);
    System.out.println(list2);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class MyNode{
    TreeNode node;
    int start;
    int end;
    
    public MyNode(int start, int end, TreeNode node){
        this.start = start;
        this.end = end;
        this.node = node;
    }
}

