package LinkedList;

import org.junit.Test;

public class RemoveDuplicatedFromSortedList83 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode pointer = head;
		while (pointer != null && pointer.next != null) {
			if (pointer.val == pointer.next.val) {
				pointer.next =  pointer.next.next;
			}
			else pointer = pointer.next;
		}
		return head;
	}

	@Test
	public void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		ListNode node = deleteDuplicates(n1);
		System.out.println(node);
	}
}
