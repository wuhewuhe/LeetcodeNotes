package LinkedList;

import org.junit.Test;

/**
 * @author he.wu Given a linked list, remove the n-th node from the end of list
 *         and return its head.
 * 
 *         Example:
 * 
 *         Given linked list: 1->2->3->4->5, and n = 2.
 * 
 *         After removing the second node from the end, the linked list becomes
 *         1->2->3->5.
 */
public class RemoveNodeFromLinkedList19 {

	// two pass solution
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int len = 0;
		ListNode first = head;
		while (first != null) {
			len++;
			first = first.next;
		}
		len -= n;
		first = dummy;
		while (len > 0) {
			len--;
			first = first.next;
		}
		first.next = first.next.next;
		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// one pass solution two pointer
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		for (int i = 0; i < n + 1; i++) {
			first = first.next;
		}
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
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
		ListNode node = removeNthFromEnd(n1, 2);
		System.out.println(node);
	}
}
