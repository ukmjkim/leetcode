public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode cur = head;
    while (cur != null && cur.next != null) {
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }
  
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode cur = head;
    ListNode newNode = new ListNode(1);
    cur.next = newNode;
    cur = cur.next;
    newNode = new ListNode(2);
    cur.next = newNode;
    cur = cur.next;
    newNode = new ListNode(3);
    cur.next = newNode;
    cur = cur.next;
    newNode = new ListNode(3);
    cur.next = newNode;
    cur = cur.next;

    Solution solution = new Solution();
    ListNode resultNode = solution.deleteDuplicates(head);
    while (resultNode != null) {
      System.out.print(" " + resultNode.val);
      resultNode = resultNode.next;
    }
    System.out.println("");
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}
