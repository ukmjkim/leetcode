import java.util.*;

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;

		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? (Integer) p.val : 0;
			int y = (q != null) ? (Integer) q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null) p = p.next;
			if (q != null) q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}

	public static ListNode convertInteger2ListNode(int num) {
		ListNode l = new ListNode(0);
		ListNode curr = l;
		while (num > 0) {
			int lastDigit = num % 10;
			num = num / 10;
			curr.next = new ListNode(lastDigit);
			curr = curr.next;
		}
		return l.next;
	}

	public static void main(String[] args) {
		int number1 = 432, number2 = 465;

		ListNode l1 = convertInteger2ListNode(number1);
		ListNode l2 = convertInteger2ListNode(number2);

		Solution solution = new Solution();
		ListNode node = solution.addTwoNumbers(l1, l2);
		StringBuilder sb = new StringBuilder("Node: ");
		while (node != null) {
			sb.append(node.val);
			node = node.next;
		}
		System.out.println(sb.toString());
	}
}
