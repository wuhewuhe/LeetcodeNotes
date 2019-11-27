package LinkedList;

import org.junit.Test;

/**
 * @author he.wu Given a linked list, rotate the list to the right by k places,
 *         where k is non-negative.
 * 
 *         Example 1:
 * 
 *         Input: 1->2->3->4->5->NULL, k = 2 Output: 4->5->1->2->3->NULL
 *         Explanation: rotate 1 steps to the right: 5->1->2->3->4->NULL rotate
 *         2 steps to the right: 4->5->1->2->3->NULL Example 2:
 * 
 *         Input: 0->1->2->NULL, k = 4 Output: 2->0->1->NULL Explanation: rotate
 *         1 steps to the right: 2->0->1->NULL rotate 2 steps to the right:
 *         1->2->0->NULL rotate 3 steps to the right: 0->1->2->NULL rotate 4
 *         steps to the right: 2->0->1->NULL
 */

public class RotateList61 {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy, slow = dummy;

		int i;
		for (i = 0; fast.next != null; i++)// Get the total length
			fast = fast.next;

		for (int j = i - n % i; j > 0; j--) // Get the i-n%i th node
			slow = slow.next;

		fast.next = dummy.next; // Do the rotation
		dummy.next = slow.next;
		slow.next = null;

		return dummy.next;
	}

	@Test
	public void test() {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		System.out.println(rotateRight(a, 7));
	}
}
