package LinkedList;

import org.junit.Test;

/**
 * @author mac Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to:
 *         L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 *         You may not modify the values in the list's nodes, only nodes itself
 *         may be changed.
 * 
 *         Example 1:
 * 
 *         Given 1->2->3->4, reorder it to 1->4->2->3. Example 2:
 * 
 *         Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class ReorderList143 {

	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

	}

	@Test
	public void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		reorderList(n1);
		System.out.println(n1);
	}

}
