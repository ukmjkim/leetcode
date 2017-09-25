import java.util.*;

public class Solution {
  public int[] findMode(TreeNode root) {
    if (root == null) {
      int[] result = new int[0];
      return result;
    }

    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      int frequency = map.getOrDefault(node.val, 0)+1;
      map.put(node.val, frequency);
      if (frequency > max) {
        max = frequency;
      }
      if (node.left != null) {
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
    }

    System.out.println(map);

    int[] result = new int[map.size()];
    int offset = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == max) {
      	Integer key = entry.getKey();
        result[offset] = key.intValue();
        offset++;
      }
    }
    result = Arrays.copyOf(result, offset);

    return result;
  }
  
  public static void main(String[] args) {
    int[] nums = {1, 2, 2};

    BinarySearchTree bst = new BinarySearchTree();
    for (int i = 0; i < nums.length; i++) {
      bst.insert(nums[i]);
    }
    bst.display(bst.root);

    Solution solution = new Solution();
    System.out.println("\nfindMode()");
    System.out.println(Arrays.toString(solution.findMode(bst.root)));
  }
}

class BinarySearchTree {
  TreeNode root;
  
  public BinarySearchTree() {
    this.root = null;
  }
  
  public void insert(int x) {
    if (root == null) {
      root = new TreeNode(x);
      return;
    }
    
    TreeNode cur = root;
    while (true) {
      TreeNode newNode = new TreeNode(x);
      if (x <= cur.val) {
        if (cur.left == null) {
          cur.left = newNode;
          return;
        }
        cur = cur.left;
      } else if (x > cur.val) {
        if (cur.right == null) {
          cur.right = newNode;
          return;
        }
        cur = cur.right;
      }
    }
  }
  
  public void display(TreeNode root) {
    if (root != null) {
      System.out.print(" " + root.val);
      display(root.left);
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

