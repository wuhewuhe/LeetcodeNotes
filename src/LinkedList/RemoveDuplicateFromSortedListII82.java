package LinkedList;

import org.junit.Test;

/**
 * @author he.wu Given a sorted linked list, delete all nodes that have
 *         duplicate numbers, leaving only distinct numbers from the original
 *         list.
 * 
 *         Example 1:
 * 
 *         Input: 1->2->3->3->4->4->5 Output: 1->2->5 Example 2:
 * 
 *         Input: 1->1->1->2->3 Output: 2->3
 */
public class RemoveDuplicateFromSortedListII82 {
	@Test
	public void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		ListNode node = deleteDuplicates(n1);
		System.out.println(node);
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode FakeHead = new ListNode(0);
		FakeHead.next = head;
		ListNode pre = FakeHead;
		ListNode cur = head;
		while (cur != null) {
			while (cur.next != null && cur.val == cur.next.val) {
				cur = cur.next;
			}
			if (pre.next == cur) {
				pre = pre.next;
			} else {
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		return FakeHead.next;
	}
}
