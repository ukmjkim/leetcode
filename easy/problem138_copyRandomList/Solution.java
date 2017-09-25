import java.util.*;

public class Solution {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;

		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode newHead = new RandomListNode(head.label);

		RandomListNode p = head;
		RandomListNode q = newHead;
		map.put(head, newHead);

		p = p.next;
		while (p != null) {
			RandomListNode temp = new RandomListNode(p.label);
			map.put(p, temp);
			q.next = temp;
			q = temp;
			p = p.next;
		}

		p = head;
		q = newHead;
		while (p != null) {
			if (p.random != null)
				q.random = map.get(p.random);
			else
				q.random = null;
			p = p.next;
			q = q.next;
		}

		displayLinkedList(head);
		displayLinkedList(newHead);

		return newHead;
	}

	private static RandomListNode initializeLinkedList(int[] nums) {
		RandomListNode head = new RandomListNode(0);
		RandomListNode curr = head;
		for (int i = 0; i < nums.length; i++) {
			RandomListNode newNode = new RandomListNode(nums[i]);
			curr.next = newNode;
			curr = curr.next;
		}
		return head.next;
	}

	private static void displayLinkedList(RandomListNode head) {
		RandomListNode curr = head;

		System.out.println("Result:");
		while (curr != null) {
			System.out.print(" " + curr.label);
			curr = curr.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};

		RandomListNode head = initializeLinkedList(nums);
		Solution solution = new Solution();
		RandomListNode clone = solution.copyRandomList(head);
	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
}

