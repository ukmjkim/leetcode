import java.util.*;

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode mergeHead = new ListNode(0);
		ListNode part1 = l1, part2 = l2, curr = mergeHead;

		while (part1 != null || part2 != null) {
			int x = (part1 != null) ? part1.val : 10;
			int y = (part2 != null) ? part2.val : 10;

			if (x < y) {
				curr.next = new ListNode(x);
				part1 = part1.next;
			} else {
				curr.next = new ListNode(y);
				part2 = part2.next;
			}
			curr = curr.next;
		}

		return mergeHead.next;
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
		int number1 = 4129, number2 = 382;

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
