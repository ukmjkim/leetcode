public class ListNode <E> {
	private E value;
	private ListNode<E> next;

	public ListNode(E newValue, ListNode<E> newNext) {
		value = newValue;
		next = newNext;
	}

	public E getValue() { return value; }
	public ListNode<E> getNext() { return next; }

	public void setValue(E newValue) { value = newValue; }
	public void setNext(ListNode<E> newNext) { next = newNext; }
}

