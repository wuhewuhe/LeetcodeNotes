package LinkedList;

import org.junit.Test;

/**
 * @author he.wu Reverse a singly linked list.
 * 
 *         Example:
 * 
 *         Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL Follow up:
 * 
 *         A linked list can be reversed either iteratively or recursively.
 *         Could you implement both?
 */
public class ReverseLinkedList206 {
	// iterative
	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode curr = head;
		ListNode prev = null;
		while (curr != null) {
			ListNode tem = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tem;
		}
		return prev;
	}
	
	public ListNode reverseList2(ListNode head) {
	    if (head == null || head.next == null) return head;
	    ListNode p = reverseList(head.next);
	    head.next.next = head;
	    head.next = null;
	    return p;
	}

	@Test
	public void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		ListNode node = reverseList(n1);
		System.out.println(node);
	}

}
