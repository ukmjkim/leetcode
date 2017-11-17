import java.util.*;

public class Solution {
  // Recursive
  public int solution(Tree T) {
    if (T == null) return 0;
    return visibleNode(T, T.x);
  }

  public int visibleNode(Tree T, int rootValue) {
    if (T == null) return 0;
    
    int visible = 1;
    if (T.x < rootValue) {
      visible = 0;
    }

    return visible + visibleNode(T.l, rootValue) + visibleNode(T.r, rootValue);
  }

  // Iterative
  public int visibleNodeCount(Tree T) {
    if (T == null) return 0;
    
    int rootValue = T.x;
    Queue<Tree> queue = new LinkedList<>();
    queue.offer(T);
    int visibleCount = 0;
    while (!queue.isEmpty()) {
      Tree node = queue.poll();
      
      if (node.x >= rootValue) {
        visibleCount++;
      }

      if (node.l != null) {
        queue.offer(node.l);
      }
      if (node.r != null) {
        queue.offer(node.r);
      }
    }
    return visibleCount;
  }

  private static Tree generateBT(Integer[] nums) {
    if (nums.length == 0) return null;

    Queue<Tree> queue = new LinkedList<>();
    Tree root = new Tree(nums[0]);
    queue.offer(root);
    int i = 1;
    while (!queue.isEmpty() && i < nums.length) {
      Tree parent = queue.poll();
      if (nums[i] != null) {
        parent.l = new Tree(nums[i]);
        queue.offer(parent.l);
      }
      i++;
      if (i > nums.length-1) break;

      if (nums[i] != null) {
        parent.r = new Tree(nums[i]);
        queue.offer(parent.r);
      }
      i++;
    }
    return root;
  }

  private static void runImplementation(Tree root) {
    Solution solution = new Solution();

    long startTime = System.nanoTime ();
    int result = solution.solution(root);
    long endTime   = System.nanoTime ();
  long totalTime = endTime - startTime;
    System.out.println("Execution Time: " + totalTime + ", Recursion: " + result);

    startTime = System.nanoTime ();
    result = solution.visibleNodeCount(root);
    endTime   = System.nanoTime ();
  totalTime = endTime - startTime;

    System.out.println("Execution Time: " + totalTime + ", Interation: " + result);
    System.out.println("======================================================================");
  }

  public static void main(String[] args) {
  Tree root = null;
  int resultRecursion;
    int resultInteration;

    Integer[] nums1 = { new Integer(8), new Integer(2), new Integer(6), new Integer(8), new Integer(7), null, null };
    root = generateBT(nums1);
    runImplementation(root);

    Integer[] nums2 = { new Integer(5), new Integer(3), new Integer(10), new Integer(20), new Integer(21), new Integer(1), null };
    root = generateBT(nums2);
  runImplementation(root);
  }
}

class Tree {
  int x;
  Tree l;
  Tree r;
  Tree(int _x) { x = _x; }
}

