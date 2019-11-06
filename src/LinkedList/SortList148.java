package LinkedList;

import org.junit.Test;

/**
 * @author he.wu Sort a linked list in O(n log n) time using constant space
 *         complexity.
 * 
 *         Example 1:
 * 
 *         Input: 4->2->1->3 Output: 1->2->3->4 Example 2:
 * 
 *         Input: -1->5->3->4->0 Output: -1->0->3->4->5
 */
public class SortList148 {
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
		ListNode node = sortList(n1);
		System.out.println(node);
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// step 1. cut the list to two halves
		ListNode prev = null, slow = head, fast = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;

		// step 2. sort each half
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);

		// step 3. merge l1 and l2
		return merge(l1, l2);
	}

	ListNode merge(ListNode l1, ListNode l2) {
		ListNode l = new ListNode(0), p = l;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}

		if (l1 != null)
			p.next = l1;

		if (l2 != null)
			p.next = l2;

		return l.next;
	}

	// heap sort priority queue
	public ListNode sortList2(ListNode head) {
		return head;
	}
}
