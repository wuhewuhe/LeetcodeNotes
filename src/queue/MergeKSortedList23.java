package queue;

import java.util.PriorityQueue;

import org.junit.Test;

import LinkedList.ListNode;

/**
 * @author he.wu Merge k sorted linked lists and return it as one sorted list.
 *         Analyze and describe its complexity.
 * 
 *         Example:
 * 
 *         Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedList23 {
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		for (ListNode node : lists) {
			while (node != null) {
				pq.add(node.val);
				node = node.next;
			}
		}
		while (pq.size() > 0) {
			ListNode tem = new ListNode(0);
			tem.val = pq.poll();
			head.next = tem;
			head = head.next;
		}
		return dummy.next;
	}

	@Test
	public void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n4.next = n5;
		ListNode[] n = { n1, n4 };
		ListNode node = mergeKLists(n);
		System.out.println(node);
	}
}
