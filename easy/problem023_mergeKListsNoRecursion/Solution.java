import java.util.*;

public class Solution {
	public ListNode mergeKLists(ListNode[] list) {
		ListNode mergeHead = new ListNode(0);
		ListNode curr = mergeHead;

		int lengthOfArray = list.length;
		while (true) {
			int countOfNull = 0;
			int minValue = Integer.MAX_VALUE;
			int minValueIndex = 99;
			for (int i = 0; i < lengthOfArray; i++) {
				if (list[i] == null) {
					countOfNull++;
				} else {
					if (minValue > list[i].val) {
						minValueIndex = i;
						minValue = list[i].val;
					}
				}
			}
			if (countOfNull == lengthOfArray) {
				break;
			}
			curr.next = new ListNode(list[minValueIndex].val);	
			curr = curr.next;
			list[minValueIndex] = list[minValueIndex].next;
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
		int number1 = 4129, number2 = 382, number3 = 760;

		ListNode l1 = convertInteger2ListNode(number1);
		ListNode l2 = convertInteger2ListNode(number2);
		ListNode l3 = convertInteger2ListNode(number3);

		ListNode[] lists = new ListNode[] {l1, l2, l3};

		Solution solution = new Solution();
		ListNode result = solution.mergeKLists(lists);
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
