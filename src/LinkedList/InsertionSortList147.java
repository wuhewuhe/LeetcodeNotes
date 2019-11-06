package LinkedList;

import org.junit.Test;

/**
 * @author he.wu Sort a linked list using insertion sort.
 * 
 * 
 *         A graphical example of insertion sort. The partial sorted list
 *         (black) initially contains only the first element in the list. With
 *         each iteration one element (red) is removed from the input data and
 *         inserted in-place into the sorted list
 * 
 * 
 *         Algorithm of Insertion Sort:
 * 
 *         Insertion sort iterates, consuming one input element each repetition,
 *         and growing a sorted output list. At each iteration, insertion sort
 *         removes one element from the input data, finds the location it
 *         belongs within the sorted list, and inserts it there. It repeats
 *         until no input elements remain.
 * 
 *         Example 1:
 * 
 *         Input: 4->2->1->3 Output: 1->2->3->4 Example 2:
 * 
 *         Input: -1->5->3->4->0 Output: -1->0->3->4->5
 */
public class InsertionSortList147 {
	public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		ListNode cur = head;
		while (cur != null) {
			pre = dummy;
			// 从伪头结点的下一个结点开始，(注意判空)
			// 让pre指向小于cur.val的最大结点（升序）
			while (pre.next != null && pre.next.val < cur.val) {

				pre = pre.next;
			}
			// next暂存cur的下一个结点
			ListNode next = cur.next;
			// 把cur连接在pre后面
			// cur.next指向pre.next
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		return dummy.next;
	}

	public ListNode insertionSortList2(ListNode ptr) {
		if (ptr == null || ptr.next == null)
			return ptr;

		ListNode preInsert, toInsert, dummyHead = new ListNode(0);
		dummyHead.next = ptr;

		while (ptr != null && ptr.next != null) {
			if (ptr.val <= ptr.next.val) {
				ptr = ptr.next;
			} else {
				toInsert = ptr.next;
				// Locate preInsert.
				preInsert = dummyHead;
				while (preInsert.next.val < toInsert.val) {
					preInsert = preInsert.next;
				}
				ptr.next = toInsert.next;
				// Insert toInsert after preInsert.
				toInsert.next = preInsert.next;
				preInsert.next = toInsert;
			}
		}

		return dummyHead.next;
	}

	@Test
	public void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode node = insertionSortList2(n1);
		System.out.println(node);
	}

	public ListNode insertionSortList3(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		ListNode curr = head;
		while (curr != null) {
			prev = dummy;
			while (prev.next != null && prev.next.val < curr.val)
				prev = prev.next;
			// inset node to dummy
			ListNode next = curr.next;
			curr.next = prev.next;
			prev.next = curr;
			curr = next;
		}
		return dummy.next;
	}
}
