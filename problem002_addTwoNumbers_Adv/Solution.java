public class Solution {
	public ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
		ListNode<Integer> dummyHead = new ListNode<Integer>(0, null);
		ListNode<Integer> p = l1, q = l2, curr = dummyHead;

		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? (int) p.getValue() : 0;
			int y = (q != null) ? (int) q.getValue() : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.setNext(new ListNode<Integer>((Integer) sum % 10, null));
			curr = curr.getNext();
			if (p != null) p = p.getNext();
			if (q != null) q = q.getNext();
		}
		if (carry > 0) {
			curr.setNext(new ListNode<Integer>((Integer)carry, null));
		}

		return dummyHead.getNext();
	}

	public static ListNode<Integer> convertInteger2ListNode(int number) {
		ListNode<Integer> l = new ListNode<Integer>(0, null);
		ListNode<Integer> curr = l;
		while (number > 0) {
			int lastDigit = number % 10;
			number = number / 10;
			curr.setNext(new ListNode<Integer>((Integer) lastDigit, null));
			curr = curr.getNext();
		}
		return l.getNext();
	}

	public static void main(String[] args) {
		int number1 = 243;
		int number2 = 564;

		ListNode<Integer> l1 = convertInteger2ListNode(number1);
		ListNode<Integer> l2 = convertInteger2ListNode(number2);

		Solution solution = new Solution();
		ListNode<Integer> listnode = solution.addTwoNumbers(l1, l2);
		StringBuilder sb = new StringBuilder("First Number: ");
		sb.append(Integer.toString(number1));
		sb.append(System.getProperty("line.separator"));
		sb.append("Second Number: ");
		sb.append(Integer.toString(number2));
		sb.append(System.getProperty("line.separator"));
		sb.append("The result of Addition: ");
		while (listnode != null) {
			sb.append(Integer.toString(listnode.getValue()));
			listnode = listnode.getNext();
		}
		sb.append(System.getProperty("line.separator"));
		System.out.println(sb.toString());
	}
}
