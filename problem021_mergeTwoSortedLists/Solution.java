import java.util.*;

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode mergeHead;

		if (l1.val < l2.val) {
			mergeHead = l1;
			mergeHead.next = mergeTwoLists(l1.next, l2);
		} else {
			mergeHead = l2;
			mergeHead.next = mergeTwoLists(l1, l2.next);
		}
		return mergeHead;
	}

	public static ListNode convertInteger2ListNode(int num) {
		String numString = String.valueOf(num);
		char[] numCharacters = numString.toCharArray();
		Arrays.sort(numCharacters);

		System.out.print("Input:");

		ListNode listNode = new ListNode(0);
		ListNode curr = listNode;
		for (int i = 0; i < numCharacters.length; i++) {
			int digit = Character.getNumericValue(numCharacters[i]);
			System.out.print(" " + String.valueOf(digit));
			curr.next = new ListNode(digit);
			curr = curr.next;
		}
		System.out.println("");
		return listNode.next;
	}

	public static void main(String[] args) {
		int number1 = 419, number2 = 382;

		ListNode l1 = convertInteger2ListNode(number1);
		ListNode l2 = convertInteger2ListNode(number2);

		Solution solution = new Solution();
		ListNode result = solution.mergeTwoLists(l1, l2);
		System.out.print("Result: ");
		String sep = "";
		while (result != null) {
			System.out.print(sep + result.val);
			sep = " ";
			result = result.next;
		}
		System.out.println("");
	}
}
