package LinkedList;

import org.junit.Test;

/**
 * @author he.wu Remove all elements from a linked list of integers that have
 *         value val.
 * 
 *         Example:
 * 
 *         Input: 1->2->6->3->4->5->6, val = 6 Output: 1->2->3->4->5
 */
public class RemoveElementFromLinkedList203 {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		ListNode pointer = head;
		if (head.next == null)
			return head.val == val ? null : head;
		while (pointer.next != null) {
			if (pointer.next.val == val)
				pointer.next = pointer.next.next;
			else
				pointer = pointer.next;
		}
		return head.val == val ? head.next : head;
	}

	public ListNode removeElements2(ListNode head, int val) {
		if (head == null)
			return null;
		head.next = removeElements(head.next, val);
		return head.val == val ? head.next : head;
	}

	@Test
	public void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode node = removeElements(n1, 1);
		System.out.println(node);
	}
}
