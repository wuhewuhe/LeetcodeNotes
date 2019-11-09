package LinkedList;

import org.junit.Test;

/**
 * @author mac Given a linked list, reverse the nodes of a linked list k at a
 *         time and return its modified list.
 * 
 *         k is a positive integer and is less than or equal to the length of
 *         the linked list. If the number of nodes is not a multiple of k then
 *         left-out nodes in the end should remain as it is.
 * 
 *         Example:
 * 
 *         Given this linked list: 1->2->3->4->5
 * 
 *         For k = 2, you should return: 2->1->4->3->5
 * 
 *         For k = 3, you should return: 3->2->1->4->5
 * 
 *         Note:
 * 
 *         Only constant extra memory is allowed. You may not alter the values
 *         in the list's nodes, only nodes itself may be changed.
 */
public class ReverseKGroupNodes25 {

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
		ListNode node = reverseKGroup(n1, 2);
		System.out.println(node);
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		// find peak node
		int index = 1;
		ListNode ptr = head;
		while (index++ < k) {
			ptr = ptr.next;
		}
		ListNode next = ptr.next;
		ptr = head;
		ListNode prev = null;
		while(ptr != next) {
			ListNode tem = ptr.next;
			ptr.next = prev;
			prev = ptr;
			ptr = tem;
		}
		ListNode curr = prev;
		while(curr.next != null)
		{
			curr = curr.next;
		}
		curr.next = next;
		return prev;
	}
	
	
	public ListNode reverseKGroup2(ListNode head, int k) {
	    ListNode curr = head;
	    int count = 0;
	    while (curr != null && count != k) { // find the k+1 node
	        curr = curr.next;
	        count++;
	    }
	    if (count == k) { // if k+1 node is found
	        curr = reverseKGroup2(curr, k); // reverse list with k+1 node as head
	        // head - head-pointer to direct part, 
	        // curr - head-pointer to reversed part;
	        while (count-- > 0) { // reverse current k-group: 
	            ListNode tmp = head.next; // tmp - next head in direct part
	            head.next = curr; // preappending "direct" head to the reversed list 
	            curr = head; // move head of reversed part to a new node
	            head = tmp; // move "direct" head to the next node in direct part
	        }
	        head = curr;
	    }
	    return head;
	}

}
