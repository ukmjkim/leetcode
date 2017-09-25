public class Solution {
	public boolean isPalindrome(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;	
		}
		if (fast != null) {
			slow = slow.next;
		}

		slow = reverse(slow);
		fast = head;

		while (slow != null) {
			if (fast.val != slow.val) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}

		return true;
	}

	private ListNode reverse(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newHead;	
			newHead = head;
			head = next;
		}
		return newHead;
	}
	private static ListNode initializeSinglyLinkedList(int[] nums) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		for (int i = 0; i < nums.length; i++) {
			ListNode newNode = new ListNode(nums[i]);
			curr.next = newNode;
			curr = curr.next;
		}

		return head.next;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 3, 2, 1};

		ListNode head = initializeSinglyLinkedList(nums);
		Solution solution = new Solution();
		System.out.println("Result: " + solution.isPalindrome(head));
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}
