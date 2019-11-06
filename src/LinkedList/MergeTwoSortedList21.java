package LinkedList;

import org.junit.Test;

/**
 * @author he.wu Merge two sorted linked lists and return it as a new list. The
 *         new list should be made by splicing together the nodes of the first
 *         two lists.
 * 
 *         Example:
 * 
 *         Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedList21 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode l1_first = l1;
		ListNode l2_first = l2;
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while (l1_first != null || l2_first != null) {
			if (l1_first == null) {
				curr.next = l2_first;
				curr = curr.next;
				l2_first = l2_first.next;
				continue;
			}
			if (l2_first == null) {
				curr.next = l1_first;
				curr = curr.next;
				l1_first = l1_first.next;
				continue;
			}

			if (l1_first.val < l2_first.val) {
				curr.next = l1_first;
				curr = curr.next;
				l1_first = l1_first.next;
			} else {
				curr.next = l2_first;
				curr = curr.next;
				l2_first = l2_first.next;
			}
		}
		return dummy.next;
	}

	//recursion
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}

	@Test
	public void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n5.next = n6;
		n4.next = n5;
		ListNode node = mergeTwoLists(n1, n4);
		System.out.println(node);
	}
}
