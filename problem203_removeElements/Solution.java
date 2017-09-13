public class Solution {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return head;
    }
    
    while (head.val == val) {
      head = head.next;
      if (head == null) return null;
    }
    ListNode cur = head;
    ListNode prev = head;
    cur = cur.next;
    while (cur != null) {
      if (cur.val == val) {
        prev.next = cur.next;
        cur = cur.next;
      } else {
      	prev = prev.next;
      	cur = cur.next;
      }
    }
    return head;
  }

  private static ListNode createLinkedList(int[] nums) {
    ListNode root = new ListNode(0);
    ListNode cur = root;
    for (int i = 0; i < nums.length; i++) {
      ListNode newNode = new ListNode(nums[i]);
      cur.next = newNode;
      cur = cur.next;
    }
    return root.next;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 6, 3, 4, 5, 6};
    int target = 6;

    ListNode root = createLinkedList(nums);

    Solution solution = new Solution();
    ListNode node = solution.removeElements(root, target);
    while (node != null) {
      System.out.print(" " + node.val);
      node = node.next;
    }
    System.out.println("");
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode (int x) { val = x; }
}


