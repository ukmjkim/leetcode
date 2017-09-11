import java.util.*;

public class Solution {
  // Recursive
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> list = new LinkedList<List<Integer>>();

    if (root == null) return list;

    makeList(list, root, 0);
    return list;
  }

  public void makeList(List<List<Integer>> list, TreeNode node, int level) {
    if (node == null) return;
    if (level >= list.size()) {
      list.add(0, new LinkedList<Integer>());
    }
    makeList(list, node.left, level+1);
    makeList(list, node.right, level+1);
    list.get((list.size()-1)-level).add(node.val);
  }


  // Iterative
  public List<List<Integer>> levelOrderBottom2(TreeNode root) {
    List<List<Integer>> list = new LinkedList<>();
    if (root == null) return list;
    
    List<Integer> oneList = new LinkedList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int curLevel = 1;
    int nextLevel = 0;

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      curLevel--;
      oneList.add(node.val);
      if (node.left != null) {
        queue.offer(node.left);
        nextLevel++;
      }
      if (node.right != null) {
        queue.offer(node.right);
        nextLevel++;
      }
      if (curLevel == 0) {
        curLevel = nextLevel;
        nextLevel = 0;
        list.add(0, new LinkedList<Integer>(oneList));
        oneList.clear();
      }
    }
    return list;
  }

  public static void main(String[] args) {
    TreeNode head = new TreeNode(1);
    TreeNode newNode = new TreeNode(2);
    head.left = newNode;
    newNode = new TreeNode(2);
    head.right = newNode;
    newNode = new TreeNode(3);
    head.left.left = newNode;
    newNode = new TreeNode(3);
    head.right.right = newNode;

    Solution solution = new Solution();
    List<List<Integer>> list = solution.levelOrderBottom(head);
    System.out.println(list);

    List<List<Integer>> list2 = solution.levelOrderBottom2(head);
    System.out.println(list2);
  }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}


