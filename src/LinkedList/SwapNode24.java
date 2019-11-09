package LinkedList;

import org.junit.Test;

/**
 * @author mac Given a linked list, swap every two adjacent nodes and return its
 *         head.
 * 
 *         You may not modify the values in the list's nodes, only nodes itself
 *         may be changed.
 * 
 * 
 * 
 *         Example:
 * 
 *         Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNode24 {

	public ListNode swapPairs(ListNode head) {
		if (head != null && head.next != null ) {
			ListNode dummy = new ListNode(0);
			dummy.next = head;
			ListNode curr = dummy;
			while (curr.next != null && curr.next.next != null) {
				ListNode first = curr.next;
				ListNode second = curr.next.next;
				curr.next = second;
				first.next = second.next;
				second.next = first;
				curr = curr.next.next;
			}
			return dummy.next;
		}
		return head;
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
		ListNode node = swapPairs(n1);
		System.out.println(node);
	}
}
