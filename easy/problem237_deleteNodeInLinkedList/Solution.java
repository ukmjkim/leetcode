public class Solution {
  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }
  
  private static ListNode generateLinkedList(int nums[]) {
    ListNode head = new ListNode(0);
    ListNode cur = head;
    for (int i = 0; i < nums.length; i++) {
      ListNode newNode = new ListNode(nums[i]);
      cur.next = newNode;
      cur = cur.next;
    }
    return head.next;
  }
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5};

    ListNode head = generateLinkedList(nums);
    Solution solution = new Solution();
    solution.deleteNode(head.next);
    solution.deleteNode(head.next.next);
    while (head != null) {
      System.out.print(" " + head.val);
      head = head.next;
    }
    System.out.println("");

    int[] nums2 = {0, 1};
    ListNode head2 = generateLinkedList(nums2);
    solution.deleteNode(head2);
    while (head2 != null) {
      System.out.print(" " + head2.val);
      head2 = head2.next;
    }
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { this.val = x; }
}

