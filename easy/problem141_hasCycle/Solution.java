public class Solution {
	public boolean hasCycle(ListNode head) {
		if (head == null) return false;
		ListNode walker = head;
		ListNode runner = head;

		while (runner.next != null && runner.next.next != null) {
			walker = walker.next;
			runner = runner.next.next;
			if (walker == runner) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
		int cyclePoint = 4;

		ListNode head = new ListNode(nums[0]);
		ListNode cur = head;
		ListNode cycleNode = null;
		for (int i = 1; i < nums.length; i++) {
			ListNode oneNode = new ListNode(nums[i]);
			if (nums[i] == cyclePoint) {
				cycleNode = cur;
			}
			cur.next = oneNode;
			cur = cur.next;
			if (cycleNode != null && i == nums.length - 1) {
				cur.next = cycleNode;
			}
		}
		
		Solution solution = new Solution();
		System.out.println("Result: " + solution.hasCycle(head));	
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode (int x) {
		this.val = x;
		this.next = null;
	}
}
