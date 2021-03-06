package LinkedList;

import org.junit.Test;

/**
 * @author he.wu Given a singly linked list, group all odd nodes together
 *         followed by the even nodes. Please note here we are talking about the
 *         node number and not the value in the nodes.
 * 
 *         You should try to do it in place. The program should run in O(1)
 *         space complexity and O(nodes) time complexity.
 * 
 *         Example 1:
 * 
 *         Input: 1->2->3->4->5->NULL Output: 1->3->5->2->4->NULL Example 2:
 * 
 *         Input: 2->1->3->5->6->4->7->NULL Output: 2->3->6->7->1->5->4->NULL
 *         Note:
 * 
 *         The relative order inside both the even and odd groups should remain
 *         as it was in the input. The first node is considered odd, the second
 *         node even and so on ...
 */
public class OddEvenLinkedList328 {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return head;
		ListNode even = head.next;
		ListNode evenHead = even;
		ListNode odd = head;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = even.next.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

	@Test
	public void test() {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		System.out.println(oddEvenList(a));
	}
}
