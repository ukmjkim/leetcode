public class Solution {
	public ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;	
		}
		return newHead;
	}

	public ListNode reverseList2(ListNode head) {
		return reverse(head, null);
	}

	public ListNode reverse(ListNode head, ListNode newHead) {
		if (head == null) {
			return newHead;
		}

		ListNode next = head.next;
		head.next = newHead;
		return reverse(next, head);
	}

	private static ListNode initializeSinglyLinkedList() {
		int[] nums = {1, 6, 2, 7, 3, 8, 4, 9, 5};

		ListNode head = new ListNode(0);
		ListNode curr = head;
		for (int i = 0; i < nums.length; i++) {
			ListNode newListNode = new ListNode(nums[i]);
			curr.next = newListNode;
			curr = curr.next;
		}

		return head.next;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = initializeSinglyLinkedList();
		ListNode tail = solution.reverseList(head);
		ListNode newHead = solution.reverseList2(tail);
		ListNode curr = newHead;
		while (curr != null) {
			System.out.print(" " + curr.val);
			curr = curr.next;
		}
		System.out.println("");
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
