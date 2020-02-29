package LinkedList;

import static LinkedList.LinkedListT.printList;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import LinkedList.LinkedListT.Node;

/**
 * @author he.wu Given a linked list, determine if it has a cycle in it.
 * 
 *         To represent a cycle in the given linked list, we use an integer pos
 *         which represents the position (0-indexed) in the linked list where
 *         tail connects to. If pos is -1, then there is no cycle in the linked
 *         list.
 * 
 *         Example 1:
 * 
 *         Input: head = [3,2,0,-4], pos = 1 Output: true Explanation: There is
 *         a cycle in the linked list, where tail connects to the second node.
 * 
 * 
 *         Example 2:
 * 
 *         Input: head = [1,2], pos = 0 Output: true Explanation: There is a
 *         cycle in the linked list, where tail connects to the first node.
 * 
 * 
 *         Example 3:
 * 
 *         Input: head = [1], pos = -1 Output: false Explanation: There is no
 *         cycle in the linked list.
 */
public class LinkedListCycle141 {

	/**
	 * Definition for singly-linked list. class ListNode { int val; ListNode next;
	 * ListNode(int x) { val = x; next = null; } }
	 */

	public boolean hasCycle(Node head) {
		if (head == null || head.next == null) {
			return false;
		}
		Node slow = head;
		Node fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

	public boolean hasCycle2(Node head) {
		Set<Node> nodesSeen = new HashSet<>();
		while (head != null) {
			if (nodesSeen.contains(head)) {
				return true;
			} else {
				nodesSeen.add(head);
			}
			head = head.next;
		}
		return false;
	}

	@Test
	public void test() {
		LinkedListT l1 = new LinkedListT();
		l1 = l1.insert(l1, 2);
		l1 = l1.insert(l1, 4);
		l1 = l1.insert(l1, 3);
		l1 = l1.insert(l1, 2);
		printList(l1);
		System.out.println(hasCycle(l1.head));
	}
}
