package LinkedList;

import org.junit.Test;

public class MiddleLinkedList876 {
	public ListNode middleNode(ListNode head) {
		if (head.next == null)
			return head;
		ListNode[] nodes = new ListNode[100];
		int i = 0;
		while (head != null) {
			nodes[i] = head;
			head = head.next;
			i++;
		}
		return nodes[i  / 2];
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
		ListNode node = middleNode(n1);
		System.out.println(node);
	}
}
