package LinkedList;

import org.junit.Test;

import LinkedList.LinkedList.Node;

/**
 * @author he.wu Given a singly linked list, determine if it is a palindrome.
 * 
 *         Example 1:
 * 
 *         Input: 1->2 Output: false Example 2:
 * 
 *         Input: 1->2->2->1 Output: true
 */
public class PalindromeLinkedList234 {

	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode(int x) { val = x; } }
	 */

	@Test
	public void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		System.out.println(isPalindrome(n1));
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// recursion
	public boolean isPalindrome(ListNode head) {
		ListNode pointer = head;
		ListNode prev = head;
		while (head != null) {
			prev = head;
			head = head.next;
		}
		if (head.val != pointer.val)
			return false;
		pointer = pointer.next;
		prev.next = null;
		return isPalindrome(head);

	}
}
